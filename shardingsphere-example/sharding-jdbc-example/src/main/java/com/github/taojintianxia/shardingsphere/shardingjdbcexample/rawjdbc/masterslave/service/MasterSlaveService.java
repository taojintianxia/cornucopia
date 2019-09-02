package com.github.taojintianxia.shardingsphere.shardingjdbcexample.rawjdbc.masterslave.service;

/**
 * @author Nianjun Sun
 * @date 2019/9/2 10:31
 */
public interface MasterSlaveService<T> {

    /**
     * save
     *
     * @param t
     */
    void save(T t);

    /**
     * get by id
     *
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * delete by id
     *
     * @param id
     */
    void deleteById(Long id);

    /**
     * update
     *
     * @param t
     */
    void update(T t);
}
