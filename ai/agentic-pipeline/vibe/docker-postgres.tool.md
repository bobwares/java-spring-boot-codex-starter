# Description: 

Adds/updates docker-compose.yml for a Postgres 16 service and provides a .env.example. Ensures .env is ignored. No binary artifacts are added.

## Intent

Provision a reproducible local Postgres via Docker Compose using environment variables loaded from .env for developer machines.

## Inputs (Agentic Context)

* project\_name: String (default: spring-app)
* db\_name: default mydb
* db\_user: default myuser
* db\_password: default secret
* app\_port: default 8080
* db\_port: default 5432

## Outputs

* docker-compose.yml created/updated at repo root
* .env.example created/updated
* .gitignore updated to include .env (if not present)

## Guardrails

* Idempotent edits; merge service blocks if docker-compose.yml exists.
* Never commit .env; only .env.example.
* No mvnw or other binaries.

## Tasks

1. Create or patch docker-compose.yml:

```yaml
version: "3.9"
services:
  postgres:
    image: postgres:16
    container_name: ${COMPOSE_PROJECT_NAME:-${project_name:-spring-app}}-postgres
    environment:
      POSTGRES_DB: ${DB_NAME:-mydb}
      POSTGRES_USER: ${DB_USERNAME:-myuser}
      POSTGRES_PASSWORD: ${DB_PASSWORD:-secret}
    ports:
      - "${DB_PORT:-5432}:5432"
    volumes:
      - pgdata:/var/lib/postgresql/data
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U ${DB_USERNAME:-myuser} -d ${DB_NAME:-mydb}"]
      interval: 10s
      timeout: 5s
      retries: 10
volumes:
  pgdata:
```

2. Create/patch .env.example:

```
# App
APP_PORT=8080
COMPOSE_PROJECT_NAME=my-spring-app

# Database
DB_HOST=localhost
DB_PORT=5432
DB_NAME=mydb
DB_USERNAME=myuser
DB_PASSWORD=secret
```

3. Ensure .gitignore contains:

```
.env
```

4. README.md snippet (append once if a marker isn’t present):

```
## Local DB via Docker
cp .env.example .env
docker compose up -d postgres
```

## Acceptance Criteria

* `docker compose up -d postgres` starts a healthy Postgres 16.
* .env is ignored; .env.example exists with sane defaults.

## Idempotency Rules

* Merge by service name “postgres”; update image/env/ports/healthcheck without duplicating entries.
* Only append README once (detect by heading text).



