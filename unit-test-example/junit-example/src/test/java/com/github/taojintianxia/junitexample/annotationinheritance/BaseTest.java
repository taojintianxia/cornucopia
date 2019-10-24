package com.github.taojintianxia.junitexample.annotationinheritance;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Nianjun Sun
 * @date 2019/10/24 16:03
 */
public class BaseTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Parent Before Class");
    }

    @Before
    public void before() {
        System.out.println("Parent Before");
    }

    @After
    public void after() {
        System.out.println("Parent After");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Parent After Class");
    }

    @Test
    public void test() {

    }
}
