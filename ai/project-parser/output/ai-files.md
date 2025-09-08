# AI Workspace Files

_Generated on: 2025-09-07T19:27:46Z_

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../about/project-about.md

```markdown
## Project Overview
* 
* **Name**: `java-spring-boot-codex-starter`
* **Version**: `0.1.0`
* **Description**: Iterates over configured ReAct tasks, running each through
*  a general-purpose ReAct pipeline, printing results, and saving each
*  run’s outputs under history/{YYYYMMDD_HHMMSS}/ at the project root.
* **Author**: Bobwares ([bobwares@outlook.com](mailto:bobwares@outlook.com))



```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../about/prompt-instructions.md

```markdown
## AI Prompt Context Instructions
    - This file includes the current of the application.
    - Always include metadata header section for project at the top of each source code file.
    - Definition of Metadata header section:

```markdown
# LangChain PoC - Minimal Chat Example
# Package: {{package}}
# File: {{file name}}
# Version: 2.0.29
# Author: Bobwares
# Date: {{current date/ time}}
# Description: document the function of the code.
#

```

- Update version each time new code is generated.   
- create file version.md with updated version number and list of changes.
- follow code formatting standards:   PEP 8: E303 too many blank lines (2)
```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../about/tech-stack.md

```markdown
## Technology Stack


### Application Layer

#### Language

* ** Java

    * Modern version with improved performance, type hinting, and async support.

---

### Core Dependencies

```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../about/version.md

```markdown
# Version History

## 0.1.0
- Initial proof-of-concept release.

```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../agentic-pipeline/tasks/create_rest_service.task.md

```markdown
# Task

Create a complete REST service based on input parameters.

## Inputs

- API Request Schema (authoritative): `project_root/schemas/{{domain_object}}.schema.json`
- Package root: {{package_name}}
- Project name: {{project_name}}
- Version seed: `0.1.0`

## Workflow

- execute tool project_root/ai/agentic-pipeline/tools/crud.tool.md 
- pass inputs
```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../agentic-pipeline/tasks/create_sql_dll_from_schema.task.md

```markdown
# TASK Generate Normalized Tables from JSON Schema

## Inputs

- schema = project_root/schemas/{{domain_object}}.schema.json
- Project name: {{project_name}}
- Version seed: `0.1.0`

## Workflow
1. execute tool project_root/ai/agentic-pipeline/tools/json_schema_to_sql_transformation_tool.md
2. execute tool project_root/ai/agentic-pipeline/tools/create_test_data_for_schema.tool.md





```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../agentic-pipeline/tools/TEST - TASK 01 - DB - JSON Schema to SQL Transformation.md

```markdown
# TEST - TASK 02 - DB - SQL Schema to JSON Schema.md

## Task Simulator

- simulate an ai coding agent

## Inputs

{
"$schema": "http://json-schema.org/draft-07/schema#",
"title": "CustomerProfile",
"type": "object",
"properties": {
"id": {
"type": "string",
"format": "uuid",
"description": "Unique identifier for the customer profile"
},
"firstName": {
"type": "string",
"minLength": 1,
"description": "Customer’s given name"
},
"middleName": {
"type": "string",
"description": "Customer’s middle name or initial",
"minLength": 1
},
"lastName": {
"type": "string",
"minLength": 1,
"description": "Customer’s family name"
},
"emails": {
"type": "array",
"description": "List of the customer’s email addresses",
"items": {
"type": "string",
"format": "email"
},
"minItems": 1,
"uniqueItems": true
},
"phoneNumbers": {
"type": "array",
"description": "List of the customer’s phone numbers",
"items": {
"$ref": "#/definitions/PhoneNumber"
},
"minItems": 1
},
"address": {
"$ref": "#/definitions/PostalAddress"
},
"privacySettings": {
"$ref": "#/definitions/PrivacySettings"
}
},
"required": [
"id",
"firstName",
"lastName",
"emails",
"privacySettings"
],
"additionalProperties": false,
"definitions": {

    "PhoneNumber": {
      "type": "object",
      "properties": {
        "type": {
          "type": "string",
          "description": "Type of phone number",
          "enum": ["mobile", "home", "work", "other"]
        },
        "number": {
          "type": "string",
          "pattern": "^\\+?[1-9]\\d{1,14}$",
          "description": "Phone number in E.164 format"
        }
      },
      "required": ["type", "number"],
      "additionalProperties": false
    },
    "PostalAddress": {
      "type": "object",
      "properties": {
        "line1": {
          "type": "string",
          "minLength": 1,
          "description": "Street address, P.O. box, company name, c/o"
        },
        "line2": {
          "type": "string",
          "description": "Apartment, suite, unit, building, floor, etc."
        },
        "city": {
          "type": "string",
          "minLength": 1,
          "description": "City or locality"
        },
        "state": {
          "type": "string",
          "minLength": 1,
          "description": "State, province, or region"
        },
        "postalCode": {
          "type": "string",
          "description": "ZIP or postal code"
        },
        "country": {
          "type": "string",
          "minLength": 2,
          "maxLength": 2,
          "description": "ISO 3166-1 alpha-2 country code"
        }
      },
      "required": ["line1", "city", "state", "postalCode", "country"],
      "additionalProperties": false
    },
    "PrivacySettings": {
      "type": "object",
      "properties": {
        "marketingEmailsEnabled": {
          "type": "boolean",
          "description": "Whether the user opts in to marketing emails"
        },
        "twoFactorEnabled": {
          "type": "boolean",
          "description": "Whether two-factor authentication is enabled"
        }
      },
      "required": [
        "marketingEmailsEnabled",
        "twoFactorEnabled"
      ],
      "additionalProperties": false
    }
}


## Task

# TASK 01 - DB - JSON Schema to SQL Transformation


**Context**:  
Convert a JSON schema into normalized DDL SQL statements.  
Directory: `/db`

**Constraints**:
- Use PostgreSQL v16 dialect
- Normalize to at least 3NF
- Use singular table names (e.g., customer, order_item)
- Include indexes for foreign keys and queryable fields
- Use CREATE TABLE IF NOT EXISTS
- Follow project naming conventions
- Replace NN in file path with incremented number. ie db/migrations/01_<domain>_.sql

**Inputs**

- Domain: referenced in Ticket.
- JSON Schema referenced in Ticket.

**Output**:

- A complete SQL file with metadata header, table definitions, foreign keys, and indexes.
- File path: db/migrations/NN_<domain>_.sql

**Task**:  
Generate a migration in `db/migrations/NN_<schema title>_tables.sql` that:
- Creates normalized tables from the JSON schema referenced in ticket.
- Infers data types and constraints (PRIMARY KEY, FOREIGN KEY, UNIQUE)
- Maps nested objects ie (`customer`, `shipping_address`) to separate tables
- Converts arrays (`items`) to a related table
- Creates a flattened views of the domain.

**Workflow Outline**

1. **Review the DB task file** to confirm conventions, timestamp rules, and required header fields.
2. **Parse the customer JSON schema** to derive an entity-relationship outline (e.g., `customer`, `customer_address`, `customer_contact`, etc.).
3. **Draft SQL** with all constraints and indexes (`btree` on foreign keys, `GIN` or `btree` on heavily-queried columns).

**Acceptance Criteria**
* Expected Outputs were created.
* Each file contains a metadata header block.
* Uses `CREATE TABLE IF NOT EXISTS` statements valid for PostgreSQL 16.
* Implements all keys, constraints, and indexes required by the JSON schema.
* Naming conventions, timestamp format, and directory layout match project standards.
* `project_root/db/README.md` gains a short “Domain Migration” section describing how to execute the migration and smoke tests locally.

## Example Execution

**Inputs**
domain = customer_profile
sql schema name = domain

**JSON Schema**:
```json
{
  "$schema": "http://json-schema.org/draft-07/schema#",
  "title": "CustomerProfile",
  "type": "object",
  "properties": {
    "id": {
      "type": "string",
      "format": "uuid",
      "description": "Unique identifier for the customer profile"
    },
    "firstName": {
      "type": "string",
      "minLength": 1,
      "description": "Customer’s given name"
    },
    "middleName": {
      "type": "string",
      "description": "Customer’s middle name or initial",
      "minLength": 1
    },
    "lastName": {
      "type": "string",
      "minLength": 1,
      "description": "Customer’s family name"
    },
    "emails": {
      "type": "array",
      "description": "List of the customer’s email addresses",
      "items": {
        "type": "string",
        "format": "email"
      },
      "minItems": 1,
      "uniqueItems": true
    },
    "phoneNumbers": {
      "type": "array",
      "description": "List of the customer’s phone numbers",
      "items": {
        "$ref": "#/definitions/PhoneNumber"
      },
      "minItems": 1
    },
    "address": {
      "$ref": "#/definitions/PostalAddress"
    },
    "privacySettings": {
      "$ref": "#/definitions/PrivacySettings"
    }
  },
  "required": [
    "id",
    "firstName",
    "lastName",
    "emails",
    "privacySettings"
  ],
  "additionalProperties": false,
  "definitions": {

    "PhoneNumber": {
      "type": "object",
      "properties": {
        "type": {
          "type": "string",
          "description": "Type of phone number",
          "enum": ["mobile", "home", "work", "other"]
        },
        "number": {
          "type": "string",
          "pattern": "^\\+?[1-9]\\d{1,14}$",
          "description": "Phone number in E.164 format"
        }
      },
      "required": ["type", "number"],
      "additionalProperties": false
    },
    "PostalAddress": {
      "type": "object",
      "properties": {
        "line1": {
          "type": "string",
          "minLength": 1,
          "description": "Street address, P.O. box, company name, c/o"
        },
        "line2": {
          "type": "string",
          "description": "Apartment, suite, unit, building, floor, etc."
        },
        "city": {
          "type": "string",
          "minLength": 1,
          "description": "City or locality"
        },
        "state": {
          "type": "string",
          "minLength": 1,
          "description": "State, province, or region"
        },
        "postalCode": {
          "type": "string",
          "description": "ZIP or postal code"
        },
        "country": {
          "type": "string",
          "minLength": 2,
          "maxLength": 2,
          "description": "ISO 3166-1 alpha-2 country code"
        }
      },
      "required": ["line1", "city", "state", "postalCode", "country"],
      "additionalProperties": false
    },
    "PrivacySettings": {
      "type": "object",
      "properties": {
        "marketingEmailsEnabled": {
          "type": "boolean",
          "description": "Whether the user opts in to marketing emails"
        },
        "twoFactorEnabled": {
          "type": "boolean",
          "description": "Whether two-factor authentication is enabled"
        }
      },
      "required": [
        "marketingEmailsEnabled",
        "twoFactorEnabled"
      ],
      "additionalProperties": false
    }
  }
}
````

**Expected Output**:

