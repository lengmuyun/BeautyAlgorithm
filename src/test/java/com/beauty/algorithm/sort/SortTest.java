package com.beauty.algorithm.sort;

import com.beauty.algorithm.sort.bubble.BubbleSort;
import com.beauty.algorithm.sort.counting.CountingSort;
import com.beauty.algorithm.sort.insertion.InsertionSort;
import com.beauty.algorithm.sort.merge.MergeSort;
import com.beauty.algorithm.sort.quick.QuickSort;
import com.beauty.algorithm.sort.selection.SelectionSort;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SortTest {

    @Test
    public void testBubbleSort() {
        testSort(new BubbleSort());
    }

    @Test
    public void testInsertionSort() {
        testSort(new InsertionSort());
    }

    @Test
    public void testSelectionSort() {
        testSort(new SelectionSort());
    }

    @Test
    public void testMergeSort() {
        testSort(new MergeSort());
    }

    @Test
    public void testQuickSort() {
        testSort(new QuickSort());
    }

    @Test
    public void testCountingSort() {
        int[] array = { 2, 5, 3, 0, 2, 3, 0,3 };
        new CountingSort().sort(array, array.length);
        assertEquals(Arrays.toString(new int[] { 0, 0, 2, 2, 3, 3, 3, 5}), Arrays.toString(array));
    }

    private void testSort(Sort sort) {
        int[] array = { 4, 5, 6, 3, 2, 1 };
        sort.sort(array, array.length);
        System.out.println(Arrays.toString(array));
    }

}