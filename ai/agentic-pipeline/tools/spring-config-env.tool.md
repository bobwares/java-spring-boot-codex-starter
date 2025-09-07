
# Description

Configures Spring Boot to use .env for local credentials and clean defaults for JPA/Logging. Adds test profile baseline. No secret values are committed.

## Intent

Enable local development to source DB connection details from environment variables (.env loaded into shell or via Compose) and keep higher environments decoupled.

## Inputs (Agentic Context)

* project\_name: String (default: my-spring-app)

## Outputs

* src/main/resources/application.yml created/merged
* src/main/resources/application-local.yml created/merged
* src/test/resources/application-test.yml created/merged
* README.md snippet appended if missing

## Guardrails

* Do not hardcode secrets.
* Only add/merge keys; don’t obliterate unrelated configuration.

## Tasks

1. Create/merge src/main/resources/application.yml:

```yaml
spring:
  application:
    name: ${COMPOSE_PROJECT_NAME:${project_name:my-spring-app}}

  datasource:
    url: jdbc:postgresql://${DB_HOST:localhost}:${DB_PORT:5432}/${DB_NAME:mydb}
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true
    show-sql: true

logging:
  level:
    root: INFO
```

2. Create/merge src/main/resources/application-local.yml:

```yaml
spring:
  datasource:
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
```

3. Create/merge src/test/resources/application-test.yml:

```yaml
spring:
  jpa:
    hibernate:
      ddl-auto: update
```

4. README.md snippet (append once):

```
## Running with Local Profile and .env
cp .env.example .env
export $(grep -v '^#' .env | xargs) && mvn spring-boot:run -Dspring-boot.run.profiles=local
# If using Docker Compose for the app container, Compose will inject env automatically.
```

## Acceptance Criteria

* With `.env` exported and Postgres running, `mvn spring-boot:run -Dspring-boot.run.profiles=local` connects using DB\_USERNAME/DB\_PASSWORD/DB\_HOST/DB\_PORT/DB\_NAME.
* No secrets are committed into the repo.

## Idempotency Rules

* Merge by top-level YAML keys; avoid duplicate keys.
* Only append the README section once (detect by heading).
