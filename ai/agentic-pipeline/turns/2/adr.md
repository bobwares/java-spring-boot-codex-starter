# ADR 2: Relational schema for customer profile

Status: Accepted
Date: 2025-09-09

## Context
The project requires a PostgreSQL schema to persist customer profile data defined by a JSON schema.

## Decision
Create normalized tables (customer, postal_address, privacy_settings, customer_email, customer_phone_number) under a `customer_profile` schema with required indexes and constraints.

## Consequences
- Positive: Maintains data integrity and supports future expansion.
- Negative: Introduces migration management overhead.
- Follow-up: Implement persistence layer using these tables.