```sql
-- App: Initial Full-Stack Application
-- Package: db
-- File: 20250610120000_create_customer_profile_tables.sql
-- Version: 0.1.0
-- Author: AI Agent
-- Date: 2025-06-10
-- Description: Creates the customer_profile schema and normalized tables.

BEGIN;

-- 1. Ensure the schema exists
CREATE SCHEMA IF NOT EXISTS customer_profile;

-- 2. Work inside that schema for the rest of the script
SET search_path TO customer_profile, public;

/* ---------- Reference tables ---------- */
CREATE TABLE IF NOT EXISTS postal_address (
                                              address_id  SERIAL PRIMARY KEY,
                                              line1       VARCHAR(255) NOT NULL,
                                              line2       VARCHAR(255),
                                              city        VARCHAR(100) NOT NULL,
                                              state       VARCHAR(50)  NOT NULL,
                                              postal_code VARCHAR(20),
                                              country     CHAR(2)      NOT NULL
);

CREATE TABLE IF NOT EXISTS privacy_settings (
                                                privacy_settings_id      SERIAL  PRIMARY KEY,
                                                marketing_emails_enabled BOOLEAN NOT NULL,
                                                two_factor_enabled       BOOLEAN NOT NULL
);

/* ---------- Root entity ---------- */
CREATE TABLE IF NOT EXISTS customer (
                                        customer_id         UUID PRIMARY KEY,
                                        first_name          VARCHAR(255) NOT NULL,
                                        middle_name         VARCHAR(255),
                                        last_name           VARCHAR(255) NOT NULL,
                                        address_id          INT  REFERENCES postal_address(address_id),
                                        privacy_settings_id INT  REFERENCES privacy_settings(privacy_settings_id)
);

CREATE INDEX IF NOT EXISTS idx_customer_address_id
    ON customer (address_id);
CREATE INDEX IF NOT EXISTS idx_customer_privacy_settings_id
    ON customer (privacy_settings_id);

/* ---------- One-to-many collections ---------- */
CREATE TABLE IF NOT EXISTS customer_email (
                                              email_id    SERIAL PRIMARY KEY,
                                              customer_id UUID NOT NULL REFERENCES customer(customer_id) ON DELETE CASCADE,
                                              email       VARCHAR(255) NOT NULL,
                                              UNIQUE (customer_id, email)
);
CREATE INDEX IF NOT EXISTS idx_customer_email_customer_id
    ON customer_email (customer_id);

CREATE TABLE IF NOT EXISTS customer_phone_number (
                                                     phone_id    SERIAL PRIMARY KEY,
                                                     customer_id UUID NOT NULL REFERENCES customer(customer_id) ON DELETE CASCADE,
                                                     type        VARCHAR(20) NOT NULL,
                                                     number      VARCHAR(15) NOT NULL,
                                                     UNIQUE (customer_id, number)
);
CREATE INDEX IF NOT EXISTS idx_customer_phone_customer_id
    ON customer_phone_number (customer_id);

COMMIT;
```





```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../agentic-pipeline/tools/TEST - TASK 02 - DB - SQL Schema to JSON Schema.md

```markdown
# TEST - TASK 02 - DB - SQL Schema to JSON Schema.md


## Task Simulator

- simulate an ai coding agent.  run test.

## Assertion

Compare turn response to the Expected Results.  determine if equal to expected results.

Expect Result =

File: project_root/db/entity-specs/customer_profile-entities.json

```json
{
  "$schema": "https://json-schema.org/draft/2020-12/schema",
  "$id": "<repo-root>/entity-specs/customer_profile-entities.json",
  "title": "customer_profile Domain Entities",
  "type": "object",
  "x-db": { "schema": "customer_profile" },
  "definitions": {
    "PostalAddress": {
      "type": "object",
      "properties": {
        "address_id": { "type": "integer" },
        "line1":      { "type": "string", "maxLength": 255 },
        "line2":      { "type": "string", "maxLength": 255 },
        "city":       { "type": "string", "maxLength": 100 },
        "state":      { "type": "string", "maxLength": 50 },
        "postal_code":{ "type": "string", "maxLength": 20 },
        "country":    { "type": "string", "minLength": 2, "maxLength": 2 }
      },
      "required": [ "address_id", "line1", "city", "state", "country" ],
      "x-db": {
        "primaryKey": [ "address_id" ]
      }
    },

    "PrivacySettings": {
      "type": "object",
      "properties": {
        "privacy_settings_id":     { "type": "integer" },
        "marketing_emails_enabled":{ "type": "boolean" },
        "two_factor_enabled":      { "type": "boolean" }
      },
      "required": [
        "privacy_settings_id",
        "marketing_emails_enabled",
        "two_factor_enabled"
      ],
      "x-db": {
        "primaryKey": [ "privacy_settings_id" ]
      }
    },

    "Customer": {
      "type": "object",
      "properties": {
        "customer_id":         { "type": "string", "format": "uuid" },
        "first_name":          { "type": "string", "maxLength": 255 },
        "middle_name":         { "type": "string", "maxLength": 255 },
        "last_name":           { "type": "string", "maxLength": 255 },
        "address_id":          { "type": "integer" },
        "privacy_settings_id": { "type": "integer" }
      },
      "required": [ "customer_id", "first_name", "last_name" ],
      "x-db": {
        "primaryKey": [ "customer_id" ],
        "foreignKey": [
          { "column": "address_id",          "ref": "PostalAddress.address_id" },
          { "column": "privacy_settings_id", "ref": "PrivacySettings.privacy_settings_id" }
        ],
        "indexes": [
          [ "address_id" ],
          [ "privacy_settings_id" ]
        ]
      }
    },

    "CustomerEmail": {
      "type": "object",
      "properties": {
        "email_id":    { "type": "integer" },
        "customer_id": { "type": "string", "format": "uuid" },
        "email":       { "type": "string", "maxLength": 255 }
      },
      "required": [ "email_id", "customer_id", "email" ],
      "x-db": {
        "primaryKey": [ "email_id" ],
        "foreignKey": { "column": "customer_id", "ref": "Customer.customer_id" },
        "unique":     [ [ "customer_id", "email" ] ],
        "indexes":    [ [ "customer_id" ] ]
      }
    },

    "CustomerPhoneNumber": {
      "type": "object",
      "properties": {
        "phone_id":    { "type": "integer" },
        "customer_id": { "type": "string", "format": "uuid" },
        "type":        { "type": "string", "maxLength": 20 },
        "number":      { "type": "string", "maxLength": 15 }
      },
      "required": [ "phone_id", "customer_id", "type", "number" ],
      "x-db": {
        "primaryKey": [ "phone_id" ],
        "foreignKey": { "column": "customer_id", "ref": "Customer.customer_id" },
        "unique":     [ [ "customer_id", "number" ] ],
        "indexes":    [ [ "customer_id" ] ]
      }
    }
  }
}
```



## Inputs


```sql
-- App: Initial Full-Stack Application
-- Package: db
-- File: 20250610120000_create_customer_profile_tables.sql
-- Version: 0.1.0
-- Author: AI Agent
-- Date: 2025-06-10
-- Description: Creates the customer_profile schema and normalized tables.

BEGIN;

-- 1. Ensure the schema exists
CREATE SCHEMA IF NOT EXISTS customer_profile;

-- 2. Work inside that schema for the rest of the script
SET search_path TO customer_profile, public;

/* ---------- Reference tables ---------- */
CREATE TABLE IF NOT EXISTS postal_address (
                                              address_id  SERIAL PRIMARY KEY,
                                              line1       VARCHAR(255) NOT NULL,
                                              line2       VARCHAR(255),
                                              city        VARCHAR(100) NOT NULL,
                                              state       VARCHAR(50)  NOT NULL,
                                              postal_code VARCHAR(20),
                                              country     CHAR(2)      NOT NULL
);

CREATE TABLE IF NOT EXISTS privacy_settings (
                                                privacy_settings_id      SERIAL  PRIMARY KEY,
                                                marketing_emails_enabled BOOLEAN NOT NULL,
                                                two_factor_enabled       BOOLEAN NOT NULL
);

/* ---------- Root entity ---------- */
CREATE TABLE IF NOT EXISTS customer (
                                        customer_id         UUID PRIMARY KEY,
                                        first_name          VARCHAR(255) NOT NULL,
                                        middle_name         VARCHAR(255),
                                        last_name           VARCHAR(255) NOT NULL,
                                        address_id          INT  REFERENCES postal_address(address_id),
                                        privacy_settings_id INT  REFERENCES privacy_settings(privacy_settings_id)
);

CREATE INDEX IF NOT EXISTS idx_customer_address_id
    ON customer (address_id);
CREATE INDEX IF NOT EXISTS idx_customer_privacy_settings_id
    ON customer (privacy_settings_id);

/* ---------- One-to-many collections ---------- */
CREATE TABLE IF NOT EXISTS customer_email (
                                              email_id    SERIAL PRIMARY KEY,
                                              customer_id UUID NOT NULL REFERENCES customer(customer_id) ON DELETE CASCADE,
                                              email       VARCHAR(255) NOT NULL,
                                              UNIQUE (customer_id, email)
);
CREATE INDEX IF NOT EXISTS idx_customer_email_customer_id
    ON customer_email (customer_id);

CREATE TABLE IF NOT EXISTS customer_phone_number (
                                                     phone_id    SERIAL PRIMARY KEY,
                                                     customer_id UUID NOT NULL REFERENCES customer(customer_id) ON DELETE CASCADE,
                                                     type        VARCHAR(20) NOT NULL,
                                                     number      VARCHAR(15) NOT NULL,
                                                     UNIQUE (customer_id, number)
);
CREATE INDEX IF NOT EXISTS idx_customer_phone_customer_id
    ON customer_phone_number (customer_id);

COMMIT;
```

--- 

## Task

# TASK 02 – DB – SQL → JSON Schema Transformation

## Context

Convert the canonical SQL DDL in
`/db/migrations/01_<domain>.sql` into a normalized **Draft 2020-12 JSON Schema** file.

---

## Constraints

* **Target draft:** JSON Schema **Draft 2020-12**

* **Definitions** keyed by **singular** table names (e.g. `Customer`, `PostalAddress`)

* **SQL → JSON type mapping**

  | SQL type               | JSON Schema representation                         |
    |------------------------|----------------------------------------------------|
  | `UUID`                 | `"type": "string", "format": "uuid"`               |
  | `SERIAL` / integer PKs | `"type": "integer"`                                |
  | `VARCHAR(n)`           | `"type": "string", "maxLength": n`                 |
  | `CHAR(n)`              | `"type": "string", "minLength": n, "maxLength": n` |
  | `BOOLEAN`              | `"type": "boolean"`                                |

* **Required vs nullable** – any column declared `NOT NULL` must appear in the definition’s `"required"` array.

* **Primary keys** – record in both:

    * `"required"` array
    * `x-db.primaryKey`

* **Foreign keys** – capture under `x-db.foreignKey`, e.g.:

  ```json
  "x-db": {
    "foreignKey": { "column": "address_id", "ref": "PostalAddress.address_id" }
  }
  ```

* **Unique constraints** & **indexes** – list under `x-db.unique` and `x-db.indexes`.

* **Schema name** – add a root-level block:

  ```json
  "x-db": {
    "schema": "<domain>"
  }
  ```

  > **New requirement** ← ensures consumers know the exact PostgreSQL schema of all entities.

* **Output path**

  ```
  project_root/db/entity-specs/<domain>-entities.json
  ```

* **No file header** – emit *pure* JSON Schema (no Markdown, no comments).

---

## Inputs

| Item              | Value                                |
| ----------------- | ------------------------------------ |
| **Domain** | `<domain>` (e.g. `customer_profile`) |
| **SQL DDL**       | `/db/migrations/01_<domain>.sql`     |

---

## Output

A single file at `project_root/db/entity-specs/<domain>-entities.json`:

```json
{
  "$schema": "https://json-schema.org/draft/2020-12/schema",
  "$id": "<repo-root>/entity-specs/<domain>-entities.json",
  "title": "<domain> Domain Entities",
  "type": "object",
  "x-db": { "schema": "<domain>" },
  "definitions": {
    /* one definition per table */
  }
}
```

