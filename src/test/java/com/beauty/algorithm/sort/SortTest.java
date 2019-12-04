package com.beauty.algorithm.sort;

import com.beauty.algorithm.sort.bubble.BubbleSort;
import com.beauty.algorithm.sort.insertion.InsertionSort;
import com.beauty.algorithm.sort.merge.MergeSort;
import com.beauty.algorithm.sort.quick.QuickSort;
import com.beauty.algorithm.sort.selection.SelectionSort;
import org.junit.Test;

import java.util.Arrays;

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

    private void testSort(Sort sort) {
        int[] array = { 4, 5, 6, 3, 2, 1 };
        sort.sort(array, array.length);
        System.out.println(Arrays.toString(array));
    }

}