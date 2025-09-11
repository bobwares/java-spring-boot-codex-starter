# Tool — Maven: Apply Dependencies and Plugins (Java 21 / Spring Boot 3.5.x)

## Purpose
Ensure pom.xml includes Spring Boot parent or BOM, Java 21 toolchain, and required deps/plugins for the pattern.

## Inputs
- groupId, artifactId, name, description
- dependency set:
  - spring-boot-starter-web
  - spring-boot-starter-data-jpa
  - org.postgresql:postgresql (runtime)
  - org.springdoc:springdoc-openapi-starter-webmvc-ui
  - org.flywaydb:flyway-core
  - org.testcontainers:postgresql (test)
  - io.micrometer:micrometer-tracing-bridge-otel (runtime)
  - io.opentelemetry:opentelemetry-exporter-otlp (runtime)

## Behavior
- If missing, set:
  - <parent> org.springframework.boot:spring-boot-starter-parent:3.5.x
  - maven-compiler-plugin release 21
  - maven-surefire-plugin (junit-platform)
- Idempotent XML edits (preserve formatting)

## Output
- Updated pom.xml
