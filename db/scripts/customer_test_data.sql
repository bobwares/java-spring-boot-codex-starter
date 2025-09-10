-- App: Customer Registration
-- Package: db.scripts
-- File: customer_test_data.sql
-- Version: 0.1.0
-- Turns: 2
-- Author: AI
-- Date: 2025-09-10T16:44:42Z
-- Exports: sample customer data
-- Description: Inserts sample customer data for testing purposes.

BEGIN;

-- Insert postal addresses
INSERT INTO postal_address (address_id, line1, line2, city, state, postal_code, country)
VALUES
    (1, '100 Main St', NULL, 'City1', 'ST', '10000', 'US'),
    (2, '200 Main St', NULL, 'City2', 'ST', '10001', 'US'),
    (3, '300 Main St', NULL, 'City3', 'ST', '10002', 'US'),
    (4, '400 Main St', NULL, 'City4', 'ST', '10003', 'US'),
    (5, '500 Main St', NULL, 'City5', 'ST', '10004', 'US'),
    (6, '600 Main St', NULL, 'City6', 'ST', '10005', 'US'),
    (7, '700 Main St', NULL, 'City7', 'ST', '10006', 'US'),
    (8, '800 Main St', NULL, 'City8', 'ST', '10007', 'US'),
    (9, '900 Main St', NULL, 'City9', 'ST', '10008', 'US'),
    (10, '1000 Main St', NULL, 'City10', 'ST', '10009', 'US'),
    (11, '1100 Main St', NULL, 'City11', 'ST', '10010', 'US'),
    (12, '1200 Main St', NULL, 'City12', 'ST', '10011', 'US'),
    (13, '1300 Main St', NULL, 'City13', 'ST', '10012', 'US'),
    (14, '1400 Main St', NULL, 'City14', 'ST', '10013', 'US'),
    (15, '1500 Main St', NULL, 'City15', 'ST', '10014', 'US'),
    (16, '1600 Main St', NULL, 'City16', 'ST', '10015', 'US'),
    (17, '1700 Main St', NULL, 'City17', 'ST', '10016', 'US'),
    (18, '1800 Main St', NULL, 'City18', 'ST', '10017', 'US'),
    (19, '1900 Main St', NULL, 'City19', 'ST', '10018', 'US'),
    (20, '2000 Main St', NULL, 'City20', 'ST', '10019', 'US');
ON CONFLICT DO NOTHING;

-- Insert privacy settings
INSERT INTO privacy_settings (privacy_settings_id, marketing_emails_enabled, two_factor_enabled)
VALUES
    (1, TRUE, FALSE),
    (2, FALSE, FALSE),
    (3, TRUE, TRUE),
    (4, FALSE, FALSE),
    (5, TRUE, FALSE),
    (6, FALSE, TRUE),
    (7, TRUE, FALSE),
    (8, FALSE, FALSE),
    (9, TRUE, TRUE),
    (10, FALSE, FALSE),
    (11, TRUE, FALSE),
    (12, FALSE, TRUE),
    (13, TRUE, FALSE),
    (14, FALSE, FALSE),
    (15, TRUE, TRUE),
    (16, FALSE, FALSE),
    (17, TRUE, FALSE),
    (18, FALSE, TRUE),
    (19, TRUE, FALSE),
    (20, FALSE, FALSE);
ON CONFLICT DO NOTHING;

-- Insert customers
INSERT INTO customer (customer_id, first_name, middle_name, last_name, address_id, privacy_settings_id)
VALUES
    ('00000000-0000-0000-0000-000000000001', 'First1', NULL, 'Last1', 1, 1),
    ('00000000-0000-0000-0000-000000000002', 'First2', NULL, 'Last2', 2, 2),
    ('00000000-0000-0000-0000-000000000003', 'First3', NULL, 'Last3', 3, 3),
    ('00000000-0000-0000-0000-000000000004', 'First4', NULL, 'Last4', 4, 4),
    ('00000000-0000-0000-0000-000000000005', 'First5', NULL, 'Last5', 5, 5),
    ('00000000-0000-0000-0000-000000000006', 'First6', NULL, 'Last6', 6, 6),
    ('00000000-0000-0000-0000-000000000007', 'First7', NULL, 'Last7', 7, 7),
    ('00000000-0000-0000-0000-000000000008', 'First8', NULL, 'Last8', 8, 8),
    ('00000000-0000-0000-0000-000000000009', 'First9', NULL, 'Last9', 9, 9),
    ('00000000-0000-0000-0000-000000000010', 'First10', NULL, 'Last10', 10, 10),
    ('00000000-0000-0000-0000-000000000011', 'First11', NULL, 'Last11', 11, 11),
    ('00000000-0000-0000-0000-000000000012', 'First12', NULL, 'Last12', 12, 12),
    ('00000000-0000-0000-0000-000000000013', 'First13', NULL, 'Last13', 13, 13),
    ('00000000-0000-0000-0000-000000000014', 'First14', NULL, 'Last14', 14, 14),
    ('00000000-0000-0000-0000-000000000015', 'First15', NULL, 'Last15', 15, 15),
    ('00000000-0000-0000-0000-000000000016', 'First16', NULL, 'Last16', 16, 16),
    ('00000000-0000-0000-0000-000000000017', 'First17', NULL, 'Last17', 17, 17),
    ('00000000-0000-0000-0000-000000000018', 'First18', NULL, 'Last18', 18, 18),
    ('00000000-0000-0000-0000-000000000019', 'First19', NULL, 'Last19', 19, 19),
    ('00000000-0000-0000-0000-000000000020', 'First20', NULL, 'Last20', 20, 20);
