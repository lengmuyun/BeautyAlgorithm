package com.beauty.algorithm.search.binary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LastEqualsBinarySearchTest {

    @Test
    public void search() {
        LastEqualsBinarySearch bs = new LastEqualsBinarySearch();
        assertEquals(2, bs.search(new int[] { 1, 2, 2, 3, 4 }, 5, 2));
        assertEquals(4, bs.search(new int[] { 1, 2, 2, 4, 4 }, 5, 4));
        assertEquals(-1, bs.search(new int[] { 1, 2, 2, 4, 4 }, 5, 5));
        assertEquals(0, bs.search(new int[] { 1, 2, 2, 4, 4 }, 5, 1));
    }

}