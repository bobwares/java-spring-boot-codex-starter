# Version History

### 0.0.1 – 2025-09-04 21:45:39 UTC (main)

#### Task
Initial project setup

#### Changes
- Converted application.properties to application.yml.
- Added health check API.
- Added JUnit testing support.
- Added e2e HTTP test.

### 0.0.2 – 2025-09-04 22:11:01 UTC (main)

#### Task
Update metadata headers and add Makefile

#### Changes
- Added metadata headers to source, test, and configuration files.
- Introduced Makefile for build and test commands.
- Created changelog to track version history.

### 0.0.3 – 2025-09-06 02:28:22 UTC (work)

#### Task
Add Person CRUD service

#### Changes
- Implement asynchronous Person CRUD API with WebFlux and OpenAPI.
- Add unit and integration tests for Person service and controller.
- Provide end-to-end HTTP scenario for Person lifecycle.

### 0.0.4 – 2025-09-09 19:14:32 UTC (work)

#### Task
Add customer profile migration

#### Changes
- Added SQL migration for customer_profile schema.
- Added db README with migration instructions.

### 0.0.5 – 2025-09-09 19:18:27 UTC (work)

#### Task
Automate customer profile migration

#### Changes
- Added script to apply SQL migrations.
- Added Makefile target and documentation to run migrations.
