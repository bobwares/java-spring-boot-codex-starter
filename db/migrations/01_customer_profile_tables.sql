/*
 * App: Customer Profile CRUD Service
 * Package: db
 * File: 01_customer_profile_tables.sql
 * Version: 0.1.0
 * Turns: 2
 * Author: AI Agent
 * Date: 2025-09-07T15:16:48Z
 * Exports: tables postal_address, privacy_settings, customer, customer_email, customer_phone_number; view customer_profile_view
 * Description: Creates normalized PostgreSQL tables and view for customer profiles.
 */

BEGIN;

CREATE SCHEMA IF NOT EXISTS customer_profile;
SET search_path TO customer_profile, public;

/* Reference tables */
CREATE TABLE IF NOT EXISTS postal_address (
    address_id SERIAL PRIMARY KEY,
    line1 VARCHAR(255) NOT NULL,
    line2 VARCHAR(255),
    city VARCHAR(100) NOT NULL,
    state VARCHAR(50) NOT NULL,
    postal_code VARCHAR(20),
    country CHAR(2) NOT NULL
);

CREATE TABLE IF NOT EXISTS privacy_settings (
    privacy_settings_id SERIAL PRIMARY KEY,
    marketing_emails_enabled BOOLEAN NOT NULL,
    two_factor_enabled BOOLEAN NOT NULL
);

/* Root entity */
CREATE TABLE IF NOT EXISTS customer (
    customer_id UUID PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255),
    last_name VARCHAR(255) NOT NULL,
    address_id INT REFERENCES postal_address(address_id),
    privacy_settings_id INT REFERENCES privacy_settings(privacy_settings_id)
);
CREATE INDEX IF NOT EXISTS idx_customer_address_id ON customer (address_id);
CREATE INDEX IF NOT EXISTS idx_customer_privacy_settings_id ON customer (privacy_settings_id);

/* Collections */
CREATE TABLE IF NOT EXISTS customer_email (
    email_id SERIAL PRIMARY KEY,
    customer_id UUID NOT NULL REFERENCES customer(customer_id) ON DELETE CASCADE,
    email VARCHAR(255) NOT NULL,
    UNIQUE (customer_id, email)
);
CREATE INDEX IF NOT EXISTS idx_customer_email_customer_id ON customer_email (customer_id);

CREATE TABLE IF NOT EXISTS customer_phone_number (
    phone_id SERIAL PRIMARY KEY,
    customer_id UUID NOT NULL REFERENCES customer(customer_id) ON DELETE CASCADE,
    type VARCHAR(20) NOT NULL,
    number VARCHAR(15) NOT NULL,
    UNIQUE (customer_id, number)
);
CREATE INDEX IF NOT EXISTS idx_customer_phone_customer_id ON customer_phone_number (customer_id);

/* Flattened view */
CREATE OR REPLACE VIEW customer_profile_view AS
SELECT c.customer_id,
       c.first_name,
       c.middle_name,
       c.last_name,
       a.line1,
       a.line2,
       a.city,
       a.state,
       a.postal_code,
       a.country,
       ps.marketing_emails_enabled,
       ps.two_factor_enabled,
       COALESCE(array_agg(DISTINCT e.email) FILTER (WHERE e.email IS NOT NULL), '{}') AS emails,
       COALESCE(json_agg(json_build_object('type', pn.type, 'number', pn.number)) FILTER (WHERE pn.phone_id IS NOT NULL), '[]') AS phone_numbers
FROM customer c
LEFT JOIN postal_address a ON c.address_id = a.address_id
LEFT JOIN privacy_settings ps ON c.privacy_settings_id = ps.privacy_settings_id
LEFT JOIN customer_email e ON c.customer_id = e.customer_id
LEFT JOIN customer_phone_number pn ON c.customer_id = pn.customer_id
GROUP BY c.customer_id, a.address_id, ps.privacy_settings_id;

COMMIT;
