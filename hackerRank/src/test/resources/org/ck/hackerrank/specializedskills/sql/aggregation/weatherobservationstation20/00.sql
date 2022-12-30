USE test;

CREATE TABLE station (
  id     INT,
  city   VARCHAR(21),
  state  VARCHAR(2),
  lat_n  DOUBLE,
  long_w DOUBLE
);

INSERT INTO station VALUES (1, 'Station 1', 'NY', 40.123456, 17.66);
INSERT INTO station VALUES (2, 'Station 2', 'NY', 17.03, 22.91);
INSERT INTO station VALUES (3, 'Station 3', 'NY', 140.03, 22.90);
INSERT INTO station VALUES (4, 'Station 4', 'NY', 40.123467, 17.65);
