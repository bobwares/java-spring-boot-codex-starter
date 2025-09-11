# Tool — Flyway: Baseline and Migrations

## Purpose
Convert DDL output into Flyway-compliant migration files, create baseline if none exists.

## Inputs
- DDL SQL from db-json_schema_to_sql_ddl.tool.md

## Output
- src/main/resources/db/migration/V1__baseline.sql (schema create)
- src/main/resources/db/migration/V2__<domain>_tables.sql (normalized tables/indexes)
