# Tool — Spring Boot: Apply Base Configuration

## Purpose
Create application.yml and application-local.yml with datasource, JPA, Flyway, Actuator endpoints, and profile wiring.

## Behavior
Generate:
- src/main/resources/application.yml
- src/main/resources/application-local.yml

## application.yml (high level)
- server.port = ${APP_PORT:8080}
- spring.jpa.open-in-view=false, hibernate ddl-auto=validate
- spring.flyway.enabled=true
- management.endpoints.web.exposure.include=health,info,metrics,prometheus
- tracing: OTLP endpoint configurable

## application-local.yml
- spring.datasource.url=jdbc:postgresql://localhost:${DB_PORT:5432}/${DB_NAME:app}
- spring.datasource.username=${DB_USERNAME:admin}
- spring.datasource.password=${DB_PASSWORD:abc123}
- spring.jpa.properties.hibernate.default_schema=${DB_SCHEMA:public}

## Output
- application.yml files with metadata headers
