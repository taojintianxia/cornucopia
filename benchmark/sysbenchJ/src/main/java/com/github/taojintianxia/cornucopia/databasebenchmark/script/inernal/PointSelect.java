package com.github.taojintianxia.cornucopia.databasebenchmark.script.inernal;

import com.github.taojintianxia.cornucopia.databasebenchmark.script.Script;

public class PointSelect implements Script {

    @Override
    public String getName() {
        return "point_select";
    }

    @Override
    public String getScriptContent() {
        return "SELECT c FROM sbtest%d WHERE id=?";
    }
}
