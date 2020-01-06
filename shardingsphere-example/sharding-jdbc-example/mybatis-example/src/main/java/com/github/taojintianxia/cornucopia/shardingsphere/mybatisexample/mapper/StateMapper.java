package com.github.taojintianxia.cornucopia.shardingsphere.mybatisexample.mapper;

import com.github.taojintianxia.cornucopia.shardingsphere.mybatisexample.entity.State;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Nianjun Sun
 * @date 2020/1/6 12:31
 */
@Mapper
public interface StateMapper {

    /**
     * find by state
     *
     * @param state
     * @return
     */
    @Select("SELECT * FROM CITY WHERE state = #{state}")
    State findByState(@Param("state") String state);
}