Each definition **must** include:

* `type`, `properties`, `required`
* `x-db.primaryKey`
* `x-db.foreignKey`
* `x-db.unique`
* `x-db.indexes`

---

## Task Steps

1. **Review** `/db/migrations/01_<domain>.sql`
   Identify tables, columns, constraints, and indexes.
2. **Parse** the DDL (script or parser) capturing:

    * Column name, data type, nullability
    * Primary-key, foreign-key, unique constraints
    * Explicit indexes
3. **Map** each table → JSON Schema definition:

    * Apply type mappings
    * Populate `"required"` from `NOT NULL` columns
    * Fill `x-db.*` sections
4. **Assemble** the final JSON document with the root-level `"x-db.schema"`.
5. **Validate** with a Draft 2020-12 linter (e.g. AJV).
6. **Record** any Architectural Decision Record (ADR) if mapping deviates from conventions.

---

## Acceptance Criteria

* `project_root/db/entity-specs/<domain>-entities.json` exists.
* JSON is valid Draft 2020-12 and passes `ajv validate`.
* All tables from the DDL are represented with correct types & required fields.
* Root-level `"x-db.schema"` matches the PostgreSQL schema name in the DDL.
* All PKs, FKs, uniques, and indexes are captured under `x-db.*`.
* File path and branch naming follow project standards.


## Example Execution

**Inputs**

domain = customer_profile

SQL DDL =

```sql
-- App: Initial Full-Stack Application
-- Package: db
-- File: 20250610120000_create_customer_profile_tables.sql
-- Version: 0.1.0
-- Author: AI Agent
-- Date: 2025-06-10
-- Description: Creates the customer_profile schema and normalized tables.

BEGIN;

-- 1. Ensure the schema exists
CREATE SCHEMA IF NOT EXISTS customer_profile;

-- 2. Work inside that schema for the rest of the script
SET search_path TO customer_profile, public;

/* ---------- Reference tables ---------- */
CREATE TABLE IF NOT EXISTS postal_address (
                                              address_id  SERIAL PRIMARY KEY,
                                              line1       VARCHAR(255) NOT NULL,
                                              line2       VARCHAR(255),
                                              city        VARCHAR(100) NOT NULL,
                                              state       VARCHAR(50)  NOT NULL,
                                              postal_code VARCHAR(20),
                                              country     CHAR(2)      NOT NULL
);

CREATE TABLE IF NOT EXISTS privacy_settings (
                                                privacy_settings_id      SERIAL  PRIMARY KEY,
                                                marketing_emails_enabled BOOLEAN NOT NULL,
                                                two_factor_enabled       BOOLEAN NOT NULL
);

/* ---------- Root entity ---------- */
CREATE TABLE IF NOT EXISTS customer (
                                        customer_id         UUID PRIMARY KEY,
                                        first_name          VARCHAR(255) NOT NULL,
                                        middle_name         VARCHAR(255),
                                        last_name           VARCHAR(255) NOT NULL,
                                        address_id          INT  REFERENCES postal_address(address_id),
                                        privacy_settings_id INT  REFERENCES privacy_settings(privacy_settings_id)
);

CREATE INDEX IF NOT EXISTS idx_customer_address_id
    ON customer (address_id);
CREATE INDEX IF NOT EXISTS idx_customer_privacy_settings_id
    ON customer (privacy_settings_id);

/* ---------- One-to-many collections ---------- */
CREATE TABLE IF NOT EXISTS customer_email (
                                              email_id    SERIAL PRIMARY KEY,
                                              customer_id UUID NOT NULL REFERENCES customer(customer_id) ON DELETE CASCADE,
                                              email       VARCHAR(255) NOT NULL,
                                              UNIQUE (customer_id, email)
);
CREATE INDEX IF NOT EXISTS idx_customer_email_customer_id
    ON customer_email (customer_id);

CREATE TABLE IF NOT EXISTS customer_phone_number (
                                                     phone_id    SERIAL PRIMARY KEY,
                                                     customer_id UUID NOT NULL REFERENCES customer(customer_id) ON DELETE CASCADE,
                                                     type        VARCHAR(20) NOT NULL,
                                                     number      VARCHAR(15) NOT NULL,
                                                     UNIQUE (customer_id, number)
);
CREATE INDEX IF NOT EXISTS idx_customer_phone_customer_id
    ON customer_phone_number (customer_id);

COMMIT;
```

**output**

File: project_root/db/entity-specs/customer_profile-entities.json

```json
{
  "$schema": "https://json-schema.org/draft/2020-12/schema",
  "$id": "<repo-root>/entity-specs/customer_profile-entities.json",
  "title": "customer_profile Domain Entities",
  "type": "object",
  "x-db": { "schema": "customer_profile" },
  "definitions": {
    "PostalAddress": {
      "type": "object",
      "properties": {
        "address_id": { "type": "integer" },
        "line1":      { "type": "string", "maxLength": 255 },
        "line2":      { "type": "string", "maxLength": 255 },
        "city":       { "type": "string", "maxLength": 100 },
        "state":      { "type": "string", "maxLength": 50 },
        "postal_code":{ "type": "string", "maxLength": 20 },
        "country":    { "type": "string", "minLength": 2, "maxLength": 2 }
      },
      "required": [ "address_id", "line1", "city", "state", "country" ],
      "x-db": {
        "primaryKey": [ "address_id" ]
      }
    },

    "PrivacySettings": {
      "type": "object",
      "properties": {
        "privacy_settings_id":     { "type": "integer" },
        "marketing_emails_enabled":{ "type": "boolean" },
        "two_factor_enabled":      { "type": "boolean" }
      },
      "required": [
        "privacy_settings_id",
        "marketing_emails_enabled",
        "two_factor_enabled"
      ],
      "x-db": {
        "primaryKey": [ "privacy_settings_id" ]
      }
    },

    "Customer": {
      "type": "object",
      "properties": {
        "customer_id":         { "type": "string", "format": "uuid" },
        "first_name":          { "type": "string", "maxLength": 255 },
        "middle_name":         { "type": "string", "maxLength": 255 },
        "last_name":           { "type": "string", "maxLength": 255 },
        "address_id":          { "type": "integer" },
        "privacy_settings_id": { "type": "integer" }
      },
      "required": [ "customer_id", "first_name", "last_name" ],
      "x-db": {
        "primaryKey": [ "customer_id" ],
        "foreignKey": [
          { "column": "address_id",          "ref": "PostalAddress.address_id" },
          { "column": "privacy_settings_id", "ref": "PrivacySettings.privacy_settings_id" }
        ],
        "indexes": [
          [ "address_id" ],
          [ "privacy_settings_id" ]
        ]
      }
    },

    "CustomerEmail": {
      "type": "object",
      "properties": {
        "email_id":    { "type": "integer" },
        "customer_id": { "type": "string", "format": "uuid" },
        "email":       { "type": "string", "maxLength": 255 }
      },
      "required": [ "email_id", "customer_id", "email" ],
      "x-db": {
        "primaryKey": [ "email_id" ],
        "foreignKey": { "column": "customer_id", "ref": "Customer.customer_id" },
        "unique":     [ [ "customer_id", "email" ] ],
        "indexes":    [ [ "customer_id" ] ]
      }
    },

    "CustomerPhoneNumber": {
      "type": "object",
      "properties": {
        "phone_id":    { "type": "integer" },
        "customer_id": { "type": "string", "format": "uuid" },
        "type":        { "type": "string", "maxLength": 20 },
        "number":      { "type": "string", "maxLength": 15 }
      },
      "required": [ "phone_id", "customer_id", "type", "number" ],
      "x-db": {
        "primaryKey": [ "phone_id" ],
        "foreignKey": { "column": "customer_id", "ref": "Customer.customer_id" },
        "unique":     [ [ "customer_id", "number" ] ],
        "indexes":    [ [ "customer_id" ] ]
      }
    }
  }
}

```

```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../agentic-pipeline/tools/TEST - TASK 03 - DB - Create Test Data for Schema.md

```markdown
# TEST -TASK 03 - DB - Create Test Data for Schema

## Task Simulator

- simulate an ai coding agent.  run test.

## Task to Test


## Inputs

File: project_root/db/entity-specs/customer_profile-entities.json

```json
{
  "$schema": "https://json-schema.org/draft/2020-12/schema",
  "$id": "<repo-root>/entity-specs/customer_profile-entities.json",
  "title": "customer_profile Domain Entities",
  "type": "object",
  "x-db": { "schema": "customer_profile" },
  "definitions": {
    "PostalAddress": {
      "type": "object",
      "properties": {
        "address_id": { "type": "integer" },
        "line1":      { "type": "string", "maxLength": 255 },
        "line2":      { "type": "string", "maxLength": 255 },
        "city":       { "type": "string", "maxLength": 100 },
        "state":      { "type": "string", "maxLength": 50 },
        "postal_code":{ "type": "string", "maxLength": 20 },
        "country":    { "type": "string", "minLength": 2, "maxLength": 2 }
      },
      "required": [ "address_id", "line1", "city", "state", "country" ],
      "x-db": {
        "primaryKey": [ "address_id" ]
      }
    },

    "PrivacySettings": {
      "type": "object",
      "properties": {
        "privacy_settings_id":     { "type": "integer" },
        "marketing_emails_enabled":{ "type": "boolean" },
        "two_factor_enabled":      { "type": "boolean" }
      },
      "required": [
        "privacy_settings_id",
        "marketing_emails_enabled",
        "two_factor_enabled"
      ],
      "x-db": {
        "primaryKey": [ "privacy_settings_id" ]
      }
    },

    "Customer": {
      "type": "object",
      "properties": {
        "customer_id":         { "type": "string", "format": "uuid" },
        "first_name":          { "type": "string", "maxLength": 255 },
        "middle_name":         { "type": "string", "maxLength": 255 },
        "last_name":           { "type": "string", "maxLength": 255 },
        "address_id":          { "type": "integer" },
        "privacy_settings_id": { "type": "integer" }
      },
      "required": [ "customer_id", "first_name", "last_name" ],
      "x-db": {
        "primaryKey": [ "customer_id" ],
        "foreignKey": [
          { "column": "address_id",          "ref": "PostalAddress.address_id" },
          { "column": "privacy_settings_id", "ref": "PrivacySettings.privacy_settings_id" }
        ],
        "indexes": [
          [ "address_id" ],
          [ "privacy_settings_id" ]
        ]
      }
    },

    "CustomerEmail": {
      "type": "object",
      "properties": {
        "email_id":    { "type": "integer" },
        "customer_id": { "type": "string", "format": "uuid" },
        "email":       { "type": "string", "maxLength": 255 }
      },
      "required": [ "email_id", "customer_id", "email" ],
      "x-db": {
        "primaryKey": [ "email_id" ],
        "foreignKey": { "column": "customer_id", "ref": "Customer.customer_id" },
        "unique":     [ [ "customer_id", "email" ] ],
        "indexes":    [ [ "customer_id" ] ]
      }
    },

    "CustomerPhoneNumber": {
      "type": "object",
      "properties": {
        "phone_id":    { "type": "integer" },
        "customer_id": { "type": "string", "format": "uuid" },
        "type":        { "type": "string", "maxLength": 20 },
        "number":      { "type": "string", "maxLength": 15 }
      },
      "required": [ "phone_id", "customer_id", "type", "number" ],
      "x-db": {
        "primaryKey": [ "phone_id" ],
        "foreignKey": { "column": "customer_id", "ref": "Customer.customer_id" },
        "unique":     [ [ "customer_id", "number" ] ],
        "indexes":    [ [ "customer_id" ] ]
      }
    }
  }
}
```

