USE test;

CREATE TABLE DailySales
(
    date_id    DATE,
    make_name  VARCHAR(25),
    lead_id    INT,
    partner_id INT
);

INSERT INTO DailySales
VALUES ('2020-12-8', 'toyota', 0, 1),
       ('2020-12-8', 'toyota', 1, 0),
       ('2020-12-8', 'toyota', 1, 2),
       ('2020-12-7', 'toyota', 0, 2),
       ('2020-12-7', 'toyota', 0, 1),
       ('2020-12-8', 'honda', 1, 2),
       ('2020-12-8', 'honda', 2, 1),
       ('2020-12-7', 'honda', 0, 1),
       ('2020-12-7', 'honda', 1, 2),
       ('2020-12-7', 'honda', 2, 1);