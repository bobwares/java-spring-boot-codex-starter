# Turn 2 — Changelog
Date (UTC): 2025-09-09T22:44:34Z
Task: create_app

## Summary
Set Maven coordinates, generate database artifacts, add JPA entities, and implement Customer CRUD API with tests.

## Changes
- Modified pom.xml for Customer Registration project.
- Added SQL migration and test data from customer schema.
- Introduced JPA entities and repository.
- Implemented asynchronous Customer CRUD REST API with tests and e2e scenario.

## Migrations
- Added customer profile tables and sample data.

## SemVer Impact
- Minor: new API and persistence layers added.

## Risks & Mitigations
- Risk: In-memory service may diverge from JPA entities. Mitigation: integrate persistence in future turns.

## Linked Artifacts
- ADR: ./adr.md
- Manifest: ./manifest.json
