
# Tool – Generate Async CRUD with OpenAPI, Unit Tests, and E2E HTTP

## Role

You are an expert Java Spring Boot engineer. Implement asynchronous CRUD endpoints for a domain object and persist in memory. Produce code, tests, and an E2E `.http` file that exercises the full lifecycle. Conform to the repository’s metadata and versioning rules.


## Inputs

codex_session_context variables.

### Project

  - Name: Customer Registration
  - Detailed Description
  - Author: Bobwares ([bobwares@outlook.com](mailto:bobwares@outlook.com))

#### Maven

  - groupId
  - artifactId
  - name
  - description

#### Domain
  - Domain Object
  - REST API Request Schema
  - REST API Response Schema
  - Persisted Data schema

## Objectives

1. Create a WebFlux REST API in package {{groupId}}/{{artifactId}} for objects {{REST API Request Schema}} and {{REST API Response Schema}}.
2. Annotate endpoints with OpenAPI annotations.
3. Validate input using Jakarta Bean Validation.
4. Persist in a repository 
5. Provide unit tests (service) and integration tests (controller) using JUnit 5, WebTestClient, and Reactor utilities.
6. Provide an `.http` file covering create → read → update → delete E2E.
7. Conform to the project’s AGENTS.md metadata header standard and versioning.

## Non-functional Constraints
- do not modify code under package health.
- create interfaces for services
- Java 21, Spring Boot 3.5.x, WebFlux.
- OpenAPI via springdoc for WebFlux.
- No database dependency; use `ConcurrentHashMap<UUID, Person>`.
- JSON field names use snake\_case; map to Java record fields.
- services should be annotated @Service.

## Deliverables (create or update)

1. API and Domain

- `src/main/java/{{groupId}}/{{artifactId}}/{{Domain Object}}.java` (record; id UUID; snake\_case mapping)
- `src/main/java/{{groupId}}/{{artifactId}}/{{Domain Object}}Request.java` (record; fields from schema with validation)
- `src/main/java/{{groupId}}/{{artifactId}}/{{Domain Object}}Service.java` (CRUD against `ConcurrentHashMap`)
- `src/main/java/{{groupId}}/{{artifactId}}/{{Domain Object}}NotFoundException.java` (404)
- `src/main/java/{{groupId}}/{{artifactId}}/{{Domain Object}}Controller.java`

    - Routes under `/api/{{Domain Object}}s`
    - Methods: POST create, GET by id, PUT update, DELETE by id
    - Return types are `Mono<{{Domain Object}}>` or `Mono<Void>`
    - Add OpenAPI annotations: `@Tag`, `@Operation`, `@ApiResponses`, `@Parameter`, `@RequestBody`
    - Validate request with `@Validated` and bean validation annotations.

2. OpenAPI and Config

- Ensure springdoc is active; expose UI at `/swagger-ui.html`.
- If an `application.yml` exists, set `spring.application.name: common` or as appropriate.

3. Tests

- Unit test `{{Domain Object}}ServiceTests`

    - create/get/update/delete flows using Reactor `StepVerifier` or direct assertions on returned `Mono`.
- Integration test `{{Domain Object}}ControllerIT`

    - `@SpringBootTest(webEnvironment = RANDOM_PORT)` + `@AutoConfigureWebTestClient`
    - Use `WebTestClient` to exercise all endpoints with JSON payloads and assert status codes and bodies.

4. E2E HTTP Scenario

- `e2e/{{Domain Object}}.http` that performs:

    - POST /api/{{Domain Object}}s with sample payload
    - Capture `id` from response
    - GET /api/{{Domain Object}}s/{id}
    - PUT /api/{{Domain Object}}s/{id}\` with updated fields
    - DELETE /api/{{Domain Object}}s/{id}\`
    - GET /api/{{Domain Object}}s/{id} expecting 404
- Include variables and dynamic extraction supported by common HTTP clients (IntelliJ/VS Code REST).


## Implementation Details

### Schema → DTO Mapping

- Map `{{Domain Object}}.schema.json` fields exactly to `{{Domain Object}}Request` fields.
- `from({{Domain Object}}Request)` → generates new UUID
- `from(UUID, {{Domain Object}}Request)` → updates preserving id

Validation

- `@NotBlank` for textual fields; `@Size(min=2,max=2)` for state; `@Pattern("^[0-9]{5}(-[0-9]{4})?$")` for zip.

### OpenAPI

- Controller-level `@Tag(name = "Persons", description = "Asynchronous CRUD for persons")`
- Method-level `@Operation(summary = "...", description = "...")` with accurate request/response schemas.
- Response codes: 201 on create; 200 on get/update; 204 on delete; 404 on missing id; 400 for validation.

### Error Handling

- Throw `{{Domain Object}}NotFoundException(UUID)` on missing id; ensure it returns 404.

### Concurrency

- Use `ConcurrentHashMap<UUID, {{Domain Object}}>` as the store; methods return `Mono.just(...)` or `Mono.empty()` as appropriate.

### Testing Requirements

Service Unit Tests

- Create {{Domain Object}}; assert id is non-null and fields persist.
- Update existing; assert replaced fields.
- Delete; assert subsequent get fails with 404.

Controller Integration Tests

- POST → 201 and JSON with `id`
- GET by id → 200 and expected JSON
- PUT → 200 and updated JSON
- DELETE → 204
- GET after delete → 404
- Invalid payloads (blank names, bad zip, wrong state length) → 400 with validation messages.

E2E HTTP File Requirements (`e2e/{{Domain Object}}.http`)

- Base URL variable (e.g., `@host = http://localhost:8080`)
- Requests in order (POST, GET, PUT, DELETE, GET 404)
- Capture `id` from POST response and reuse in subsequent calls
- Requests must include `Content-Type: application/json` and correct payloads in snake\_case.

Output Format

- Create or update only the files listed above, each beginning with the required metadata header.
- Do not include binary files.
- Provide a final code block containing the `.http` file contents.

Acceptance Criteria

- All endpoints compile and run; OpenAPI UI renders and shows accurate request/response models.
- Unit and integration tests pass locally (`mvn -q -DskipITs=false test`).
- The `.http` file runs cleanly end-to-end against a local server.
- Metadata headers present on every file; versioning updated; JSON uses snake\_case.


