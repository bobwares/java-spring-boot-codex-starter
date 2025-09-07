# ADR 2: Person Table Schema and Test Data

Status: Accepted
Date: 2025-09-07

## Context
We needed to persist person records based on existing JSON request schema.

## Decision
Create a single `person` table with columns for first name, last name, city, state, and zip. Provide idempotent test data script for development.

## Consequences
- Positive: Prepares project for database persistence.
- Negative: Lacks additional normalization for addresses; may need future enhancement.
- Follow-up: Add indexes and related tables as domain grows.
