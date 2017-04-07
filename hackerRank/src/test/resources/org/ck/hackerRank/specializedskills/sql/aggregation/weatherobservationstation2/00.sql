USE test;

CREATE TABLE station (
  id     INT,
  city   VARCHAR(21),
  state  VARCHAR(2),
  lat_n  DOUBLE,
  long_w DOUBLE
);

INSERT INTO station VALUES (1, 'Station 1', 'NY', 15.87, 17.65);
INSERT INTO station VALUES (2, 'Station 2', 'NY', 17.03, 22.90);
