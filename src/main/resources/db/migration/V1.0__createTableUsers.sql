CREATE TABLE users
  (
     id         SERIAL PRIMARY KEY,
     user_name   VARCHAR(100) UNIQUE NOT NULL,
     password   VARCHAR (100),
     email      VARCHAR (250) UNIQUE NOT NULL
  );