package com.github.taojintianxia.cornucopia.database.mybatisplus;

import com.github.taojintianxia.cornucopia.database.mybatisplus.entity.User;
import com.github.taojintianxia.cornucopia.database.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

/**
 * @author Nianjun Sun
 * @date 2020/1/7 17:40
 */
@SpringBootTest
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectAll();
        assertThat(5).isEqualTo(userList.size());
        userList.forEach(System.out::println);
    }
}
