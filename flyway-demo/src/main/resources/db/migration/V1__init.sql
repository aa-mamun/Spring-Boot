CREATE TABLE users (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  username varchar(100) NOT NULL,
  name varchar(50) NOT NULL,
  address varchar(50) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_username (username)
)