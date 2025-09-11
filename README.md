# Agentic Pipeline Code Generator — (ChatGPT Codex Web Interface)

This README explains how to operate the agentic pipeline entirely through the ChatGPT Codex web interface—no CLI. You will drive each “turn” by pasting structured prompts that reference the repository’s context files and the task/tool specs under `ai/agentic-pipeline/`.

---

## What the pipeline does

Each execution (“turn”) plans work, invokes tasks that call tools (prompts-as-tools), and records evidence:

* Inputs: Codex session context, domain schemas, and task definitions
* Generation: DDL, test data, persistence, REST API, tests, E2E `.http`
* Evidence: manifest, ADR, changelog, logs, and a suggested `diff.patch`
* Conventions: metadata headers on generated files; Spring MVC + JPA + Postgres stack; no `version.md`

Repository layout (abridged):

```
project_root/AGENTS.md
project_root/ai/agentic-pipeline/context/
  Agentic_Pipeline_Definition.md
  Turns_Technical_Design.md
  codex_session_context.md
  tech-stack.md
  schemas/
    customer.schema.json
    person.schema.json
project_root/ai/agentic-pipeline/tasks/
  initialize_app.task.md
  create_sql_ddl_from_schema.task.md
  create_persistence_layer.task.md
  create_rest_service.task.md
  create_app.task.md
project_root/ai/agentic-pipeline/tools/
  maven-replace_maven_pom_elements.tool.md
  db-json_schema_to_sql_ddl.tool.md
  db-create_test_data_for_schema.tool.md
  persistence-generate_persistence_code.tool.md
  rest-generate_rest_api.tool.md
project_root/ai/agentic-pipeline/turns/
  index.csv
  <Turn directories created per run>/
```

---

## Operating model: Turns via ChatGPT Codex

You will paste prompts that tell Codex what to load, what task to run, and how to emit artifacts. Use the following three-phase loop each time:

1. Initialize turn
2. Execute task(s)
3. Record artifacts

### 1) Initialize a new turn

Paste this prompt:

```
Load repository context and initialize a new turn.

1) Open and read:
- project_root/AGENTS.md
- project_root/ai/agentic-pipeline/context/Agentic_Pipeline_Definition.md
- project_root/ai/agentic-pipeline/context/Turns_Technical_Design.md
- project_root/ai/agentic-pipeline/context/codex_session_context.md
- project_root/ai/agentic-pipeline/context/tech-stack.md

2) Determine the next Turn ID by reading project_root/ai/agentic-pipeline/turns/index.csv.
- If empty, Turn ID = 1; else increment the last turnId.

3) Create in-memory scaffolding for:
- ai/agentic-pipeline/turns/<TurnID>/manifest.json (seed with initiator, timestamp, task name placeholder)
- ai/agentic-pipeline/turns/<TurnID>/changelog.md (empty section)
- ai/agentic-pipeline/turns/<TurnID>/adr.md (empty template)
- ai/agentic-pipeline/turns/<TurnID>/logs/ (will hold prompt and response)
- ai/agentic-pipeline/turns/<TurnID>/reports/ (optional)

4) Echo: the resolved Turn ID, timestamp (UTC), and the files you will write on completion.
```

Expected Codex response: it confirms the Turn ID and shows seeded artifact structures it plans to write.

### 2) Execute a task (through tasks and tools)

For a full app slice, use the orchestrating task:

```
Execute task: create_app.task.md

Order of execution:
1) initialize_app.task.md
   - Tool: maven-replace_maven_pom_elements.tool.md
2) create_sql_ddl_from_schema.task.md
   - Tools: db-json_schema_to_sql_ddl.tool.md, db-create_test_data_for_schema.tool.md
3) create_persistence_layer.task.md
   - Tool: persistence-generate_persistence_code.tool.md
4) create_rest_service.task.md
   - Tool: rest-generate_rest_api.tool.md

Inputs:
- Use codex_session_context.md for Maven coordinates, author, project name/description, and the persisted data schema path.
- Use schemas under ai/agentic-pipeline/context/schemas/ as the source of truth.

Constraints:
- Spring MVC + Spring Data JPA + Postgres 16; no WebFlux.
- Entities and columns must match generated DDL; no naming drift.
- Every generated source/config file (except pom.xml) must include the standard metadata header.

Deliverables to produce and show inline:
- DDL: db/migrations/NN_<domain>_.sql (PostgreSQL 16, IF NOT EXISTS, indexes, FKs)
- Test data: db/scripts/<domain>_test_data.sql (idempotent; ON CONFLICT DO NOTHING; ≥20 rows)
- Persistence: src/main/java/com/bobwares/customer/registration/{Customer,CustomerRepository,CustomerService}.java
- REST API: DTOs, Controller, exception handler, tests, e2e/<Domain>.http
- Update project_root/ai/agentic-pipeline/turns/<TurnID>/manifest.json with file list and metrics
```

