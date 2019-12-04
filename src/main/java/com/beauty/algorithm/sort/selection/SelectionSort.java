package com.beauty.algorithm.sort.selection;

import com.beauty.algorithm.sort.Sort;

public class SelectionSort implements Sort {

    @Override
    public void sort(int[] array, int n) {
        if (n <= 1) return;

        for (int i=0; i<n; i++) {
            int min = i;
            for (int j=i+1; j<n; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (i != min) swap(array, i, min);
        }
    }

}
