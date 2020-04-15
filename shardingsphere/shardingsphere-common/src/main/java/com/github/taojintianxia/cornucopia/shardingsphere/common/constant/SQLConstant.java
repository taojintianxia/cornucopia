package com.github.taojintianxia.cornucopia.shardingsphere.common.constant;

/**
 * @author Nianjun Sun
 * @date 2020/4/14 09:14
 */
public interface SQLConstant {

    String DROP_SCHEMA = "DROP SCHEMA IF EXISTS demo_ds";

    String CREATE_SCHEMA = "CREATE SCHEMA IF NOT EXISTS demo_ds";

    String CREATE_TABLE_ORDER = "CREATE TABLE IF NOT EXISTS demo_ds.t_order (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id))";

    String CREATE_TABLE_ORDER_ITEM = "CREATE TABLE IF NOT EXISTS demo_ds.t_order_item (order_item_id BIGINT NOT NULL AUTO_INCREMENT, order_id BIGINT NOT NULL, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_item_id))";

    String INSERT_TABLE_ORDER = "INSERT INTO demo_ds.t_order VALUES(1002, 10, 'init')";

    String INSERT_TABLE_ORDER_ITEM_1 = "INSERT INTO demo_ds.t_order_item VALUES(10000, 1000, 11, 'init')";

    String INSERT_TABLE_ORDER_ITEM_2 = "INSERT INTO demo_ds.t_order_item VALUES(10001, 1000, 11, 'init')";

    String INSERT_TABLE_ORDER_ITEM_3 = "INSERT INTO demo_ds.t_order_item VALUES(10002, 1001, 12, 'init')";

    String INSERT_TABLE_ORDER_ITEM_4 = "INSERT INTO demo_ds.t_order_item VALUES(10003, 1002, 13, 'init')";

}