**Expected Output**


File: project_root/db/test/01_customer_domain_test_data.sql

```sql
-- App: Client Profile Module
-- Package: db
-- File: 01_customer_domain_test_data.sql
-- Version: 0.0.4
-- Author: Bobwares
-- Date: 2025-06-12T01:30:00Z
-- Description: Inserts sample customer domain data for testing purposes.
--
BEGIN;

-- Insert postal addresses
INSERT INTO postal_address (address_id, line1, line2, city, state, postal_code, country)
VALUES
    (1, '100 Market St', NULL, 'Springfield', 'IL', '62701', 'US'),
    (2, '200 Oak Ave', 'Apt 2', 'Madison', 'WI', '53703', 'US'),
    (3, '300 Pine Rd', NULL, 'Austin', 'TX', '73301', 'US'),
    (4, '400 Maple Ln', NULL, 'Denver', 'CO', '80014', 'US'),
    (5, '500 Cedar Blvd', 'Suite 5', 'Phoenix', 'AZ', '85001', 'US'),
    (6, '600 Birch Way', NULL, 'Portland', 'OR', '97035', 'US'),
    (7, '700 Walnut St', NULL, 'Boston', 'MA', '02108', 'US'),
    (8, '800 Chestnut Dr', NULL, 'Seattle', 'WA', '98101', 'US'),
    (9, '900 Elm Cir', NULL, 'Atlanta', 'GA', '30303', 'US'),
    (10, '1000 Ash Pl', NULL, 'Miami', 'FL', '33101', 'US')
ON CONFLICT DO NOTHING;

-- Insert privacy settings
INSERT INTO privacy_settings (privacy_settings_id, marketing_emails_enabled, two_factor_enabled)
VALUES
    (1, TRUE, FALSE),
    (2, FALSE, TRUE),
    (3, TRUE, TRUE),
    (4, FALSE, FALSE),
    (5, TRUE, FALSE),
    (6, FALSE, TRUE),
    (7, TRUE, TRUE),
    (8, FALSE, FALSE),
    (9, TRUE, FALSE),
    (10, FALSE, TRUE)
ON CONFLICT DO NOTHING;

-- Insert customers
INSERT INTO customer (customer_id, first_name, middle_name, last_name, address_id, privacy_settings_id)
VALUES
    ('11111111-1111-1111-1111-111111111111', 'Alice', NULL, 'Smith', 1, 1),
    ('22222222-2222-2222-2222-222222222222', 'Bob', 'J', 'Jones', 2, 2),
    ('33333333-3333-3333-3333-333333333333', 'Charlie', NULL, 'Brown', 3, 3),
    ('44444444-4444-4444-4444-444444444444', 'David', 'K', 'Miller', 4, 4),
    ('55555555-5555-5555-5555-555555555555', 'Emma', NULL, 'Davis', 5, 5),
    ('66666666-6666-6666-6666-666666666666', 'Frank', NULL, 'Wilson', 6, 6),
    ('77777777-7777-7777-7777-777777777777', 'Grace', 'L', 'Taylor', 7, 7),
    ('88888888-8888-8888-8888-888888888888', 'Hugo', NULL, 'Anderson', 8, 8),
    ('99999999-9999-9999-9999-999999999999', 'Isabel', NULL, 'Thomas', 9, 9),
    ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Jack', 'M', 'Jackson', 10, 10)
ON CONFLICT DO NOTHING;

-- Insert customer emails
INSERT INTO customer_email (customer_id, email)
VALUES
    ('11111111-1111-1111-1111-111111111111', 'alice@example.com'),
    ('22222222-2222-2222-2222-222222222222', 'bob@example.com'),
    ('33333333-3333-3333-3333-333333333333', 'charlie@example.com'),
    ('44444444-4444-4444-4444-444444444444', 'david@example.com'),
    ('55555555-5555-5555-5555-555555555555', 'emma@example.com'),
    ('66666666-6666-6666-6666-666666666666', 'frank@example.com'),
    ('77777777-7777-7777-7777-777777777777', 'grace@example.com'),
    ('88888888-8888-8888-8888-888888888888', 'hugo@example.com'),
    ('99999999-9999-9999-9999-999999999999', 'isabel@example.com'),
    ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'jack@example.com')
ON CONFLICT DO NOTHING;

-- Insert phone numbers
INSERT INTO customer_phone_number (customer_id, type, number)
VALUES
    ('11111111-1111-1111-1111-111111111111', 'mobile', '+15555550101'),
    ('22222222-2222-2222-2222-222222222222', 'mobile', '+15555550102'),
    ('33333333-3333-3333-3333-333333333333', 'mobile', '+15555550103'),
    ('44444444-4444-4444-4444-444444444444', 'mobile', '+15555550104'),
    ('55555555-5555-5555-5555-555555555555', 'mobile', '+15555550105'),
    ('66666666-6666-6666-6666-666666666666', 'mobile', '+15555550106'),
    ('77777777-7777-7777-7777-777777777777', 'mobile', '+15555550107'),
    ('88888888-8888-8888-8888-888888888888', 'mobile', '+15555550108'),
    ('99999999-9999-9999-9999-999999999999', 'mobile', '+15555550109'),
    ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'mobile', '+15555550110')
ON CONFLICT DO NOTHING;

COMMIT;
```
```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../agentic-pipeline/tools/Ticket 02 - Create set of test data.md

```markdown
# Ticket 02 – Create set of test data

## Instructions

Execute the listed tasks.

**Task**

project_root/db/tasks/TASK - DB - Seed Script.md


**Inputs**

Domain = customer_profile
SQL DLL =  `project_root/db/migrations/01_customer_domain.sql`

**Accept Criteria**

* File: `project_root/db/test/01_customer_domain_test_data.sql`
* Update to `project_root/db/README.md` under the “Migrations” section

```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../agentic-pipeline/tools/create_test_data_for_schema.tool.md

```markdown
# TASK 03 – DB – Create Test Data for Schema

### Context

Seed initial customer data for development (PostgreSQL 16, plain SQL, Docker).

---

### Requirements

* **File location:** `db/scripts/<domain>_test_data.sql`
* **Insert 10 customers** into the `customer` table with columns: `customer_id`, `name`, `email`.
* **Idempotent** – use `INSERT … ON CONFLICT DO NOTHING`.
* **Metadata header** (App, Package, File, Version, Author, Date, Description).
* **Realistic sample data** (names + emails).
* **Timestamps in UTC** (script comment or explicit `timezone` clause).
* **Smoke-test query** that counts rows.
* Follow project SQL style conventions.

---

### Acceptance Criteria

* Script file exists at `project_root/db/scripts/<domain>_test_data.sql`.
* Header present and accurate.
* Exactly 10 `INSERT` rows, each idempotent.
* Script runs cleanly multiple times without duplicate rows.
* Smoke-test query present and returns **≥ 10** rows after first run.

---

### Example Execution

**Input**

File: project_root/db/entity-specs/customer_profile-entities.json

```json
{
"$schema": "https://json-schema.org/draft/2020-12/schema",
"$id": "<repo-root>/entity-specs/customer_profile-entities.json",
"title": "customer_profile Domain Entities",
"type": "object",
"x-db": { "schema": "customer_profile" },
"definitions": {
"PostalAddress": {
"type": "object",
"properties": {
"address_id": { "type": "integer" },
"line1":      { "type": "string", "maxLength": 255 },
"line2":      { "type": "string", "maxLength": 255 },
"city":       { "type": "string", "maxLength": 100 },
"state":      { "type": "string", "maxLength": 50 },
"postal_code":{ "type": "string", "maxLength": 20 },
"country":    { "type": "string", "minLength": 2, "maxLength": 2 }
},
"required": [ "address_id", "line1", "city", "state", "country" ],
"x-db": {
"primaryKey": [ "address_id" ]
}
},

    "PrivacySettings": {
      "type": "object",
      "properties": {
        "privacy_settings_id":     { "type": "integer" },
        "marketing_emails_enabled":{ "type": "boolean" },
        "two_factor_enabled":      { "type": "boolean" }
      },
      "required": [
        "privacy_settings_id",
        "marketing_emails_enabled",
        "two_factor_enabled"
      ],
      "x-db": {
        "primaryKey": [ "privacy_settings_id" ]
      }
    },

    "Customer": {
      "type": "object",
      "properties": {
        "customer_id":         { "type": "string", "format": "uuid" },
        "first_name":          { "type": "string", "maxLength": 255 },
        "middle_name":         { "type": "string", "maxLength": 255 },
        "last_name":           { "type": "string", "maxLength": 255 },
        "address_id":          { "type": "integer" },
        "privacy_settings_id": { "type": "integer" }
      },
      "required": [ "customer_id", "first_name", "last_name" ],
      "x-db": {
        "primaryKey": [ "customer_id" ],
        "foreignKey": [
          { "column": "address_id",          "ref": "PostalAddress.address_id" },
          { "column": "privacy_settings_id", "ref": "PrivacySettings.privacy_settings_id" }
        ],
        "indexes": [
          [ "address_id" ],
          [ "privacy_settings_id" ]
        ]
      }
    },

    "CustomerEmail": {
      "type": "object",
      "properties": {
        "email_id":    { "type": "integer" },
        "customer_id": { "type": "string", "format": "uuid" },
        "email":       { "type": "string", "maxLength": 255 }
      },
      "required": [ "email_id", "customer_id", "email" ],
      "x-db": {
        "primaryKey": [ "email_id" ],
        "foreignKey": { "column": "customer_id", "ref": "Customer.customer_id" },
        "unique":     [ [ "customer_id", "email" ] ],
        "indexes":    [ [ "customer_id" ] ]
      }
    },

    "CustomerPhoneNumber": {
      "type": "object",
      "properties": {
        "phone_id":    { "type": "integer" },
        "customer_id": { "type": "string", "format": "uuid" },
        "type":        { "type": "string", "maxLength": 20 },
        "number":      { "type": "string", "maxLength": 15 }
      },
      "required": [ "phone_id", "customer_id", "type", "number" ],
      "x-db": {
        "primaryKey": [ "phone_id" ],
        "foreignKey": { "column": "customer_id", "ref": "Customer.customer_id" },
        "unique":     [ [ "customer_id", "number" ] ],
        "indexes":    [ [ "customer_id" ] ]
      }
    }
}
}
```
**Output**

File: project_root/db/test/01_customer_domain_test_data.sql

