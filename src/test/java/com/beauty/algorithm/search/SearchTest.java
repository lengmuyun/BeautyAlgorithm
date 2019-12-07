package com.beauty.algorithm.search;

import com.beauty.algorithm.search.binary.BinarySearch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchTest {

    @Test
    public void search() {
        int[] array = new int[] { 1, 3, 5, 7, 9 };
        assertEquals(-1, new BinarySearch().search(array, array.length, 2));
    }

}