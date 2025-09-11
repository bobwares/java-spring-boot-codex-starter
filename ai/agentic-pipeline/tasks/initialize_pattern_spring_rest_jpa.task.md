# Task — Initialize Pattern: Spring REST + JPA (Synchronous)

## Summary
Provision a Spring Boot REST service backed by JPA/Hibernate on PostgreSQL with Flyway migrations, OpenAPI docs, Testcontainers-based integration tests, operational observability, and an E2E HTTP scenario. Sources of truth: Codex Session Context and domain JSON Schema.

## Inputs (from Codex Session Context)
- Project
  - Name
  - Author
- Maven
  - groupId
  - artifactId
  - name
  - description
- Domain
  - Domain Object (singular)
  - Persisted Data schema (JSON)
- Tech assumptions
  - Java 21, Spring Boot 3.5.x, Hibernate 6.x, PostgreSQL 16

## Orchestration (tools in order)
1. maven-apply_dependencies.tool.md
2. spring-boot-apply_configuration.tool.md
3. schema-lint_and_normalize.tool.md
4. db-json_schema_to_sql_ddl.tool.md
5. flyway-baseline_and_migration.tool.md
6. persistence-generate_persistence_code.tool.md
7. rest-generate_rest_api.tool.md
8. problem-json-error_handling.tool.md
9. testcontainers-setup_postgres.tool.md
10. micrometer-otel-setup.tool.md
11. e2e-http_scenario.tool.md
12. ci-validate_turn.tool.md

## Expected Outputs (minimum set)
- pom.xml updated with required dependencies/plugins
- src/main/resources/application.yml (+ application-local.yml)
- src/main/resources/db/migration/V1__baseline.sql (and next migrations)
- src/main/java/{{groupIdPath}}/{{artifactId}}/{{Domain}}.java
- src/main/java/{{groupIdPath}}/{{artifactId}}/{{Domain}}Repository.java
- src/main/java/{{groupIdPath}}/{{artifactId}}/{{Domain}}Service.java
- src/main/java/{{groupIdPath}}/{{artifactId}}/api/{{Domain}}Dto.java
- src/main/java/{{groupIdPath}}/{{artifactId}}/api/{{Domain}}Controller.java
- src/main/java/{{groupIdPath}}/{{artifactId}}/web/RestExceptionHandler.java
- src/test/java/{{groupIdPath}}/{{artifactId}}/PostgresTestContainer.java
- src/test/java/{{groupIdPath}}/{{artifactId}}/{{Domain}}ControllerIT.java
- e2e/{{Domain}}.http
- ai/artifacts/schema-report.json
- turns/<TurnID>/{manifest.json, adr.md, changelog.md, diff.patch}
- .github/workflows/turn-validate.yml

## Acceptance Criteria
- Build: mvn -q -DskipTests=false verify passes
- DB: Flyway migrates cleanly in integration tests (Testcontainers Postgres)
- API: OpenAPI UI available at /swagger-ui.html; models render
- REST: CRUD IT covers happy-path and 404/409; E2E .http runs end-to-end
- Observability: Actuator health, metrics, and tracing beans present
- Lint: schema-lint report produced; task returns status: "success" with file list

## Result Format
Return a JSON object:
{
  "status": "success",
  "files": [ { "path": "...", "content": "..." }, ... ],
  "metrics": { "filesCreated": N, "testsAdded": M }
}
