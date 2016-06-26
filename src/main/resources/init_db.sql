CREATE TABLE IF NOT EXISTS user_profile (
  id   INT AUTO_INCREMENT PRIMARY KEY,
  role ENUM('ADMIN', 'USER') DEFAULT 'USER' NOT NULL
);

CREATE TABLE IF NOT EXISTS persistent_logins (
  series    VARCHAR(256) PRIMARY KEY NOT NULL,
  login     VARCHAR(128)     NOT NULL,
  token     TEXT,
  last_used TIMESTAMP
);

CREATE TABLE IF NOT EXISTS users (
  id              INT AUTO_INCREMENT PRIMARY KEY,
  login           VARCHAR(128) NOT NULL,
  email           VARCHAR(128) NOT NULL,
  second_name     VARCHAR(128),
  first_name      VARCHAR(128),
  patronymic      VARCHAR(128),
  password        VARCHAR(256) NOT NULL,
  user_profile_id INT          NOT NULL,
  FOREIGN KEY (user_profile_id) REFERENCES user_profile (id),
  UNIQUE (login),
  UNIQUE (email)
);