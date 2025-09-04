# Use Reactive Mono for Person Endpoint

**Status**: Accepted

**Date**: 2025-09-04

**Context**
An asynchronous CRUD API for person records was required. Choices included synchronous MVC controllers or reactive WebFlux.

**Decision**
Implement the endpoint using Spring WebFlux and reactive `Mono` types with an in-memory store.

**Consequences**
- Provides non-blocking scalability.
- Simplifies implementation without external persistence.
- Future persistence layers may require refactoring.
