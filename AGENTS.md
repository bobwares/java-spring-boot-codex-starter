

# Turns

open and read file project_root/ai/Turns - Technical Design.md


## Metadata Header

— Every source, test, and IAC file must begin with Metadata Header comment section.
- exclude pom.xml
- Placement: Top of file, above any import or code statements.
- Version: Increment only when the file contents change.
- Date: UTC timestamp of the most recent change.


### Metadata Header Template
    ```markdown
      /**
      * App: {{Application Name}}
      * Package: {{package}}
      * File: {{file name}}
      * Version: semantic versioning starting at 0.1.0
      * Turns: append {{turn number}} list when created or updated.
      * Author: {{author}}
      * Date: {{YYYY-MM-DDThh:mm:ssZ}}
      * Exports: {{ exported functions, types, and variables.}}
      * Description: Level-5 documentation of the class or function. Document each
      *              method or function in the file.
      */
    ````

### Source Versioning Rules

      * Use **semantic versioning** (`MAJOR.MINOR.PATCH`).
      * Start at **0.1.0**; update only when code or configuration changes.
      * Update the version in the source file if it is updated during a turn.


## Change Log

- Track changes each “AI turn” in: project_root/ai/turns/current turn directory/changelog.md
- append changes to project change log located project_root/changelog.md

### Change Log Entry Template

    # Turn 
    
    ### {{turn number}}  – {{Date Time of execution}}
    
    ## prompt

    {{ input prompt}}

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

The adr.md` folder captures **concise, high-signal Architecture Decision Records** whenever the
AI coding agent (or a human) makes a non-obvious technical or architectural choice.
Storing ADRs keeps the project’s architectural rationale transparent and allows reviewers to
understand **why** a particular path was taken without trawling through commit history or code
comments.

### Location

    project_root/ai/turns/current turn directory/adr.md


### When the Agent Must Create an ADR

| Scenario                                                     | Example                                                                                                                                                                                                                                                                | Required? |
|--------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------|
| Summarize Chain of Thought reasoning for the task            | Documenting the decision flow: ① capture requirements for a low-latency, pay-per-request CRUD API → ② compare DynamoDB single-table vs. Aurora Serverless → ③ choose DynamoDB single-table with GSI on email for predictable access patterns and minimal ops overhead. | **Yes**   |
| Selecting one library or pattern over plausible alternatives | Choosing Prisma instead of TypeORM                                                                                                                                                                                                                                     | **Yes**   |
| Introducing a new directory or module layout                 | Splitting `customer` domain into bounded contexts                                                                                                                                                                                                                      | **Yes**   |
| Changing a cross-cutting concern                             | Switching error-handling strategy to functional `Result` types                                                                                                                                                                                                         | **Yes**   |
| Cosmetic or trivial change                                   | Renaming a variable                                                                                                                                                                                                                                                    | **Yes**   |

### Naming Convention

```
adr/YYYYMMDDnnn_<slugified-title>.md
```

* `YYYYMMDD` – calendar date in UTC
* `nnn` – zero-padded sequence number for that day
* `slugified-title` – short, lowercase, hyphen-separated summary

Example: `adr/20250611_001_use-prisma-for-orm.md`.

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
