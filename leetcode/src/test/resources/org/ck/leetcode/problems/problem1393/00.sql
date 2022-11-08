USE test;

CREATE TABLE Stocks
(
    stock_name    VARCHAR(25),
    operation     ENUM ('Buy', 'Sell'),
    operation_day INT,
    price         INT
);

INSERT INTO Stocks
VALUES ('Leetcode', 'Buy', 1, 1000);
INSERT INTO Stocks
VALUES ('Corona Masks', 'Buy', 2, 10);
INSERT INTO Stocks
VALUES ('Leetcode', 'Sell', 5, 9000);
INSERT INTO Stocks
VALUES ('Handbags', 'Buy', 17, 30000);
INSERT INTO Stocks
VALUES ('Corona Masks', 'Sell', 3, 1010);
INSERT INTO Stocks
VALUES ('Corona Masks', 'Buy', 4, 1000);
INSERT INTO Stocks
VALUES ('Corona Masks', 'Sell', 5, 500);
INSERT INTO Stocks
VALUES ('Corona Masks', 'Buy', 6, 1000);
INSERT INTO Stocks
VALUES ('Handbags', 'Sell', 29, 7000);
INSERT INTO Stocks
VALUES ('Corona Masks', 'Sell', 10, 10000);