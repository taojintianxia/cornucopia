package com.github.taojintianxia.jdbcexample.service;

/**
 * @author Nianjun Sun
 * @date 2019/9/20 10:40
 */
public interface CRUDTemplate<T> {

    /**
     * save
     *
     * @param t
     * @return
     */
    long insert(T t);

    /**
     * update
     *
     * @param t
     * @return
     */
    int update(T t);

    /**
     * delete by id
     *
     * @param id
     * @return
     */
    int deleteById(long id);

    /**
     * select by id
     *
     * @param id
     * @return
     */
    T selectById(long id);
}
