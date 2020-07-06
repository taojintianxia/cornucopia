package com.github.taojintianxia.cornucopia.database.mybatis.util;

import com.github.taojintianxia.cornucopia.database.mybatis.model.Order;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Nianjun Sun
 * @date 2020/7/6 10:57
 */
public class DataUtil {
    
    private static final Random RANDOM = new Random();
    
    private static final List<String> ORDER_STATUS = Lists.newArrayList("init", "run", "finished");
    
    public static Order generateOrder() {
        Order order = new Order();
        order.setUserId(Math.abs(RANDOM.nextInt()));
        order.setStatus(ORDER_STATUS.get(RANDOM.nextInt(3)));
        return order;
    }
    
    public static List<Order> generateOrderList() {
        return generateOrderList(100);
    }
    
    public static List<Order> generateOrderList(int count) {
        List<Order> orderList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            orderList.add(generateOrder());
        }
        return orderList;
    }
}
