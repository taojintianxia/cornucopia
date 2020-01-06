DROP TABLE IF EXISTS state;

create table `state`(
    `id`          INTEGER PRIMARY KEY,
    `state`       VARCHAR(10) NOT NULL,
    `name`      VARCHAR(30) NOT NULL
);