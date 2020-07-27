drop schema if exists test;
create schema test;
drop table IF EXISTS state;

create TABLE state
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	state_name VARCHAR(10) NULL DEFAULT NULL COMMENT 'state name',
	full_name VARCHAR(30) NULL DEFAULT NULL COMMENT 'full name',
	PRIMARY KEY (id)
);