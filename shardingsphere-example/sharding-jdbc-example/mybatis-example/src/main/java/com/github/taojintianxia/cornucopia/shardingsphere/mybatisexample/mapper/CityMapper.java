package com.github.taojintianxia.cornucopia.shardingsphere.mybatisexample.mapper;

import com.github.taojintianxia.cornucopia.shardingsphere.mybatisexample.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Nianjun Sun
 * @date 2020/1/6 12:31
 */
@Mapper
public interface CityMapper {

    /**
     * find by state
     *
     * @param state
     * @return
     */
    @Select("SELECT * FROM CITY WHERE state = #{state}")
    City findByState(@Param("state") String state);
}