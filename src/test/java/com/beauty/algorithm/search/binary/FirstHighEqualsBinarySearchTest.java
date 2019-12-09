package com.beauty.algorithm.search.binary;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstHighEqualsBinarySearchTest {

    @Test
    public void search() {
        FirstHighEqualsBinarySearch bs = new FirstHighEqualsBinarySearch();
        assertEquals(1, bs.search(new int[] { 1, 2, 2, 3, 4 }, 5, 2));
        assertEquals(0, bs.search(new int[] { 1, 1, 2, 3, 4 }, 5, 0));
        assertEquals(3, bs.search(new int[] { 1, 1, 2, 3, 4 }, 5, 3));
        assertEquals(-1, bs.search(new int[] { 1, 1, 2, 3, 4 }, 5, 5));
    }

}