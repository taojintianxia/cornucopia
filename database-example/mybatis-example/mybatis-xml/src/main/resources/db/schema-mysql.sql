CREATE SCHEMA if not exists demo_ds;

USE demo_ds;

DROP TABLE IF EXISTS demo_ds.t_order;

CREATE TABLE demo_ds.t_order (
                                   `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                   `user_id` int(11) NOT NULL,
                                   `status` varchar(45) DEFAULT NULL,
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8;