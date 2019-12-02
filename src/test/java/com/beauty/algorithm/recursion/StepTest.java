package com.beauty.algorithm.recursion;

import org.junit.Test;

import javax.print.StreamPrintService;

import static org.junit.Assert.*;

public class StepTest {

    @Test
    public void move() {
        Step step = new Step();
        assertEquals(3, step.move(3));
        assertEquals(5, step.move(4));
        assertEquals(8, step.move(5));
    }

    public void simpleMove() {
        Step step = new Step();
        assertEquals(3, step.simpleMove(3));
        assertEquals(5, step.simpleMove(4));
        assertEquals(8, step.simpleMove(5));
    }

}