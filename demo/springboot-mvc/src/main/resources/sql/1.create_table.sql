CREATE DATABASE IF NOT EXISTS sphereex_poc;

DROP TABLE IF EXISTS t_order;
CREATE TABLE t_order (order_id INT NOT NULL, user_id INT NOT NULL, status VARCHAR(45) NULL, PRIMARY KEY (order_id));
