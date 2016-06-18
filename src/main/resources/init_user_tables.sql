CREATE SCHEMA IF NOT EXISTS tournament_tae;

CREATE TABLE IF NOT EXISTS users (
  id         INT                   AUTO_INCREMENT PRIMARY KEY,
  login      VARCHAR(128) NOT NULL,
  email      VARCHAR(128) NOT NULL,
  role       ENUM('ADMIN', 'USER') DEFAULT 'USER',
  surname    VARCHAR(128),
  name       VARCHAR(128),
  patronymic VARCHAR(128),
  password   VARCHAR(256) NOT NULL,
  UNIQUE (login),
  UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS user_tokens (
  id        INT AUTO_INCREMENT PRIMARY KEY,
  user_id   INT NOT NULL,
  last_used DATETIME,
  token     VARCHAR(256),
  FOREIGN KEY (user_id) REFERENCES users (id)
    ON DELETE CASCADE
);





