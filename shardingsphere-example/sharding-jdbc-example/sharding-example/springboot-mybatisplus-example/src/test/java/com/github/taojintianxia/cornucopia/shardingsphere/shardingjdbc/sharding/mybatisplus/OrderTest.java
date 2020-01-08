package com.github.taojintianxia.cornucopia.shardingsphere.shardingjdbc.sharding.mybatisplus;

import com.github.taojintianxia.cornucopia.shardingsphere.shardingcommon.entity.Order;
import com.github.taojintianxia.cornucopia.shardingsphere.shardingjdbc.sharding.mybatisplus.repository.MybatisOrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Nianjun Sun
 * @date 2020/1/7 14:23
 */
@SpringBootTest()
@RunWith(SpringRunner.class)
public class OrderTest {

    @Resource
    private MybatisOrderRepository mybatisOrderRepository;

    @Test
    public void testSelect() throws SQLException {
        System.out.println(("----- selectAll method test ------"));
        mybatisOrderRepository.createTableIfNotExists();
        List<Order> stateList = mybatisOrderRepository.selectList(null);
        //        Assert.assertEquals(4, stateList.size());
//        stateList.forEach(System.out::println);
    }
}
