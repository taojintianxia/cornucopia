package com.github.taojintianxia.conuporpia.shardingsphere.shardingcore.rawjdbc.shardingtable;

import groovy.util.logging.Slf4j;

/**
 * @author Nianjun Sun
 * @date 2020/4/10 22:24
 */
@Slf4j
public class ShardingTableDemo {

    private static final String SQL = "SELECT i.* FROM t_order o JOIN t_order_item i ON o.order_id=i.order_id WHERE o.user_id=? AND o.order_id=?";

    public static void main(String...args){

    }

}