```sql
-- App: Client Profile Module
-- Package: db
-- File: 01_customer_domain_test_data.sql
-- Version: 0.0.4
-- Author: Bobwares
-- Date: 2025-06-12T01:30:00Z
-- Description: Inserts sample customer domain data for testing purposes.
--
BEGIN;

-- Insert postal addresses
INSERT INTO postal_address (address_id, line1, line2, city, state, postal_code, country)
VALUES
    (1, '100 Market St', NULL, 'Springfield', 'IL', '62701', 'US'),
    (2, '200 Oak Ave', 'Apt 2', 'Madison', 'WI', '53703', 'US'),
    (3, '300 Pine Rd', NULL, 'Austin', 'TX', '73301', 'US'),
    (4, '400 Maple Ln', NULL, 'Denver', 'CO', '80014', 'US'),
    (5, '500 Cedar Blvd', 'Suite 5', 'Phoenix', 'AZ', '85001', 'US'),
    (6, '600 Birch Way', NULL, 'Portland', 'OR', '97035', 'US'),
    (7, '700 Walnut St', NULL, 'Boston', 'MA', '02108', 'US'),
    (8, '800 Chestnut Dr', NULL, 'Seattle', 'WA', '98101', 'US'),
    (9, '900 Elm Cir', NULL, 'Atlanta', 'GA', '30303', 'US'),
    (10, '1000 Ash Pl', NULL, 'Miami', 'FL', '33101', 'US')
ON CONFLICT DO NOTHING;

-- Insert privacy settings
INSERT INTO privacy_settings (privacy_settings_id, marketing_emails_enabled, two_factor_enabled)
VALUES
    (1, TRUE, FALSE),
    (2, FALSE, TRUE),
    (3, TRUE, TRUE),
    (4, FALSE, FALSE),
    (5, TRUE, FALSE),
    (6, FALSE, TRUE),
    (7, TRUE, TRUE),
    (8, FALSE, FALSE),
    (9, TRUE, FALSE),
    (10, FALSE, TRUE)
ON CONFLICT DO NOTHING;

-- Insert customers
INSERT INTO customer (customer_id, first_name, middle_name, last_name, address_id, privacy_settings_id)
VALUES
    ('11111111-1111-1111-1111-111111111111', 'Alice', NULL, 'Smith', 1, 1),
    ('22222222-2222-2222-2222-222222222222', 'Bob', 'J', 'Jones', 2, 2),
    ('33333333-3333-3333-3333-333333333333', 'Charlie', NULL, 'Brown', 3, 3),
    ('44444444-4444-4444-4444-444444444444', 'David', 'K', 'Miller', 4, 4),
    ('55555555-5555-5555-5555-555555555555', 'Emma', NULL, 'Davis', 5, 5),
    ('66666666-6666-6666-6666-666666666666', 'Frank', NULL, 'Wilson', 6, 6),
    ('77777777-7777-7777-7777-777777777777', 'Grace', 'L', 'Taylor', 7, 7),
    ('88888888-8888-8888-8888-888888888888', 'Hugo', NULL, 'Anderson', 8, 8),
    ('99999999-9999-9999-9999-999999999999', 'Isabel', NULL, 'Thomas', 9, 9),
    ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Jack', 'M', 'Jackson', 10, 10)
ON CONFLICT DO NOTHING;

-- Insert customer emails
INSERT INTO customer_email (customer_id, email)
VALUES
    ('11111111-1111-1111-1111-111111111111', 'alice@example.com'),
    ('22222222-2222-2222-2222-222222222222', 'bob@example.com'),
    ('33333333-3333-3333-3333-333333333333', 'charlie@example.com'),
    ('44444444-4444-4444-4444-444444444444', 'david@example.com'),
    ('55555555-5555-5555-5555-555555555555', 'emma@example.com'),
    ('66666666-6666-6666-6666-666666666666', 'frank@example.com'),
    ('77777777-7777-7777-7777-777777777777', 'grace@example.com'),
    ('88888888-8888-8888-8888-888888888888', 'hugo@example.com'),
    ('99999999-9999-9999-9999-999999999999', 'isabel@example.com'),
    ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'jack@example.com')
ON CONFLICT DO NOTHING;

-- Insert phone numbers
INSERT INTO customer_phone_number (customer_id, type, number)
VALUES
    ('11111111-1111-1111-1111-111111111111', 'mobile', '+15555550101'),
    ('22222222-2222-2222-2222-222222222222', 'mobile', '+15555550102'),
    ('33333333-3333-3333-3333-333333333333', 'mobile', '+15555550103'),
    ('44444444-4444-4444-4444-444444444444', 'mobile', '+15555550104'),
    ('55555555-5555-5555-5555-555555555555', 'mobile', '+15555550105'),
    ('66666666-6666-6666-6666-666666666666', 'mobile', '+15555550106'),
    ('77777777-7777-7777-7777-777777777777', 'mobile', '+15555550107'),
    ('88888888-8888-8888-8888-888888888888', 'mobile', '+15555550108'),
    ('99999999-9999-9999-9999-999999999999', 'mobile', '+15555550109'),
    ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'mobile', '+15555550110')
ON CONFLICT DO NOTHING;

COMMIT;
```
```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../agentic-pipeline/tools/crud.tool.md

```markdown

# Tool – Generate Async CRUD with OpenAPI, Unit Tests, and E2E HTTP

## Role

You are an expert Java Spring Boot engineer. Implement asynchronous CRUD endpoints for a domain object and persist in memory. Produce code, tests, and an E2E `.http` file that exercises the full lifecycle. Conform to the repository’s metadata and versioning rules.

## Objectives

1. Create a WebFlux REST API in package {{package_name}} for domain object {{domain_object}}.
2. Annotate endpoints with OpenAPI annotations.
3. Validate input using Jakarta Bean Validation.
4. Persist in a thread-safe in-memory store.
5. Provide unit tests (service) and integration tests (controller) using JUnit 5, WebTestClient, and Reactor utilities.
6. Provide an `.http` file covering create → read → update → delete E2E.
7. Conform to the project’s AGENTS.md metadata header standard and versioning.

## Inputs

- API Request Schema (authoritative): `project_root/schemas/{{domain_object}}.schema.json`
- Package root: {{package_name}}
- Project name: {{project_name}}
- Version seed: `0.1.0`

## Non-functional Constraints

- Java 21, Spring Boot 3.5.x, WebFlux.
- OpenAPI via springdoc for WebFlux.
- No database dependency; use `ConcurrentHashMap<UUID, Person>`.
- JSON field names use snake\_case; map to Java record fields.
- services should be annotated @Service.

## Deliverables (create or update)

1. API and Domain

- `src/main/java/com/bobwares/registration/{{domain_object}}.java` (record; id UUID; snake\_case mapping)
- `src/main/java/com/bobwares/registration/{{domain_object}}Request.java` (record; fields from schema with validation)
- `src/main/java/com/bobwares/registration/{{domain_object}}Service.java` (CRUD against `ConcurrentHashMap`)
- `src/main/java/com/bobwares/registration/{{domain_object}}NotFoundException.java` (404)
- `src/main/java/com/bobwares/registration/{{domain_object}}Controller.java`

    - Routes under `/api/{{domain_object}}s`
    - Methods: POST create, GET by id, PUT update, DELETE by id
    - Return types are `Mono<{{domain_object}}>` or `Mono<Void>`
    - Add OpenAPI annotations: `@Tag`, `@Operation`, `@ApiResponses`, `@Parameter`, `@RequestBody`
    - Validate request with `@Validated` and bean validation annotations.

2. OpenAPI and Config

- Ensure springdoc is active; expose UI at `/swagger-ui.html`.
- If an `application.yml` exists, set `spring.application.name: common` or as appropriate.

3. Tests

- Unit test `{{domain_object}}ServiceTests`

    - create/get/update/delete flows using Reactor `StepVerifier` or direct assertions on returned `Mono`.
- Integration test `{{domain_object}}ControllerIT`

    - `@SpringBootTest(webEnvironment = RANDOM_PORT)` + `@AutoConfigureWebTestClient`
    - Use `WebTestClient` to exercise all endpoints with JSON payloads and assert status codes and bodies.

4. E2E HTTP Scenario

- `e2e/{{domain_object}}.http` that performs:

    - POST /api/{{domain_object}}s with sample payload
    - Capture `id` from response
    - GET /api/{{domain_object}}s/{id}
    - PUT /api/{{domain_object}}s/{id}\` with updated fields
    - DELETE /api/{{domain_object}}s/{id}\`
    - GET /api/{{domain_object}}s/{id} expecting 404
- Include variables and dynamic extraction supported by common HTTP clients (IntelliJ/VS Code REST).


## Implementation Details

### Schema → DTO Mapping

- Map `{{domain_object}}.schema.json` fields exactly to `{{domain_object}}Request` fields.
- `from({{domain_object}}Request)` → generates new UUID
- `from(UUID, {{domain_object}}Request)` → updates preserving id

Validation

- `@NotBlank` for textual fields; `@Size(min=2,max=2)` for state; `@Pattern("^[0-9]{5}(-[0-9]{4})?$")` for zip.

### OpenAPI

- Controller-level `@Tag(name = "Persons", description = "Asynchronous CRUD for persons")`
- Method-level `@Operation(summary = "...", description = "...")` with accurate request/response schemas.
- Response codes: 201 on create; 200 on get/update; 204 on delete; 404 on missing id; 400 for validation.

### Error Handling

- Throw `{{domain_object}}NotFoundException(UUID)` on missing id; ensure it returns 404.

### Concurrency

- Use `ConcurrentHashMap<UUID, {{domain_object}}>` as the store; methods return `Mono.just(...)` or `Mono.empty()` as appropriate.

### Testing Requirements

Service Unit Tests

- Create {{domain_object}}; assert id is non-null and fields persist.
- Update existing; assert replaced fields.
- Delete; assert subsequent get fails with 404.

Controller Integration Tests

- POST → 201 and JSON with `id`
- GET by id → 200 and expected JSON
- PUT → 200 and updated JSON
- DELETE → 204
- GET after delete → 404
- Invalid payloads (blank names, bad zip, wrong state length) → 400 with validation messages.

E2E HTTP File Requirements (`e2e/{{domain_object}}.http`)

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

Now implement.

```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../agentic-pipeline/tools/db_sql_schema_to_json_schema.tool.md

