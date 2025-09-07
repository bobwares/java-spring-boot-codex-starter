<!--
App: Customer Profile CRUD Service
Package: db
File: README.md
Version: 0.1.0
Turns: 2
Author: AI Agent
Date: 2025-09-07T15:16:44Z
Exports: Documentation
Description: Instructions for running migrations and loading test data for the customer profile database schema.
-->

# Database Migrations

## Domain Migration

To initialize the customer profile schema and seed test data locally:

```bash
# Apply migrations
psql -f db/migrations/01_customer_profile_tables.sql

# Load test data
psql -f db/scripts/customer_test_data.sql

# Smoke test
psql -c "SELECT COUNT(*) FROM customer;"
```

Ensure PostgreSQL 16 is running and accessible via `psql` before executing the scripts.
