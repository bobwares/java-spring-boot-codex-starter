# ADR 3: Scripted database migration execution

Status: Accepted
Date: 2025-09-09

## Context
Running SQL migrations manually with psql increases the chance of human error and inconsistent environments.

## Decision
Provide a Bash script that applies all migration files and expose it via a Makefile target for easy invocation.

## Consequences
- Positive: Developers can apply migrations with a single command.
- Negative: Requires local `psql` client.
- Follow-up: Integrate migration script into CI/CD pipeline.
