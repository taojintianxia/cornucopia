package com.github.taojintianxia.cornucopia.jdbctest.validation;

import com.github.taojintianxia.cornucopia.jdbctest.constants.SysbenchConstant;
import com.google.common.base.Strings;

public class SysbenchParamValidator {

    public static void validateSysbenchParam() {
        if (Strings.isNullOrEmpty(System.getProperty("conf"))) {
            throw new RuntimeException("\"-Dcon\" has not been set");
        }
        if (Strings.isNullOrEmpty(System.getProperty("time"))) {
            throw new RuntimeException("\"-Dtime\" has not been set");
        }
        if (Strings.isNullOrEmpty(System.getProperty("thread"))) {
            throw new RuntimeException("\"-Dthread\" has not been set");
        }
        if (Strings.isNullOrEmpty(System.getProperty("table-size"))) {
            throw new RuntimeException("\"-Dtable-size\" has not been set");
        }
        if (Strings.isNullOrEmpty(System.getProperty("script"))) {
            throw new RuntimeException("\"-Dscript\" has not been set");
        }

        SysbenchConstant.SYSBENCH_PARAM_MAP.put("conf", System.getProperty("conf"));
        SysbenchConstant.SYSBENCH_PARAM_MAP.put("time", System.getProperty("time"));
        SysbenchConstant.SYSBENCH_PARAM_MAP.put("thread", System.getProperty("thread"));
        SysbenchConstant.SYSBENCH_PARAM_MAP.put("script", System.getProperty("script"));
        SysbenchConstant.SYSBENCH_PARAM_MAP.put("table-size", System.getProperty("table-size"));
        SysbenchConstant.SYSBENCH_PARAM_MAP.put("transaction-mode", System.getProperty("transaction-mode"));
    }
}
