package com.syntechx.junit.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringHelperTest {
    
    @Test
    public void test() {
        StringHelper helper = new StringHelper();
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }
}
