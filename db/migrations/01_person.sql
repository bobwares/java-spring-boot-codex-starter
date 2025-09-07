-- App: Person CRUD Service
-- Package: com.bobwares.registration
-- File: 01_person.sql
-- Version: 0.1.0
-- Turns: 2
-- Author: Codex
-- Date: 2025-09-07T01:22:38Z
-- Exports: person table
-- Description: Creates normalized table for storing person records.

BEGIN;

CREATE TABLE IF NOT EXISTS person (
    person_id   SERIAL PRIMARY KEY,
    first_name  VARCHAR(255) NOT NULL,
    last_name   VARCHAR(255) NOT NULL,
    city        VARCHAR(255) NOT NULL,
    state       CHAR(2) NOT NULL,
    zip         VARCHAR(10) NOT NULL
);

COMMIT;
