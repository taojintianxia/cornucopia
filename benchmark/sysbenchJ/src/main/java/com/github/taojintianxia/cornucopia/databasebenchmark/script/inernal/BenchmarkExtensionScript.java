package com.github.taojintianxia.cornucopia.databasebenchmark.script.inernal;

import com.github.taojintianxia.cornucopia.databasebenchmark.script.BenchmarkScript;

public class BenchmarkExtensionScript implements BenchmarkScript {

    public String getPrepareScript() {
        return "insert into sbtest%s values ( %s )";
    }

    public String getPrepareInsertScript() {
        return "insert into sbtest%s values (?,?,?,?)";
    }

    public static String getCleanScript() {
        return "drop table sbtest%s";
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
