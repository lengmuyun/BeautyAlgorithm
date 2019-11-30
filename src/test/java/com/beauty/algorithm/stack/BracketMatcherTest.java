package com.beauty.algorithm.stack;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BracketMatcherTest {

    @Test
    public void match() {
        assertTrue(new BracketMatcher().match("{}"));
        assertTrue(new BracketMatcher().match("{[] ()[{}]}"));
        assertTrue(new BracketMatcher().match("[{()}([])]"));
        assertFalse(new BracketMatcher().match("{[}()]"));
        assertFalse(new BracketMatcher().match(" [({)]"));
    }

}