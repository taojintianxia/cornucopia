package com.github.taojintianxia.cornucopia.guava.common.base;

import com.google.common.base.Splitter;

public class SplitterExample {
    
    public static void main(String[] args) {
        String str = "a";
        System.out.println( Splitter.on( "," ).split( str ) );
    }
}
