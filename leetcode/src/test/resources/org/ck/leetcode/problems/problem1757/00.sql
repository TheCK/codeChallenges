USE test;

CREATE TABLE Products
(
    product_id INT,
    low_fats   ENUM ('Y', 'N'),
    recyclable ENUM ('Y', 'N')
);

INSERT INTO Products
VALUES (0, 'Y', 'N');
INSERT INTO Products
VALUES (1, 'Y', 'Y');
INSERT INTO Products
VALUES (2, 'N', 'Y');
INSERT INTO Products
VALUES (3, 'Y', 'Y');
INSERT INTO Products
VALUES (4, 'N', 'N');
