
# Description

Updates pom.xml to Java 21, Spring Boot 3.5.5, Postgres driver, and Testcontainers. Preserves existing content. No mvnw binaries are added.

## Intent

Standardize build to Java 21 and Spring Boot 3.5.5 with Postgres and Testcontainers for integration testing.

## Inputs (Agentic Context)

* spring\_boot\_version: default 3.5.5
* java\_version: default 21

## Outputs

* pom.xml updated in-place

## Guardrails

* Do not remove unrelated dependencies or plugin configuration.
* Avoid duplicates; upgrade coordinates/versions where needed.

## Tasks

Edit pom.xml to ensure the following blocks exist (create or reconcile):

1. Properties and dependencyManagement:

```xml
<properties>
  <java.version>21</java.version>
  <spring.boot.version>3.5.5</spring.boot.version>
</properties>

<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-dependencies</artifactId>
      <version>${spring.boot.version}</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```

2. Dependencies:

```xml
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
  <dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
  </dependency>

  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.testcontainers</groupId>
    <artifactId>junit-jupiter</artifactId>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.testcontainers</groupId>
    <artifactId>postgresql</artifactId>
    <scope>test</scope>
  </dependency>
</dependencies>
```

3. Build plugins:

```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <version>3.11.0</version>
      <configuration>
        <release>21</release>
      </configuration>
    </plugin>
    <plugin>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-maven-plugin</artifactId>
    </plugin>
  </plugins>
</build>
```

## Acceptance Criteria

* `mvn -q -DskipTests package` succeeds with Java 21 toolchain.
* Spring Boot version resolves to 3.5.5.
* Testcontainers deps are present under test scope.

## Idempotency Rules

* De-duplicate by GAV; upgrade versions in place.
* Preserve non-conflicting existing properties/plugins.