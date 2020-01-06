DROP TABLE IF EXISTS city;

create table `city`(
    `id`          INTEGER PRIMARY KEY,
    `state`       VARCHAR(10) NOT NULL,
    `name`      VARCHAR(30) NOT NULL
);