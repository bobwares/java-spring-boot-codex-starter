# Adopt metadata headers and Makefile

**Status**: Accepted

**Date**: 2025-09-04

**Context**  
The project did not include consistent metadata headers or a standard build interface, complicating maintenance and developer onboarding.

**Decision**  
Add metadata headers to source, test, and configuration files and provide a Makefile to wrap common Maven build and test operations.

**Consequences**  
- Improves traceability and documentation of project files.
- Offers a consistent developer experience via simple `make` commands.
- Introduces the need to maintain headers and Makefile alongside code changes.
