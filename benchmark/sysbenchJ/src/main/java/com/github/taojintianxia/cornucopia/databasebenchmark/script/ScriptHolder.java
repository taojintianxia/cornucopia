package com.github.taojintianxia.cornucopia.databasebenchmark.script;

import com.github.taojintianxia.cornucopia.databasebenchmark.script.inernal.PointSelect;

import java.util.HashMap;
import java.util.Map;

public class ScriptHolder {

    private final static ScriptHolder INSTANCE = new ScriptHolder();

    private final static Map<String, Script> SCRIPT_MAP = new HashMap<>();

    private ScriptHolder() {
        SCRIPT_MAP.put("point_select", new PointSelect());
    }

    public static ScriptHolder getInstance() {
        return INSTANCE;
    }

    public Script getByName(String scriptName){
        return SCRIPT_MAP.get(scriptName);
    }
}
