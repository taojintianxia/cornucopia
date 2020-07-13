package com.github.taojintianxia.junitexample.assumptions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

/**
 * @author Nianjun Sun
 * @date 2019/9/19 11:35
 */
public class AssumptionsAllTestExample {

    // all of other test case will not be executed
    @Before
    public void setUp() {
        assumeTrue(false);
    }

    @Test
    public void testA() {
        assertEquals("object is not same", "A", "A");
    }

    @Test
    public void testB() {
        assertEquals("object is not same", "B", "B");
    }

    @Test
    public void testC() {
        assertEquals("object is not same", "C", "C");
    }
}
