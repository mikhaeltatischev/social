DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS news CASCADE;
DROP TABLE IF EXISTS photos CASCADE;
DROP TABLE IF EXISTS friendship_status CASCADE;

CREATE TABLE users
(
    user_id SERIAL PRIMARY KEY,
    login VARCHAR(64),
    email VARCHAR(128),
    phone VARCHAR(64),
    username VARCHAR(64),
    birthday DATE,
    city VARCHAR(64)
);

CREATE TABLE news
(
    news_id SERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES users(user_id),
    title VARCHAR(256),
    message VARCHAR(1024),
    time_of_creation TIMESTAMP
);

CREATE TABLE photos
(
    photo_id SERIAL PRIMARY KEY,
    news_id BIGINT REFERENCES news(news_id),
    url VARCHAR(512)
);

CREATE TABLE friendship_status
(
    status_id BIGINT PRIMARY KEY,
    status_name VARCHAR(128)
);