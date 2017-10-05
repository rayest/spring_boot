-- 如果实体类有注解及相应的配置，则不需要手动创建数据库表
CREATE TABLE IF NOT EXISTS h2_user (
  id       INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(100),
  name     VARCHAR(100),
  age      SMALLINT,
  balance  DOUBLE
);