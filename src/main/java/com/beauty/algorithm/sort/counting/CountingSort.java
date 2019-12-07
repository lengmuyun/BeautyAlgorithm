package com.beauty.algorithm.sort.counting;

import com.beauty.algorithm.sort.Sort;

public class CountingSort implements Sort {

    @Override
    public void sort(int[] array, int n) {
        if (n <= 1) return;

        // 获取元素的区间[0, max]
        int max = array[0];
        for (int i=1; i<array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        int[] itemToCount = new int[max + 1];
        for (int i=0; i<array.length; i++) {
            itemToCount[array[i]] = itemToCount[array[i]] + 1;
        }

        for (int i=1; i<itemToCount.length; i++) {
            itemToCount[i] = itemToCount[i] + itemToCount[i-1];
        }

        int[] sortedArray = new int[array.length];
        for (int i=0; i<array.length; i++) {
            int index = itemToCount[array[i]];
            sortedArray[index-1] = array[i];
            itemToCount[array[i]] = itemToCount[array[i]] - 1;
        }

        for (int i=0; i<sortedArray.length; i++) {
            array[i] = sortedArray[i];
        }
    }

}
