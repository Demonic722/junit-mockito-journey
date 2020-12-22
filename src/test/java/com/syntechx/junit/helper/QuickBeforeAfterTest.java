package com.syntechx.junit.helper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickBeforeAfterTest {

    @BeforeClass
    public static void setupBeforeClass() {
        System.out.println("Before class");
    }

    @Before
    public void setup() {
        System.out.println("Before test");
    }

    @Test
    public void test1() {
        System.out.println("test1 executed");
    }

    @Test
    public void test2() {
        System.out.println("test2 executed");
    }

    @After
    public void teardown() {
        System.out.println("After test");
    }

    @AfterClass
    public static void teardownAfterClass() {
        System.out.println("After class");
    }
}