ON CONFLICT DO NOTHING;

-- Insert customer emails
INSERT INTO customer_email (customer_id, email)
VALUES
    ('00000000-0000-0000-0000-000000000001', 'first1@example.com'),
    ('00000000-0000-0000-0000-000000000002', 'first2@example.com'),
    ('00000000-0000-0000-0000-000000000003', 'first3@example.com'),
    ('00000000-0000-0000-0000-000000000004', 'first4@example.com'),
    ('00000000-0000-0000-0000-000000000005', 'first5@example.com'),
    ('00000000-0000-0000-0000-000000000006', 'first6@example.com'),
    ('00000000-0000-0000-0000-000000000007', 'first7@example.com'),
    ('00000000-0000-0000-0000-000000000008', 'first8@example.com'),
    ('00000000-0000-0000-0000-000000000009', 'first9@example.com'),
    ('00000000-0000-0000-0000-000000000010', 'first10@example.com'),
    ('00000000-0000-0000-0000-000000000011', 'first11@example.com'),
    ('00000000-0000-0000-0000-000000000012', 'first12@example.com'),
    ('00000000-0000-0000-0000-000000000013', 'first13@example.com'),
    ('00000000-0000-0000-0000-000000000014', 'first14@example.com'),
    ('00000000-0000-0000-0000-000000000015', 'first15@example.com'),
    ('00000000-0000-0000-0000-000000000016', 'first16@example.com'),
    ('00000000-0000-0000-0000-000000000017', 'first17@example.com'),
    ('00000000-0000-0000-0000-000000000018', 'first18@example.com'),
    ('00000000-0000-0000-0000-000000000019', 'first19@example.com'),
    ('00000000-0000-0000-0000-000000000020', 'first20@example.com');
ON CONFLICT DO NOTHING;

-- Insert phone numbers
INSERT INTO customer_phone_number (customer_id, type, number)
VALUES
    ('00000000-0000-0000-0000-000000000001', 'mobile', '+15550000001'),
    ('00000000-0000-0000-0000-000000000002', 'mobile', '+15550000002'),
    ('00000000-0000-0000-0000-000000000003', 'mobile', '+15550000003'),
    ('00000000-0000-0000-0000-000000000004', 'mobile', '+15550000004'),
    ('00000000-0000-0000-0000-000000000005', 'mobile', '+15550000005'),
    ('00000000-0000-0000-0000-000000000006', 'mobile', '+15550000006'),
    ('00000000-0000-0000-0000-000000000007', 'mobile', '+15550000007'),
    ('00000000-0000-0000-0000-000000000008', 'mobile', '+15550000008'),
    ('00000000-0000-0000-0000-000000000009', 'mobile', '+15550000009'),
    ('00000000-0000-0000-0000-000000000010', 'mobile', '+15550000010'),
    ('00000000-0000-0000-0000-000000000011', 'mobile', '+15550000011'),
    ('00000000-0000-0000-0000-000000000012', 'mobile', '+15550000012'),
    ('00000000-0000-0000-0000-000000000013', 'mobile', '+15550000013'),
    ('00000000-0000-0000-0000-000000000014', 'mobile', '+15550000014'),
    ('00000000-0000-0000-0000-000000000015', 'mobile', '+15550000015'),
    ('00000000-0000-0000-0000-000000000016', 'mobile', '+15550000016'),
    ('00000000-0000-0000-0000-000000000017', 'mobile', '+15550000017'),
    ('00000000-0000-0000-0000-000000000018', 'mobile', '+15550000018'),
    ('00000000-0000-0000-0000-000000000019', 'mobile', '+15550000019'),
    ('00000000-0000-0000-0000-000000000020', 'mobile', '+15550000020');
ON CONFLICT DO NOTHING;

-- Smoke test
SELECT COUNT(*) AS customer_count FROM customer;

COMMIT;
