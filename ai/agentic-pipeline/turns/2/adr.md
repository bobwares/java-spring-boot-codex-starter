# ADR 2: Initial Customer Registration Service

**Status**: Accepted

**Date**: 2025-09-09

## Context
We need a foundation for the Customer Registration service including database structure and API endpoints based on the provided schema.

## Decision
Define database migrations and JPA entities from the customer schema and implement an asynchronous WebFlux CRUD API using an in-memory store.

## Consequences
- Provides working endpoints and schema-aligned persistence layer.
- Requires future integration between API and JPA repositories.
