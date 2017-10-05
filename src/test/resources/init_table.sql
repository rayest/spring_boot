CREATE TABLE IF NOT EXISTS users (
  id       INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(100),
  name     VARCHAR(100),
  age      SMALLINT,
  balance  DOUBLE
);