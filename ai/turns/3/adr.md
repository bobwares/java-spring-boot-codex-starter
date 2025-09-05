# Use WebFlux with in-memory store for person registration

**Status**: Accepted

**Date**: 2025-09-05

**Context**
The service requires asynchronous CRUD endpoints for person data without a persistent database.

**Decision**
Use Spring WebFlux with `Mono` types and a concurrent in-memory map to store persons.

**Consequences**
- Positive: Non-blocking API with minimal infrastructure.
- Negative: Data is volatile and lost on restart; not suitable for production persistence.
