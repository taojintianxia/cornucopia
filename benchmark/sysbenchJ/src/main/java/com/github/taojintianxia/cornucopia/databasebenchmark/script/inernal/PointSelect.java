package com.github.taojintianxia.cornucopia.databasebenchmark.script.inernal;

import com.github.taojintianxia.cornucopia.databasebenchmark.script.BenchmarkScript;

public class PointSelect implements BenchmarkScript {

    public String getName() {
        return "point_select";
    }


    public String getScriptContent() {
        return "SELECT c FROM sbtest%s WHERE id=?";
    }
}
