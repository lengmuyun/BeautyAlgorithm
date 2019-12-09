package com.beauty.algorithm.search.binary;

import org.junit.Test;

import static org.junit.Assert.*;

public class CycleBinarySearchTest {

    @Test
    public void search() {
        CycleBinarySearch cbs = new CycleBinarySearch();
        int[] cycleSortedArray = new int[] { 4, 5, 6, 1, 2, 3 };
        assertEquals(3, cbs.search(cycleSortedArray, cycleSortedArray.length, 1));
    }

}