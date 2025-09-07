# TASK Generate Normalized Tables from JSON Schema

## Inputs

- API Request Schema (authoritative): `project_root/schemas/{{domain_object}}.schema.json`
- Package root: {{package_name}}
- Project name: {{project_name}}
- Version seed: `0.1.0`

## Workflow

- execute tool project_root/ai/agentic-pipeline/tools/db_sql_schema_to_json_schema.tool.md
- execute tool project_root/ai/agentic-pipeline/tools/create_test_data_for_schema.tool.md
- pass inputs



