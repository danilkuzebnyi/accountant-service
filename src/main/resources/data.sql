INSERT INTO fee (name , amount)
VALUES ('Taxes', 50),
       ('Financial Analysis', 70),
       ('Budgeting for business needs', 80),
       ('Preparing you for an Audit', 65),
       ('Payroll', 55),
       ('Managing your receivables and payable ledger.', 70),
       ('Initial Ledger entries', 45),
       ('Management reports', 60),
       ('Maintaining your bank reconciliation', 50);

INSERT INTO transaction_type (name, commission)
VALUES ('ADDITION', 30),
       ('MULTIPLICATION', 1.2),
       ('THIRD_FEE_FREE', 0);

INSERT INTO transaction (transaction_type_id)
VALUES 1, 2, 2, 3, 3, 3;

INSERT INTO transaction_fee (transaction_id, fee_id)
VALUES (1, 1),
       (1, 4),
       (1, 7),
       (2, 1),
       (3, 2),
       (3, 3),
       (4, 1),
       (4, 4),
       (4, 8),
       (4, 9),
       (5, 5),
       (6, 7),
       (6, 8),
       (6, 9);