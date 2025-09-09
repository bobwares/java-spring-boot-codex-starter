<!--
App: Customer Registration
Package: db
File: README.md
Version: 0.1.0
Turns: 2
Author: Codex
Date: 2025-09-09T22:44:34Z
Exports: migration instructions
Description: Describes how to apply database migrations and seed test data.
-->

# Database Migrations

## Domain Migration

To apply the customer profile migration and load test data locally:

```bash
psql -f migrations/01_customer_profile_tables.sql
psql -f scripts/customer_profile_test_data.sql
```

The smoke test at the end of the script verifies row counts.