```markdown
# TASK 02 – DB – SQL → JSON Schema Transformation 

## Context

Convert the canonical SQL DDL in
`/db/migrations/01_<domain>.sql` into a normalized **Draft 2020-12 JSON Schema** file.

---

## Constraints

* **Target draft:** JSON Schema **Draft 2020-12**

* **Definitions** keyed by **singular** table names (e.g. `Customer`, `PostalAddress`)

* **SQL → JSON type mapping**

  | SQL type               | JSON Schema representation                         |
  |------------------------|----------------------------------------------------|
  | `UUID`                 | `"type": "string", "format": "uuid"`               |
  | `SERIAL` / integer PKs | `"type": "integer"`                                |
  | `VARCHAR(n)`           | `"type": "string", "maxLength": n`                 |
  | `CHAR(n)`              | `"type": "string", "minLength": n, "maxLength": n` |
  | `BOOLEAN`              | `"type": "boolean"`                                |

* **Required vs nullable** – any column declared `NOT NULL` must appear in the definition’s `"required"` array.

* **Primary keys** – record in both:

    * `"required"` array
    * `x-db.primaryKey`

* **Foreign keys** – capture under `x-db.foreignKey`, e.g.:

  ```json
  "x-db": {
    "foreignKey": { "column": "address_id", "ref": "PostalAddress.address_id" }
  }
  ```

* **Unique constraints** & **indexes** – list under `x-db.unique` and `x-db.indexes`.

* **Schema name** – add a root-level block:

  ```json
  "x-db": {
    "schema": "<domain>"
  }
  ```

  > **New requirement** ← ensures consumers know the exact PostgreSQL schema of all entities.

* **Output path**

  ```
  project_root/db/entity-specs/<domain>-entities.json
  ```

* **No file header** – emit *pure* JSON Schema (no Markdown, no comments).

---

## Inputs

| Item              | Value                                |
| ----------------- | ------------------------------------ |
| **Domain** | `<domain>` (e.g. `customer_profile`) |
| **SQL DDL**       | `/db/migrations/01_<domain>.sql`     |

---

## Output

A single file at `project_root/db/entity-specs/<domain>-entities.json`:

```json
{
  "$schema": "https://json-schema.org/draft/2020-12/schema",
  "$id": "<repo-root>/entity-specs/<domain>-entities.json",
  "title": "<domain> Domain Entities",
  "type": "object",
  "x-db": { "schema": "<domain>" },
  "definitions": {
    /* one definition per table */
  }
}
```

Each definition **must** include:

* `type`, `properties`, `required`
* `x-db.primaryKey`
* `x-db.foreignKey`
* `x-db.unique`
* `x-db.indexes`

---

## Task Steps

1. **Review** `/db/migrations/01_<domain>.sql`
   Identify tables, columns, constraints, and indexes.
2. **Parse** the DDL (script or parser) capturing:

    * Column name, data type, nullability
    * Primary-key, foreign-key, unique constraints
    * Explicit indexes
3. **Map** each table → JSON Schema definition:

    * Apply type mappings
    * Populate `"required"` from `NOT NULL` columns
    * Fill `x-db.*` sections
4. **Assemble** the final JSON document with the root-level `"x-db.schema"`.
5. **Validate** with a Draft 2020-12 linter (e.g. AJV).
6. **Record** any Architectural Decision Record (ADR) if mapping deviates from conventions.

---

## Acceptance Criteria

* `project_root/db/entity-specs/<domain>-entities.json` exists.
* JSON is valid Draft 2020-12 and passes `ajv validate`.
* All tables from the DDL are represented with correct types & required fields.
* Root-level `"x-db.schema"` matches the PostgreSQL schema name in the DDL.
* All PKs, FKs, uniques, and indexes are captured under `x-db.*`.
* File path and branch naming follow project standards.


## Example Execution 

**Inputs**

domain = customer_profile

SQL DDL =

```sql
-- App: Initial Full-Stack Application
-- Package: db
-- File: 20250610120000_create_customer_profile_tables.sql
-- Version: 0.1.0
-- Author: AI Agent
-- Date: 2025-06-10
-- Description: Creates the customer_profile schema and normalized tables.

BEGIN;

-- 1. Ensure the schema exists
CREATE SCHEMA IF NOT EXISTS customer_profile;

-- 2. Work inside that schema for the rest of the script
SET search_path TO customer_profile, public;

/* ---------- Reference tables ---------- */
CREATE TABLE IF NOT EXISTS postal_address (
                                              address_id  SERIAL PRIMARY KEY,
                                              line1       VARCHAR(255) NOT NULL,
                                              line2       VARCHAR(255),
                                              city        VARCHAR(100) NOT NULL,
                                              state       VARCHAR(50)  NOT NULL,
                                              postal_code VARCHAR(20),
                                              country     CHAR(2)      NOT NULL
);

CREATE TABLE IF NOT EXISTS privacy_settings (
                                                privacy_settings_id      SERIAL  PRIMARY KEY,
                                                marketing_emails_enabled BOOLEAN NOT NULL,
                                                two_factor_enabled       BOOLEAN NOT NULL
);

/* ---------- Root entity ---------- */
CREATE TABLE IF NOT EXISTS customer (
                                        customer_id         UUID PRIMARY KEY,
                                        first_name          VARCHAR(255) NOT NULL,
                                        middle_name         VARCHAR(255),
                                        last_name           VARCHAR(255) NOT NULL,
                                        address_id          INT  REFERENCES postal_address(address_id),
                                        privacy_settings_id INT  REFERENCES privacy_settings(privacy_settings_id)
);

CREATE INDEX IF NOT EXISTS idx_customer_address_id
    ON customer (address_id);
CREATE INDEX IF NOT EXISTS idx_customer_privacy_settings_id
    ON customer (privacy_settings_id);

/* ---------- One-to-many collections ---------- */
CREATE TABLE IF NOT EXISTS customer_email (
                                              email_id    SERIAL PRIMARY KEY,
                                              customer_id UUID NOT NULL REFERENCES customer(customer_id) ON DELETE CASCADE,
                                              email       VARCHAR(255) NOT NULL,
                                              UNIQUE (customer_id, email)
);
CREATE INDEX IF NOT EXISTS idx_customer_email_customer_id
    ON customer_email (customer_id);

CREATE TABLE IF NOT EXISTS customer_phone_number (
                                                     phone_id    SERIAL PRIMARY KEY,
                                                     customer_id UUID NOT NULL REFERENCES customer(customer_id) ON DELETE CASCADE,
                                                     type        VARCHAR(20) NOT NULL,
                                                     number      VARCHAR(15) NOT NULL,
                                                     UNIQUE (customer_id, number)
);
CREATE INDEX IF NOT EXISTS idx_customer_phone_customer_id
    ON customer_phone_number (customer_id);

COMMIT;
```

**output**

File: project_root/db/entity-specs/customer_profile-entities.json

```json
{
  "$schema": "https://json-schema.org/draft/2020-12/schema",
  "$id": "<repo-root>/entity-specs/customer_profile-entities.json",
  "title": "customer_profile Domain Entities",
  "type": "object",
  "x-db": { "schema": "customer_profile" },
  "definitions": {
    "PostalAddress": {
      "type": "object",
      "properties": {
        "address_id": { "type": "integer" },
        "line1":      { "type": "string", "maxLength": 255 },
        "line2":      { "type": "string", "maxLength": 255 },
        "city":       { "type": "string", "maxLength": 100 },
        "state":      { "type": "string", "maxLength": 50 },
        "postal_code":{ "type": "string", "maxLength": 20 },
        "country":    { "type": "string", "minLength": 2, "maxLength": 2 }
      },
      "required": [ "address_id", "line1", "city", "state", "country" ],
      "x-db": {
        "primaryKey": [ "address_id" ]
      }
    },

    "PrivacySettings": {
      "type": "object",
      "properties": {
        "privacy_settings_id":     { "type": "integer" },
        "marketing_emails_enabled":{ "type": "boolean" },
        "two_factor_enabled":      { "type": "boolean" }
      },
      "required": [
        "privacy_settings_id",
        "marketing_emails_enabled",
        "two_factor_enabled"
      ],
      "x-db": {
        "primaryKey": [ "privacy_settings_id" ]
      }
    },

    "Customer": {
      "type": "object",
      "properties": {
        "customer_id":         { "type": "string", "format": "uuid" },
        "first_name":          { "type": "string", "maxLength": 255 },
        "middle_name":         { "type": "string", "maxLength": 255 },
        "last_name":           { "type": "string", "maxLength": 255 },
        "address_id":          { "type": "integer" },
        "privacy_settings_id": { "type": "integer" }
      },
      "required": [ "customer_id", "first_name", "last_name" ],
      "x-db": {
        "primaryKey": [ "customer_id" ],
        "foreignKey": [
          { "column": "address_id",          "ref": "PostalAddress.address_id" },
          { "column": "privacy_settings_id", "ref": "PrivacySettings.privacy_settings_id" }
        ],
        "indexes": [
          [ "address_id" ],
          [ "privacy_settings_id" ]
        ]
      }
    },

    "CustomerEmail": {
      "type": "object",
      "properties": {
        "email_id":    { "type": "integer" },
        "customer_id": { "type": "string", "format": "uuid" },
        "email":       { "type": "string", "maxLength": 255 }
      },
      "required": [ "email_id", "customer_id", "email" ],
      "x-db": {
        "primaryKey": [ "email_id" ],
        "foreignKey": { "column": "customer_id", "ref": "Customer.customer_id" },
        "unique":     [ [ "customer_id", "email" ] ],
        "indexes":    [ [ "customer_id" ] ]
      }
    },

    "CustomerPhoneNumber": {
      "type": "object",
      "properties": {
        "phone_id":    { "type": "integer" },
        "customer_id": { "type": "string", "format": "uuid" },
        "type":        { "type": "string", "maxLength": 20 },
        "number":      { "type": "string", "maxLength": 15 }
      },
      "required": [ "phone_id", "customer_id", "type", "number" ],
      "x-db": {
        "primaryKey": [ "phone_id" ],
        "foreignKey": { "column": "customer_id", "ref": "Customer.customer_id" },
        "unique":     [ [ "customer_id", "number" ] ],
        "indexes":    [ [ "customer_id" ] ]
      }
    }
  }
}

```

```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../agentic-pipeline/tools/json_schema_to_sql_transformation_tool.md

```markdown
# TASK 01 - DB - JSON Schema to SQL Transformation


**Context**:  
Convert a JSON schema into normalized DDL SQL statements.  
Directory: `/db`

**Constraints**:
- Use PostgreSQL v16 dialect
- Normalize to at least 3NF
- Use singular table names (e.g., customer, order_item)
- Include indexes for foreign keys and queryable fields
- Use CREATE TABLE IF NOT EXISTS
- Follow project naming conventions
- Replace NN in file path with incremented number. ie db/migrations/01_<domain>_.sql

**Inputs**

- Domain: referenced in Ticket.
- JSON Schema referenced in Ticket.

**Output**:  

- A complete SQL file with metadata header, table definitions, foreign keys, and indexes.
- File path: db/migrations/NN_<domain>_.sql

**Task**:  
Generate a migration in `db/migrations/NN_<schema title>_tables.sql` that:
- Creates normalized tables from the JSON schema referenced in ticket.
- Infers data types and constraints (PRIMARY KEY, FOREIGN KEY, UNIQUE)
- Maps nested objects ie (`customer`, `shipping_address`) to separate tables
- Converts arrays (`items`) to a related table
- Creates a flattened views of the domain. 

**Workflow Outline**

1. **Review the DB task file** to confirm conventions, timestamp rules, and required header fields.
2. **Parse the customer JSON schema** to derive an entity-relationship outline (e.g., `customer`, `customer_address`, `customer_contact`, etc.).
3. **Draft SQL** with all constraints and indexes (`btree` on foreign keys, `GIN` or `btree` on heavily-queried columns).

**Acceptance Criteria**
* Expected Outputs were created.
* Each file contains a metadata header block.
* Uses `CREATE TABLE IF NOT EXISTS` statements valid for PostgreSQL 16.
* Implements all keys, constraints, and indexes required by the JSON schema.
* Naming conventions, timestamp format, and directory layout match project standards.
* `project_root/db/README.md` gains a short “Domain Migration” section describing how to execute the migration and smoke tests locally.

## Example Execution 

**Inputs**
domain = customer_profile
sql schema name = domain

**JSON Schema**:
```json
{
  "$schema": "http://json-schema.org/draft-07/schema#",
  "title": "CustomerProfile",
  "type": "object",
  "properties": {
    "id": {
      "type": "string",
      "format": "uuid",
      "description": "Unique identifier for the customer profile"
    },
    "firstName": {
      "type": "string",
      "minLength": 1,
      "description": "Customer’s given name"
    },
    "middleName": {
      "type": "string",
      "description": "Customer’s middle name or initial",
      "minLength": 1
    },
    "lastName": {
      "type": "string",
      "minLength": 1,
      "description": "Customer’s family name"
    },
    "emails": {
      "type": "array",
      "description": "List of the customer’s email addresses",
      "items": {
        "type": "string",
        "format": "email"
      },
      "minItems": 1,
      "uniqueItems": true
    },
    "phoneNumbers": {
      "type": "array",
      "description": "List of the customer’s phone numbers",
      "items": {
        "$ref": "#/definitions/PhoneNumber"
      },
      "minItems": 1
    },
    "address": {
      "$ref": "#/definitions/PostalAddress"
    },
    "privacySettings": {
      "$ref": "#/definitions/PrivacySettings"
    }
  },
  "required": [
    "id",
    "firstName",
    "lastName",
    "emails",
    "privacySettings"
  ],
  "additionalProperties": false,
  "definitions": {

    "PhoneNumber": {
      "type": "object",
      "properties": {
        "type": {
          "type": "string",
          "description": "Type of phone number",
          "enum": ["mobile", "home", "work", "other"]
        },
        "number": {
          "type": "string",
          "pattern": "^\\+?[1-9]\\d{1,14}$",
          "description": "Phone number in E.164 format"
        }
      },
      "required": ["type", "number"],
      "additionalProperties": false
    },
    "PostalAddress": {
      "type": "object",
      "properties": {
        "line1": {
          "type": "string",
          "minLength": 1,
          "description": "Street address, P.O. box, company name, c/o"
        },
        "line2": {
          "type": "string",
          "description": "Apartment, suite, unit, building, floor, etc."
        },
        "city": {
          "type": "string",
          "minLength": 1,
          "description": "City or locality"
        },
        "state": {
          "type": "string",
          "minLength": 1,
          "description": "State, province, or region"
        },
        "postalCode": {
          "type": "string",
          "description": "ZIP or postal code"
        },
        "country": {
          "type": "string",
          "minLength": 2,
          "maxLength": 2,
          "description": "ISO 3166-1 alpha-2 country code"
        }
      },
      "required": ["line1", "city", "state", "postalCode", "country"],
      "additionalProperties": false
    },
    "PrivacySettings": {
      "type": "object",
      "properties": {
        "marketingEmailsEnabled": {
          "type": "boolean",
          "description": "Whether the user opts in to marketing emails"
        },
        "twoFactorEnabled": {
          "type": "boolean",
          "description": "Whether two-factor authentication is enabled"
        }
      },
      "required": [
        "marketingEmailsEnabled",
        "twoFactorEnabled"
      ],
      "additionalProperties": false
    }
  }
}
````

