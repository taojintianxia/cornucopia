DROP SCHEMA IF EXISTS date_range;

CREATE TABLE `t_address` (
  `address_id` bigint(20) NOT NULL,
  `address_name` varchar(100) NOT NULL,
  `create_time` bigint(20) unsigned DEFAULT '0',
  `update_time` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

CREATE TABLE `t_order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) unsigned DEFAULT '0',
  `update_time` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

CREATE TABLE `t_order_item` (
  `order_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL,
  `user_id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) unsigned DEFAULT '0',
  `update_time` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

