package com.beauty.algorithm.search.binary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstEqualsBinarySearchTest {

    @Test
    public void search() {
        FirstEqualsBinarySearch bs = new FirstEqualsBinarySearch();
        assertEquals(1, bs.search(new int[] { 1, 2, 2, 3, 4 }, 5, 2));
        assertEquals(0, bs.search(new int[] { 2, 2, 3, 4, 5 }, 5, 2));
        assertEquals(3, bs.search(new int[] { 2, 2, 3, 4, 5 }, 5, 4));
        assertEquals(-1, bs.search(new int[] { 1, 2, 3, 4, 5 }, 5, 6));
    }

}