**Expected Output**:

```sql
-- App: Initial Full-Stack Application
-- Package: db
-- File: 20250610120000_create_customer_profile_tables.sql
-- Version: 0.1.0
-- Author: AI Agent
-- Date: 2025-06-10
-- Description: Creates the customer_profile schema and normalized tables.

BEGIN;

-- 1. Ensure the schema exists
CREATE SCHEMA IF NOT EXISTS customer_profile;

-- 2. Work inside that schema for the rest of the script
SET search_path TO customer_profile, public;

/* ---------- Reference tables ---------- */
CREATE TABLE IF NOT EXISTS postal_address (
                                              address_id  SERIAL PRIMARY KEY,
                                              line1       VARCHAR(255) NOT NULL,
                                              line2       VARCHAR(255),
                                              city        VARCHAR(100) NOT NULL,
                                              state       VARCHAR(50)  NOT NULL,
                                              postal_code VARCHAR(20),
                                              country     CHAR(2)      NOT NULL
);

CREATE TABLE IF NOT EXISTS privacy_settings (
                                                privacy_settings_id      SERIAL  PRIMARY KEY,
                                                marketing_emails_enabled BOOLEAN NOT NULL,
                                                two_factor_enabled       BOOLEAN NOT NULL
);

/* ---------- Root entity ---------- */
CREATE TABLE IF NOT EXISTS customer (
                                        customer_id         UUID PRIMARY KEY,
                                        first_name          VARCHAR(255) NOT NULL,
                                        middle_name         VARCHAR(255),
                                        last_name           VARCHAR(255) NOT NULL,
                                        address_id          INT  REFERENCES postal_address(address_id),
                                        privacy_settings_id INT  REFERENCES privacy_settings(privacy_settings_id)
);

CREATE INDEX IF NOT EXISTS idx_customer_address_id
    ON customer (address_id);
CREATE INDEX IF NOT EXISTS idx_customer_privacy_settings_id
    ON customer (privacy_settings_id);

/* ---------- One-to-many collections ---------- */
CREATE TABLE IF NOT EXISTS customer_email (
                                              email_id    SERIAL PRIMARY KEY,
                                              customer_id UUID NOT NULL REFERENCES customer(customer_id) ON DELETE CASCADE,
                                              email       VARCHAR(255) NOT NULL,
                                              UNIQUE (customer_id, email)
);
CREATE INDEX IF NOT EXISTS idx_customer_email_customer_id
    ON customer_email (customer_id);

CREATE TABLE IF NOT EXISTS customer_phone_number (
                                                     phone_id    SERIAL PRIMARY KEY,
                                                     customer_id UUID NOT NULL REFERENCES customer(customer_id) ON DELETE CASCADE,
                                                     type        VARCHAR(20) NOT NULL,
                                                     number      VARCHAR(15) NOT NULL,
                                                     UNIQUE (customer_id, number)
);
CREATE INDEX IF NOT EXISTS idx_customer_phone_customer_id
    ON customer_phone_number (customer_id);

COMMIT;
```




```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../agentic-pipeline/turns/1/adr.md

```markdown
# ADR 1: Person CRUD Service with WebFlux

Status: Accepted
Date: 2025-09-06

## Context
The project requires a lightweight CRUD API for managing persons without persistent storage. The API must be reactive and documented via OpenAPI.

## Decision
Use Spring WebFlux with an in-memory `ConcurrentHashMap` to store `Person` records. Expose endpoints under `/api/persons` and document them using springdoc OpenAPI annotations.

## Consequences
- Positive: No external database dependency; low overhead and fast development.
- Negative: Data is ephemeral and lost on application restart.
- Follow-up: Introduce persistent storage in a future iteration if needed.

```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../agentic-pipeline/turns/1/changelog.md

```markdown
# Turn 1 — Changelog
Date (UTC): 2025-09-06 02:28:22
Task: create-rest-service

## Summary
Implemented asynchronous Person CRUD REST service with tests and E2E scenario.

## Changes
- Added Person domain, request DTO, service, controller, and exception.
- Added unit and integration tests for Person domain.
- Added e2e/person.http for full lifecycle testing.

## SemVer Impact
- Minor: introduces new public Person endpoints.

## Linked Artifacts
- ADR: ./adr.md
- Manifest: ./manifest.json

```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../agentic-pipeline/turns/1/manifest.json

```json
{
  "turnId": 1,
  "timestampUtc": "2025-09-06T02:28:22Z",
  "task": "create-rest-service",
  "changes": {
    "added": [
      "src/main/java/com/bobwares/registration/PersonRequest.java",
      "src/main/java/com/bobwares/registration/Person.java",
      "src/main/java/com/bobwares/registration/PersonNotFoundException.java",
      "src/main/java/com/bobwares/registration/PersonService.java",
      "src/main/java/com/bobwares/registration/PersonController.java",
      "src/test/java/com/bobwares/registration/PersonServiceTests.java",
      "src/test/java/com/bobwares/registration/PersonControllerIT.java",
      "e2e/person.http",
      "ai/agentic-pipeline/turns/1/changelog.md",
      "ai/agentic-pipeline/turns/1/adr.md",
      "ai/agentic-pipeline/turns/1/manifest.json",
      "turns/index.csv"
    ],
    "modified": [
      "changelog.md"
    ],
    "deleted": []
  }
}

```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../agentic-pipeline/turns/1/prompt-turn-1.md

```markdown
execute task project_root/ai/agentic-pipeline/tasks/create_rest_service.task.md

Inputs
- API Request Schema: project_root/schemas/person.schema.json
- Package root: com.bobwares.registration
- Project name: Person CRUD Service
- Version seed: 0.1.0
```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../agentic-pipeline/turns/prompt-turn-1.3.md

```markdown
execute task project_root/ai/agentic-pipeline/tasks/create_sql_dll_from_schema.task.md

Inputs
- API Request Schema: project_root/schemas/customer.schema.json
- Package root: com.bobwares.customer
- Project name: Customer Profile CRUD Service
- Version seed: 0.1.0
```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../docs/Agentic Pipeline Definition.md

```markdown
# ChatGPT Codex Agentic Pipeline

## Overview

This repository defines an **agentic pipeline** for the ChatGPT Codex environment.
The pipeline enables iterative, tool-driven software generation where each execution is called a **turn**.

Key features:

* Structured orchestration via `AGENTS.md`
* Tool and task separation for modularity
* Persistent turn history with logs, inputs, outputs, and artifacts
* Metadata headers and versioning standards across all generated files
* Automated changelogs and Architecture Decision Records (ADRs)

---

## Concepts

### Turns

* A **turn** represents one execution of a Codex task.
* Each turn has a unique **Turn ID** (integer, incremented by 1 for each new turn).
* Turns create artifacts including:

    * **Changelog** entries
    * **Architecture Decision Records (ADR)**
    * Input and output directories for reproducibility

### Tasks

* A **task** is a prompt or workflow unit that Codex executes.
* Tasks are defined in `/tasks/` using Markdown (`*.prompt.md`), YAML, or JSON schemas.
* Tasks are modular and reusable, allowing flexible orchestration.

### Tools

* **Tools** encapsulate reusable operations that tasks can call.
* Examples:

    * SQL DDL generator
    * Test data generator
    * E2E HTTP test generator
    * OpenAPI annotator

### Orchestration (`AGENTS.md`)

* The **Codex agent** is configured in `AGENTS.md`.
* Defines how tools are chained together and how Codex interprets user requests.
* Enforces metadata headers and versioning for all generated files.

---

## Repository Layout

```
/AGENTS.md
/tasks/
  person-crud-tool.prompt.md
  task.schema.json
  task.person-crud.yaml
/tools/
  sql-ddl.prompt.md
  test-data.prompt.md
  e2e-http.prompt.md
  openapi-annotate.prompt.md
/turns/
  index.csv
  2025-09-05T183000Z_turn-004/
    inputs/
    outputs/
    logs/
    artifacts/
agentic/
  context.schema.json
  tool.schema.json
  pipeline.config.yaml
version.md
```

---

## Metadata Standards

All source code, config, and prompt files must include a **metadata header**:

```
# App: {application-name}
# Package: {package-name}
# File: {file-name}
# Version: {semantic-version}
# Author: {author}
# Date: {ISO-8601 timestamp}
# Exports: {main classes, functions, or artifacts}
# Description: {purpose of this file}
```

Updates must also be recorded in `version.md`.

---

## Workflow

1. **Start a Turn**

    * Increment Turn ID in `/turns/index.csv`.
    * Create a new turn directory (`/turns/{timestamp}_turn-{id}`).

2. **Execute a Task**

    * Run the chosen task through Codex.
    * Codex selects tools as needed.

3. **Generate Outputs**

    * Store results in `outputs/`.
    * Capture logs in `logs/`.

4. **Record Artifacts**

    * Store generated code, schemas, or configs in `artifacts/`.
    * Write/update ADR and changelog.

5. **Versioning**

    * Update file headers and `version.md`.

---

## Example Pipeline Flow

1. User requests a new CRUD module.
2. Codex executes the **CRUD task** → uses:

    * `sql-ddl.prompt.md` (generate SQL DDL)
    * `test-data.prompt.md` (generate test cases)
    * `e2e-http.prompt.md` (generate HTTP tests)
