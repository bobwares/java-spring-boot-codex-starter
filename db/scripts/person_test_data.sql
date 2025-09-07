-- App: Person CRUD Service
-- Package: com.bobwares.registration
-- File: person_test_data.sql
-- Version: 0.1.0
-- Turns: 2
-- Author: Codex
-- Date: 2025-09-07T01:22:38Z
-- Exports: sample person records
-- Description: Inserts sample person records for development testing.

BEGIN;

INSERT INTO person (person_id, first_name, last_name, city, state, zip) VALUES
    (1,'Alice','Smith','Springfield','IL','62701'),
    (2,'Bob','Johnson','Madison','WI','53703'),
    (3,'Carol','Williams','Austin','TX','73301'),
    (4,'David','Brown','Denver','CO','80014'),
    (5,'Eva','Jones','Phoenix','AZ','85001'),
    (6,'Frank','Miller','Portland','OR','97201'),
    (7,'Grace','Davis','Boston','MA','02108'),
    (8,'Hank','Wilson','Seattle','WA','98101'),
    (9,'Ivy','Moore','Atlanta','GA','30303'),
    (10,'Jack','Taylor','Miami','FL','33101')
ON CONFLICT DO NOTHING;

-- smoke test
SELECT COUNT(*) FROM person;

COMMIT;
