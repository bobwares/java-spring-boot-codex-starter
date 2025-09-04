1. add endpoint
- person
- async
- get/put/delete/update 


- schema
```markdown
{
  "$schema": "https://json-schema.org/draft/2020-12/schema",
  "title": "PersonAddress",
  "type": "object",
  "properties": {
    "first_name": {
      "type": "string",
      "minLength": 1
    },
    "last_name": {
      "type": "string",
      "minLength": 1
    },
    "city": {
      "type": "string",
      "minLength": 1
    },
    "state": {
      "type": "string",
      "minLength": 2,
      "maxLength": 2,
      "description": "Two-letter state abbreviation"
    },
    "zip": {
      "type": "string",
      "pattern": "^[0-9]{5}(-[0-9]{4})?$",
      "description": "US ZIP code (5 digits or ZIP+4)"
    }
  },
  "required": ["first_name", "last_name", "city", "state", "zip"],
  "additionalProperties": false
}

```