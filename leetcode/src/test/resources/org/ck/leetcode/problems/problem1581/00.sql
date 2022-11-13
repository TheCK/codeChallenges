USE test;

CREATE TABLE Visits
(
    visit_id    INT,
    customer_id INT
);

CREATE TABLE Transactions
(
    transaction_id INT,
    visit_id       INT,
    amount         INT
);

INSERT INTO Visits
VALUES (1, 23);
INSERT INTO Visits
VALUES (2, 9);
INSERT INTO Visits
VALUES (4, 30);
INSERT INTO Visits
VALUES (5, 54);
INSERT INTO Visits
VALUES (6, 96);
INSERT INTO Visits
VALUES (7, 54);
INSERT INTO Visits
VALUES (8, 54);

INSERT INTO Transactions
VALUES (2, 5, 310);
INSERT INTO Transactions
VALUES (3, 5, 300);
INSERT INTO Transactions
VALUES (9, 5, 200);
INSERT INTO Transactions
VALUES (12, 1, 910);
INSERT INTO Transactions
VALUES (13, 2, 970);