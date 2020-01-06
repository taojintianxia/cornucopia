package com.github.taojintianxia.cornucopia.database.h2example;

import com.github.taojintianxia.cornucopia.database.h2example.entity.State;
import com.github.taojintianxia.cornucopia.database.h2example.mapper.StateMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Nianjun Sun
 * @date 2020/1/6 18:03
 */
@SpringBootTest()
@RunWith(SpringRunner.class)
public class StateTest {

    @Resource
    private StateMapper stateMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<State> stateList = stateMapper.selectList(null);
        Assert.assertEquals(4, stateList.size());
        stateList.forEach(System.out::println);
    }
}
