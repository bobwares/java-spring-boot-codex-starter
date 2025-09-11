# ADR 2: Use Spring MVC with JPA for Customer Registration

**Status**: Accepted

**Date**: 2025-09-10

**Context**
The starter project used WebFlux, but the Customer Registration service requires synchronous CRUD operations backed by JPA and PostgreSQL.

**Decision**
Adopt Spring MVC with Spring Data JPA and generate entities, repositories, services, and controllers for the customer domain.

**Consequences**
- Positive: Familiar programming model and comprehensive library support.
- Negative: Loses non-blocking advantages of WebFlux.
