package com.github.taojintianxia.cornucopia.databasebenchmark.enums;

import lombok.Getter;

@Getter
public enum BenchmarkScriptNameEnum {

    POINT_SELECT("point_select");

    private BenchmarkScriptNameEnum( String name ) {
        this.name = name;
    }

    private String name;
}
