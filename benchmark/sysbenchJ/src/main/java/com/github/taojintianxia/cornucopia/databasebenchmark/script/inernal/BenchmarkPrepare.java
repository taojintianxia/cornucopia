package com.github.taojintianxia.cornucopia.databasebenchmark.script.inernal;

import com.github.taojintianxia.cornucopia.databasebenchmark.script.BenchmarkScript;

public class BenchmarkPrepare implements BenchmarkScript {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getScriptContent() {
        return "CREATE TABLE `sbtest%s` (\n" +
               "  `id` int NOT NULL,\n" +
               "  `k` int NOT NULL DEFAULT '0',\n" +
               "  `c` char(120) NOT NULL DEFAULT '',\n" +
               "  `pad` char(60) NOT NULL DEFAULT '',\n" +
               "  PRIMARY KEY (`id`),\n" +
               "  KEY `k_1` (`k`)\n" +
               ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4";
    }
}
