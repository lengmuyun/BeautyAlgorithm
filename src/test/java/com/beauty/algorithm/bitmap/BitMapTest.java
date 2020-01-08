package com.beauty.algorithm.bitmap;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BitMapTest {

    @Test
    public void test() {
        BitMap bitMap = new BitMap(16);
        bitMap.set(1);
        assertTrue(bitMap.get(1));
        assertFalse(bitMap.get(2));
    }

}