<!--
App: Customer Registration
Package: db
File: README.md
Version: 0.1.0
Turns: 2
Author: AI
Date: 2025-09-10T16:44:42Z
Exports: database migration docs
Description: Instructions for executing migrations and loading test data.
-->

# Database Migrations

## Domain Migration

Run migrations and load test data using `psql`:

```bash
psql $DATABASE_URL -f db/migrations/01_customer_tables.sql
psql $DATABASE_URL -f db/scripts/customer_test_data.sql
```

Smoke test the data:

```bash
psql $DATABASE_URL -c 'SELECT COUNT(*) FROM customer;'
```
