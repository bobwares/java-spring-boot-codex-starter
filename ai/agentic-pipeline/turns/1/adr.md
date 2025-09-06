# ADR 1: Person CRUD Service with WebFlux

Status: Accepted
Date: 2025-09-06

## Context
The project requires a lightweight CRUD API for managing persons without persistent storage. The API must be reactive and documented via OpenAPI.

## Decision
Use Spring WebFlux with an in-memory `ConcurrentHashMap` to store `Person` records. Expose endpoints under `/api/persons` and document them using springdoc OpenAPI annotations.

## Consequences
- Positive: No external database dependency; low overhead and fast development.
- Negative: Data is ephemeral and lost on application restart.
- Follow-up: Introduce persistent storage in a future iteration if needed.
