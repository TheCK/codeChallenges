USE test;

CREATE TABLE students (
  id    INT,
  name  TEXT,
  marks INT
);

CREATE TABLE grades (
  grade    INT,
  min_mark INT,
  max_mark INT
);

INSERT INTO students VALUES (1, 'Julia', 88);
INSERT INTO students VALUES (2, 'Samantha', 68);
INSERT INTO students VALUES (3, 'Maria', 99);
INSERT INTO students VALUES (4, 'Scarlet', 78);
INSERT INTO students VALUES (5, 'Ashley', 63);
INSERT INTO students VALUES (6, 'Jane', 81);

INSERT INTO grades VALUE (1, 0, 9);
INSERT INTO grades VALUE (2, 10, 19);
INSERT INTO grades VALUE (3, 20, 29);
INSERT INTO grades VALUE (4, 30, 39);
INSERT INTO grades VALUE (5, 40, 49);
INSERT INTO grades VALUE (6, 50, 59);
INSERT INTO grades VALUE (7, 60, 69);
INSERT INTO grades VALUE (8, 70, 79);
INSERT INTO grades VALUE (9, 80, 89);
INSERT INTO grades VALUE (10, 90, 100);
