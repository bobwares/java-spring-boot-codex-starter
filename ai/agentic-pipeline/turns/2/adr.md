# Adopt Spring MVC + JPA + Flyway + Testcontainers as baseline for synchronous CRUD services

**Status**: Accepted

**Date**: 2025-09-11

**Context**
Need a standard synchronous CRUD stack with database migrations and testing support.

**Decision**
Adopt Spring MVC with JPA, Flyway, Testcontainers, and Micrometer tracing as the default pattern.

**Consequences**
- Provides consistent scaffolding for REST services.
- Increases initial project complexity but streamlines future turns.
