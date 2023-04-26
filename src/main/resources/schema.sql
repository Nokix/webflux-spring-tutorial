DROP TABLE IF EXISTS "USERS";

CREATE TABLE "USERS"
(
    id         BIGINT auto_increment PRIMARY KEY,
    first_name VARCHAR(255),
    last_name  VARCHAR(255)
);
