drop table if exists users;

CREATE TABLE users
(
    user_id SERIAL PRIMARY KEY,
    login varchar(64),
    email varchar(128),
    phone varchar(64),
    username varchar(64),
    birthday date,
    city varchar(64)
);