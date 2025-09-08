# Configure Postgres with Docker and env profiles

**Status**: Accepted

**Date**: 2025-09-08

**Context**
Local development requires a reproducible Postgres instance and Spring to source credentials from environment variables.

**Decision**
Use Docker Compose to run Postgres 16 and load credentials from a `.env` file. Update Spring configuration and Maven dependencies accordingly.

**Consequences**
Provides consistent local database setup and enables Testcontainers for integration tests, at the cost of additional configuration files.