3. Outputs and artifacts stored under the active turn.
4. Changelog updated with the new feature.
5. ADR written to document design decisions.

---

## Goals

* Ensure reproducibility of every Codex execution
* Enforce standards for metadata and versioning
* Provide traceability via changelogs and ADRs
* Build modular, extensible pipelines that grow with project complexity

```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../docs/Turns_Technical_Design.md

```markdown
# Turns: Technical Design

## Core definitions

* **Turn**: a single execution of a Codex task (plan, generate, refactor, test, etc).
* **Turn ID**: a monotonically increasing integer. Initial value `1`. Incremented by `1` at the start of each new turn.
* **Artifacts per turn**:

    1. a changelog,
    2. an Architecture Decision Record (ADR),
    3. a manifest that indexes everything created/changed,
    4. optional logs (stdout/stderr), diffs, and test reports.

## Repository layout

```
/ai/agentic-pipeline/turns/
  1/
    manifest.json
    changelog.md
    adr.md
    diff.patch
    logs/
      task.log
      llm_prompt.txt
      llm_response.txt
    reports/
      tests.xml
      coverage.json

/turns/index.csv   # append-only registry of all turns
/docs/adr/         # (optional) symlink or copy of adr.md per turn if centralized ADRs are desired
```

## Turn lifecycle

1. **Plan**

    * Resolve inputs (task, domain schema, constraints).
    * Allocate next Turn ID (increment integer).
    * Create `/turns/<TurnID>/manifest.json` with initial metadata.

2. **Execute**

    * Run tools (e.g., codegen, tests).
    * Capture logs, diffs, generated files.

3. **Record**

    * Write `changelog.md` (human-readable delta, semver implications).
    * Write `adr.md` (context, options, decision, consequences).
    * Finalize `manifest.json` (hashes, file list, metrics).

4. **Commit & tag**

    * Commit with conventional message and the Turn ID.
    * Tag `turn/<TurnID>`.
    * Optionally open a PR referencing the Turn ID.

## Git integration

* **Branch naming (optional)**: `turn/<TurnID>[-<task>]`
* **Commit message template**:

  ```
  turn: <TurnID> <task> <scope>

  - Summary of changes
  - Key decisions: ADR#<TurnID>
  - Affected modules: <paths>
  - Tests: <added/updated status>

  Co-authored-by: Codex Agent <agent@local>
  ```
* **Tag**: `turn/<TurnID>` on the merge commit to main.
* **CI**: require presence/validity of `manifest.json`, `adr.md`, `changelog.md` for any turn branch.

## File specifications

### manifest.json (authoritative index)

Minimal schema:

```json
{
  "turnId": 1,
  "timestampUtc": "2025-09-05T17:42:10Z",
  "actor": {
    "initiator": "bobwares",
    "agent": "codex@1.0.0"
  },
  "task": {
    "name": "generate-controllers-and-services",
    "inputs": [
      "schemas/custodian.domain.schema.json"
    ],
    "parameters": {
      "language": "java",
      "framework": "spring-boot",
      "openapi": true
    }
  },
  "git": {
    "headBefore": "a1b2c3d",
    "headAfter": "d4e5f6a",
    "branch": "turn/1-generate",
    "tag": "turn/1"
  },
  "artifacts": {
    "changelog": "changelog.md",
    "adr": "adr.md",
    "diff": "diff.patch",
    "logs": ["logs/task.log", "logs/llm_prompt.txt", "logs/llm_response.txt"],
    "reports": ["reports/tests.xml", "reports/coverage.json"]
  },
  "changes": {
    "added": ["src/main/java/..."],
    "modified": ["..."],
    "deleted": []
  },
  "metrics": {
    "filesChanged": 12,
    "linesAdded": 350,
    "linesDeleted": 40,
    "testsPassed": 42,
    "testsFailed": 0,
    "coverageDeltaPct": 1.8
  },
  "validation": {
    "adrPresent": true,
    "changelogPresent": true,
    "lintStatus": "passed",
    "testsStatus": "passed"
  }
}
```

### changelog.md (human-readable delta)

```
# Turn 1 — Changelog
Date (UTC): 2025-09-05 17:42:10
Task: generate-controllers-and-services
Scope: customer, policy

## Summary
Generate CRUD controllers/services with OpenAPI annotations. Add integration tests.

## Changes
- Added: src/main/java/com/acme/customer/CustomerController.java
- Added: src/main/java/com/acme/customer/CustomerService.java
- Modified: build.gradle (add springdoc-openapi)
- Added: src/test/java/.../CustomerControllerIT.java

## Migrations
- None.

## SemVer Impact
- Minor: new public endpoints added, no breaking changes.

## Risks & Mitigations
- Risk: endpoint auth gaps. Mitigation: add security config in next turn.

## Linked Artifacts
- ADR: ./adr.md
- Diff: ./diff.patch
- Manifest: ./manifest.json
```

### adr.md (Architecture Decision Record)

```
# ADR 1: Controllers/Services with Spring Boot + OpenAPI

Date: 2025-09-05

## Status
Accepted

## Context
We need REST CRUD endpoints generated from the Custodian domain schema, with discoverable API docs.

## Options Considered
1) Spring MVC + springdoc-openapi
2) JAX-RS + Swagger (Quarkus/Jersey)
3) NestJS (Typescript) adapter to existing Node code

## Decision
Choose Spring MVC + springdoc-openapi. Aligns with existing Java stack, reduces cognitive load, integrates with current test infra.

## Consequences
- Positive: Low-friction developer experience, auto OpenAPI docs, easy testing.
- Negative: Ties us to Spring ecosystem for these services.
- Follow-ups: Add security annotations and global exception handlers next turn.

## References
- Manifest: ./manifest.json
- Changelog: ./changelog.md
- PR: <link or ID>
```

## CLI interface (thin wrapper)

Example commands:

```
codex-turn init --task generate-controllers-and-services --inputs schemas/custodian.domain.schema.json
codex-turn run  --plan file://plans/generate-controllers.yaml
codex-turn record --from-git --collect-logs
codex-turn finalize --commit --tag --open-pr
```

Behavior:

* `init` increments Turn ID, scaffolds `/turns/<TurnID>/`.
* `run` executes the task with logging.
* `record` computes `diff.patch`, detects changed files, builds `manifest.json`.
* `finalize` checks required artifacts, commits with conventional message, tags.

## CI policy

* Job `validate-turn` runs on any branch starting with `turn/`.
* Steps:

    1. Validate `manifest.json` against JSON Schema.
    2. Ensure `adr.md` and `changelog.md` exist and are non-empty.
    3. Ensure `diff.patch` matches repo delta.
    4. Run lint/tests; annotate metrics back into `manifest.json`.
    5. Upload `/turns/<TurnID>/` as build artifact.

Fail the build if any required artifact is missing.

## Commit conventions

* Conventional header style:

    * `turn: <TurnID> <task> [scope]`
* Example:

  ```
  turn: 1 generate-controllers-and-services [customer, policy]
  ```
* Footer fields (machine-parsable):

  ```
  Turn-Id: 1
  Turn-Task: generate-controllers-and-services
  Turn-Metrics-FilesChanged: 12
  Turn-Metrics-TestsPassed: 42
  ```

## Indexing

Append one line per turn to `/turns/index.csv`:

```
turnId,timestampUtc,task,branch,tag,headAfter,testsPassed,testsFailed,coverageDeltaPct
1,2025-09-05T17:42:10Z,generate-controllers-and-services,turn/1,turn/1,d4e5f6a,42,0,1.8
```

```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../prompts/prompt-2.md

```markdown
# tasks

- update missing meta data headers.
- add Makefile


# Pipeline
- Create new entry in ./ai/history for each turn.
- Create entry in ./ai/version for each turn.
- execute tasks

# Coding Standards

## Metadata Header

— Every source, test, and IAC file must begin with Metadata Header comment section.
- Placement: Top of file, above any import or code statements.
- Version: Increment only when the file contents change.
- Date: UTC timestamp of the most recent change.


- Template
    ```markdown
      /**
      * App: {{Application Name}}
      * Package: {{package}}
      * File: {{file name}}
      * Version: semantic versioning starting at 0.1.0
      * Author: {{author}}
      * Date: {{YYYY-MM-DDThh:mm:ssZ}}
      * Exports: {{ exported functions, types, and variables.}}
      * Description: Level-5 documentation of the class or function. Document each
      *              method or function in the file.
      */
    ````

## Turn Rules

      * Use **semantic versioning** (`MAJOR.MINOR.PATCH`).
      * Track changes each “AI turn” in `project_root/changelog.md`.
      * Start at **0.1.0**; update only when code or configuration changes.
      * Record only the sections that changed.

    ```markdown
    # Version History
    
    ### 0.0.1 – 2025-06-08 06:58:24 UTC (main)
    
    #### Task
    <Task>
    
    #### Changes
    - Initial project structure and configuration.
    
    ### 0.0.2 – 2025-06-08 07:23:08 UTC (work)
    
    #### Task
    <Task>
    
    #### Changes
    - Add tsconfig for ui and api.
    - Create src directories with unit-test folders.
    - Add e2e test directory for Playwright.
    ```

## ADR (Architecture Decision Record)

### Purpose

The `/adr` folder captures **concise, high-signal Architecture Decision Records** whenever the
AI coding agent (or a human) makes a non-obvious technical or architectural choice.
Storing ADRs keeps the project’s architectural rationale transparent and allows reviewers to
understand **why** a particular path was taken without trawling through commit history or code
comments.

### Location

```
project_root/ai/turns/current turn directory/adr.md
```

### When the Agent Must Create an ADR

| Scenario                                                     | Example                                                                                                                                                                                                                                                                | Required? |
|--------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------|
| Summarize Chain of Thought reasoning for the task           | Documenting the decision flow: ① capture requirements for a low-latency, pay-per-request CRUD API → ② compare DynamoDB single-table vs. Aurora Serverless → ③ choose DynamoDB single-table with GSI on email for predictable access patterns and minimal ops overhead. | **Yes**   |
| Selecting one library or pattern over plausible alternatives | Choosing Prisma instead of TypeORM                                                                                                                                                                                                                                     | **Yes**   |
| Introducing a new directory or module layout                 | Splitting `customer` domain into bounded contexts                                                                                                                                                                                                                      | **Yes**   |
| Changing a cross-cutting concern                             | Switching error-handling strategy to functional `Result` types                                                                                                                                                                                                         | **Yes**   |
| Cosmetic or trivial change                                   | Renaming a variable                                                                                                                                                                                                                                                    | **Yes**   |


### Minimal ADR Template

```markdown
# {{ADR Title}}

**Status**: Proposed | Accepted | Deprecated

**Date**: {{YYYY-MM-DD}}

**Context**  
Briefly explain the problem or decision context.

**Decision**  
State the choice that was made.

**Consequences**  
List the trade-offs and implications (positive and negative).  
```

```

## File: .//Users/bobware/projects/0-codex-starters/java-spring-boot-codex-starter/ai/project-parser/../prompts/prompt.md

```markdown
# tasks

- convert application.properties to application.yml
- add health check api package: com.bobwares.common.health
- add support for latest junit testing.
- add .http test under ./e2e to test health endpoint
- 
# Pipeline
- Create new entry in ./ai/history for each turn.  
- Create entry in ./ai/version for each turn.
- execute tasks


```