If you only want one step (e.g., DDL only), reference the single task and its tool instead of `create_app.task.md`.

### 3) Record artifacts

After Codex shows generated files, ask it to produce the evidence and the index row:

```
Record and finalize artifacts for Turn <TurnID>.

1) Generate ai/agentic-pipeline/turns/<TurnID>/changelog.md summarizing added/modified files and SemVer impact.
2) Generate ai/agentic-pipeline/turns/<TurnID>/adr.md capturing the key architectural decision(s) taken this turn.
3) Generate ai/agentic-pipeline/turns/<TurnID>/manifest.json (final):
   - turnId, timestampUtc, initiator, agent version
   - task name and inputs
   - artifacts (paths)
   - changes {added, modified, deleted}
   - metrics: filesChanged, linesAdded, linesDeleted; test results if available
   - validation flags (adrPresent, changelogPresent)
4) Generate a suggested unified diff as ai/agentic-pipeline/turns/<TurnID>/diff.patch that reflects the created/updated files.
5) Append a CSV line to ai/agentic-pipeline/turns/index.csv with the roll-up for this turn.
6) Echo all new/updated file paths and their first 10 lines for verification.
```

You will then copy these files into your working tree exactly as shown.

---

## Manual Git integration (no CLI)

Perform these steps locally after you copy the generated files into your repo:

```
git checkout -b turn/<TurnID>-<short-task-name>
git add .
git commit -m "turn: <TurnID> <task> [scope]"
git tag turn/<TurnID>
git push --set-upstream origin turn/<TurnID>-<short-task-name>
git push --tags
```

Optional: open a PR referencing the Turn ID and attach `ai/agentic-pipeline/turns/<TurnID>/` artifacts.

---

## Required conventions

* Metadata header at the top of every generated source/config/test (except `pom.xml`).
* Spring Boot 3.5.x + Java 21; Spring MVC (not WebFlux).
* JPA/Hibernate 6 + PostgreSQL 16; `open-in-view: false` assumed.
* Table/column names must match the DDL generated from the JSON Schema.
* No `version.md`; use per-file metadata and turn artifacts for traceability.

---

## Checklists

### Before you start

* codex\_session\_context.md has correct Maven coordinates, author, and schema paths.
* Schema files exist under `context/schemas/` and validate.

### After task execution

* DDL present under `db/migrations/` with indexes and FKs.
* Test data SQL idempotent and ≥20 inserts.
* Entities map 1:1 to DDL; repository/service compile logically.
* REST endpoints, DTOs, exception handler, unit + integration tests, and `e2e/<Domain>.http` exist.
* Artifacts written under `ai/agentic-pipeline/turns/<TurnID>/`.

---

## Troubleshooting

* Missing or mismatched schema path
  Fix the path in `codex_session_context.md`; re-run the specific sub-task only.

* Entity/DDL drift
  Re-run the persistence tool with the DDL open; ensure column names and constraints match exactly.

* Integration tests fail to connect to Postgres
  If Testcontainers isn’t on the classpath, start a local Postgres and set env:
  `APP_PORT=8080,COMPOSE_PROJECT_NAME=customer-registration-service,DB_HOST=localhost,DB_PORT=5432,DB_NAME=app,DB_USERNAME=admin,DB_PASSWORD=abc123`

* Over-generation or wrong stack (e.g., WebFlux)
  Restate the non-functional constraints in your prompt and re-run only the offending step.

---

## Extending the pipeline

* New tool: add `ai/agentic-pipeline/tools/<name>.tool.md` with purpose, inputs, constraints, output format, and acceptance criteria.
* New task: compose tools in `ai/agentic-pipeline/tasks/<name>.task.md`.
* To run it, instruct Codex explicitly: “Execute task: `<name>.task.md` with inputs … and deliverables …”

---
