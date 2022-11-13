USE test;

CREATE TABLE Users
(
    account INT,
    name    VARCHAR(25)
);

CREATE TABLE Transactions
(
    trans_id      INT,
    account       INT,
    amount        INT,
    transacted_on DATE
);

INSERT INTO Users
VALUES (900001, 'Alice');
INSERT INTO Users
VALUES (900002, 'Bob');
INSERT INTO Users
VALUES (900003, 'Charlie');

INSERT INTO Transactions
VALUES (1, 900001, 7000, '2020-08-01');
INSERT INTO Transactions
VALUES (2, 900001, 7000, '2020-09-01');
INSERT INTO Transactions
VALUES (3, 900001, -3000, '2020-09-02');
INSERT INTO Transactions
VALUES (4, 900002, 1000, '2020-09-12');
INSERT INTO Transactions
VALUES (5, 900003, 6000, '2020-08-07');
INSERT INTO Transactions
VALUES (6, 900003, 6000, '2020-09-07');
INSERT INTO Transactions
VALUES (7, 900003, -4000, '2020-09-11');