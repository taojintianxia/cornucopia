package com.github.taojintianxia.cornucopia.databasebenchmark.script;

import com.github.taojintianxia.cornucopia.databasebenchmark.script.inernal.PointSelect;

import java.util.HashMap;
import java.util.Map;

public class ScriptHolder {

    private final static ScriptHolder INSTANCE = new ScriptHolder();

    private final static Map<String, BenchmarkScript> SCRIPT_MAP = new HashMap<>();

    private ScriptHolder() {
        SCRIPT_MAP.put("oltp_point_select", new PointSelect());
    }

    public static ScriptHolder getInstance() {
        return INSTANCE;
    }

    public BenchmarkScript getByCommand(String command){
        return SCRIPT_MAP.get(command);
    }
}
