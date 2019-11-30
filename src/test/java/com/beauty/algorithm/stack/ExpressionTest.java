package com.beauty.algorithm.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionTest {

    @Test
    public void calculate() {
        assertEquals(3, new Expression().calculate("1+2"));
        assertEquals(37, new Expression().calculate("3+5*8-6"));
        assertEquals(43, new Expression().calculate("3+5*8"));
        assertEquals(43, new Expression().calculate("5*8+3"));
        assertEquals(6, new Expression().calculate("3+6/2"));
    }

}