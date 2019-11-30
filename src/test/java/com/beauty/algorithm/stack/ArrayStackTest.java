package com.beauty.algorithm.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ArrayStackTest {

    private Stack<String> stack;

    @Before
    public void initialize() {
        stack = new ArrayStack<>(3);
        stack.push("A");
        stack.push("B");
    }

    @Test
    public void push() {
        assertTrue(stack.push("C"));
        assertFalse(stack.push("D"));
    }

    @Test
    public void pop() {
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
        assertNull(stack.pop());
    }

}