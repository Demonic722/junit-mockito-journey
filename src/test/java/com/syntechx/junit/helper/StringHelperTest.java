package com.syntechx.junit.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringHelperTest {

    StringHelper helper = new StringHelper();

    @Test
    public void testTruncateAInFirst2Positions_AInFirst2Positions() {
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    }

    @Test
    public void testTruncateAInFirst2Positions2_AInFirstPosition() {
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }
    
    @Test
    public void testTruncateAInFirst2Positions_NoAInAnyPosition() {
        assertEquals("CDEF", helper.truncateAInFirst2Positions("CDEF"));
    }

    @Test
    public void testTruncateAInFirst2Positions_AInLast2Positions() {
        assertEquals("CDAA", helper.truncateAInFirst2Positions("CDAA"));
    }
}
