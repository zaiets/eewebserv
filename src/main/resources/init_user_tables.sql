CREATE TABLE IF NOT EXISTS users (
  id         INT AUTO_INCREMENT PRIMARY KEY,
  login      VARCHAR(128) NOT NULL,
  surname    VARCHAR(128),
  name       VARCHAR(128),
  patronymic VARCHAR(128),
  password   VARCHAR(256) NOT NULL,
  UNIQUE (login)
);

CREATE TABLE IF NOT EXISTS user_roles (
  id      INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT          NOT NULL,
  role    VARCHAR(128) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
  UNIQUE (user_id)
);


