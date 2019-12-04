package com.beauty.algorithm.sort.bubble;

import com.beauty.algorithm.sort.Sort;

public class BubbleSort implements Sort {

    @Override
    public void sort(int[] array, int n) {
        if (n <= 1) return;

        for (int i=0; i<n; i++) {
            boolean hasItemSwap = false;
            for (int j=0; j<n-i-1; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                    hasItemSwap = true;
                }
            }
            if (!hasItemSwap) break;
        }
    }

}
