package com.github.taojintianxia.cornucopia.database.mybatis.mapper;


import com.github.taojintianxia.cornucopia.database.mybatis.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Nianjun Sun
 * @date 2020/3/12 12:52
 */
public interface OrderMapper {
    
    List<Order> listAll();
    
    List<Order> listByUserIds(List<Integer> userIdList);
    
    int insert(Order order);
    
    int batchInsert(@Param("orderList") List<Order> orderList);
}