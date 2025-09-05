# Use WebFlux with In-Memory Store for Person CRUD

**Status**: Accepted

**Date**: 2025-09-05

**Context**
A simple asynchronous CRUD API was required for a person domain without external dependencies.

**Decision**
Implemented a Spring WebFlux service with an in-memory `ConcurrentHashMap` and exposed endpoints annotated with springdoc OpenAPI.

**Consequences**
- Positive: No external database needed; fast and asynchronous.
- Negative: Data is volatile and not shared across instances.
