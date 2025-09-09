<!--
App: Customer Registration
Package: db
File: README.md
Version: 0.2.0
Turns: 2,3
Author: AI Agent
Date: 2025-09-09T19:18:27Z
Exports: migration usage
Description: Documentation for running database migrations and smoke tests.
-->

# Database Migrations

## Domain Migration

To apply the customer profile migration locally:

1. Start PostgreSQL:
   ```bash
   make docker-up
   ```
2. Run the migration script:
   ```bash
   make db-migrate
   # or: ./db/apply_migrations.sh
   ```
3. Smoke test tables exist:
   ```bash
   psql -c "\dt customer_profile.*"
   ```
4. Stop services when finished:
   ```bash
   make docker-down
   ```
