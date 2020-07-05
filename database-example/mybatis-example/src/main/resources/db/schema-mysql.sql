CREATE SCHEMA if not exists demo_ds;

DROP TABLE IF EXISTS demo_ds.t_order;

create table demo_ds.t_order
(
    id      bigint      not null primary key,
    user_id int         not null,
    status  varchar(45) null
);