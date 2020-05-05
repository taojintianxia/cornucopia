package com.github.taojintianxia.consensus.ratis.mysqlreplicated.util;

import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.Map;

/**
 * @author Nianjun Sun
 * @date 2020/5/5 12:42
 */
public class JVMParamUtil {

    public static String getParamFromJVM(String key) {
        return ManagementFactory.getRuntimeMXBean().getSystemProperties().get(key);
    }
}
