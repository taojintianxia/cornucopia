DROP SCHEMA IF EXISTS date_range_0;
DROP SCHEMA IF EXISTS date_range_1;
CREATE SCHEMA date_range_0;
CREATE SCHEMA date_range_1;
use date_range_0;

CREATE TABLE `t_address_2020` (
  `address_id` bigint(20) NOT NULL,
  `address_name` varchar(100) NOT NULL,
  `create_time` bigint(20) unsigned DEFAULT '0',
  `update_time` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `t_order_202001` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) unsigned DEFAULT '0',
  `update_time` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `t_order_202002` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) unsigned DEFAULT '0',
  `update_time` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `t_order_202003` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) unsigned DEFAULT '0',
  `update_time` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `t_order_202004` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) unsigned DEFAULT '0',
  `update_time` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `t_order_202005` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) unsigned DEFAULT '0',
  `update_time` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `t_order_202006` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) unsigned DEFAULT '0',
  `update_time` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `t_order_202007` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) unsigned DEFAULT '0',
  `update_time` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `t_order_202008` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) unsigned DEFAULT '0',
  `update_time` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `t_order_202009` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) unsigned DEFAULT '0',
  `update_time` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `t_order_202010` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) unsigned DEFAULT '0',
  `update_time` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `t_order_202011` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) unsigned DEFAULT '0',
  `update_time` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `t_order_202012` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) unsigned DEFAULT '0',
  `update_time` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `t_order_item_20200812` (
  `order_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL,
  `user_id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) unsigned DEFAULT '0',
  `update_time` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `t_order_item_20200813` (
  `order_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL,
  `user_id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) unsigned DEFAULT '0',
  `update_time` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

