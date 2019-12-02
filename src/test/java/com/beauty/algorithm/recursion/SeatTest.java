package com.beauty.algorithm.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class SeatTest {

    @Test(expected = RuntimeException.class)
    public void find() {
        Seat seat = new Seat();
        seat.find(51);
    }

    @Test
    public void simpleFind() {
        Seat seat = new Seat();
        assertEquals(3, seat.simpleFind(3));
    }

}