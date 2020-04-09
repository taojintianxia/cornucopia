package com.github.taojintianxia.cornucopia.shardingsphere.common.enums;

/**
 * @author Nianjun Sun
 * @date 2019/9/19 17:07
 */
public enum ShardingType {
    /**
     * sharding database
     */
    SHARDING_DATABASES,

    /**
     * sharding tables
     */
    SHARDING_TABLES,

    /**
     * sharding database and tables
     */
    SHARDING_DATABASES_AND_TABLES,

    /**
     * master slave
     */
    MASTER_SLAVE,

    /**
     * sharding master slave
     */
    SHARDING_MASTER_SLAVE,

    /**
     * encrypt
     */
    ENCRYPT;
}
