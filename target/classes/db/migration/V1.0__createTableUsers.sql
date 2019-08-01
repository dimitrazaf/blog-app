CREATE TABLE users
  (
     id         INT NOT NULL,
     username   VARCHAR(100) UNIQUE NOT NULL,
     password   VARCHAR (100),
     email      VARCHAR (250),
     PRIMARY KEY (id)
  );