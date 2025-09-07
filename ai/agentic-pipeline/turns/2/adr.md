# ADR 2: Normalize CustomerProfile JSON schema into PostgreSQL

Status: Accepted
Date: 2025-09-07

## Context
The system needs a relational schema for customer profiles based on the provided JSON schema. Tables must be normalized and include indexes and a flattened view for queries.

## Decision
Create separate tables for postal addresses, privacy settings, emails, and phone numbers. The root customer table references these tables and a view aggregates related data for read operations.

## Consequences
- Positive: Reduces duplication and supports flexible querying.
- Negative: Requires joins and seed data across multiple tables.
- Follow-up: Implement migration execution automation in future turns.
