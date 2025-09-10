# TASK A-Pipeline: Docker + Maven + Spring Env

## Inputs

* Project name: `my-spring-app`
* Group ID: `com.bobwares`
* Artifact ID: `app`
* Java version: `21`
* Spring Boot version: `3.5.5`
* DB name: `mydb`
* DB user: `myuser`
* DB password: `secret`
* App port: `8080`
* DB port: `5432`

## Workflow

1. execute tool `project_root/ai/agentic-pipeline/tools/docker-postgres.prompt.md`

    * Ensures `docker-compose.yml`, `.env.example`, and `.gitignore` entry for `.env`.

2. execute tool `project_root/ai/agentic-pipeline/tools/maven-java21-spring.prompt.md`

    * Updates `pom.xml` for Java 21, Spring Boot 3.5.5, Postgres driver, and Testcontainers.

3. execute tool `project_root/ai/agentic-pipeline/tools/spring-config-env.prompt.md`

    * Creates/updates `application.yml`, `application-local.yml`, and `application-test.yml` to use `.env` for local credentials.
