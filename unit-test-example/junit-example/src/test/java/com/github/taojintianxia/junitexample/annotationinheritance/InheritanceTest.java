package com.github.taojintianxia.junitexample.annotationinheritance;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Nianjun Sun
 * @date 2019/10/24 16:07
 */
public class InheritanceTest extends BaseTest {

    @BeforeClass
    public static void childBeforeClass() {
        System.out.println("child before class");
    }

    @Before
    public void childBefore() {
        System.out.println("child before");
    }

    @After
    public void childAfter() {
        System.out.println("child after");
    }

    @AfterClass
    public static void childAfterClass() {
        System.out.println("child after class");
    }

    @Test
    public void test() {
    }
}
