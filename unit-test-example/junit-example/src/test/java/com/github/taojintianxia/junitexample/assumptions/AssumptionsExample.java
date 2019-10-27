package com.github.taojintianxia.junitexample.assumptions;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;

/**
 * @author Nianjun Sun
 * @date 2019/9/19 11:23
 */
public class AssumptionsExample {

    @Test
    public void filenameIncludesUsername() {
        assumeThat(File.separatorChar, is('/'));
        assertEquals("object is not same", "A", "A");
    }

    @Test
    public void correctBehaviorWhenFilenameIsNull() {
        assumeTrue(bugFixed("13356"));  // bugFixed is not included in JUnit
        assertEquals("object is not same", "x", "y");
    }

    private boolean bugFixed(String bugNum) {
        switch (bugNum) {
            case "13356":
                return false;
        }
        return false;
    }
}
