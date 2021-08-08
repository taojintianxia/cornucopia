package com.github.taojintianxia.cornucopia.databasebenchmark.script.inernal;

import com.github.taojintianxia.cornucopia.databasebenchmark.script.BenchmarkScript;

public class BenchmarkExtensionScript implements BenchmarkScript {

    String getPrepareScript() {
        return "insert into sbtest%d values ( %s )";
    }

    String getCleanScript() {
        return "drop table sbtest%d";
    }

    @Override
    public String getName() {
        return "extension_script";
    }

    @Override
    public String getScriptContent() {
        return null;
    }
}
