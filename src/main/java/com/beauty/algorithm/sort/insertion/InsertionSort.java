package com.beauty.algorithm.sort.insertion;

import com.beauty.algorithm.sort.Sort;

public class InsertionSort implements Sort {

    @Override
    public void sort(int[] array, int n) {
        if (n <= 1) return;

        for (int i=0; i<n-1; i++) {
            int pos = -1;
            int temp = array[i+1];
            for (int j=i; j>=0; j--) {
                if (array[j] > temp) {
                    array[j+1] = array[j];
                    pos = j;
                } else {
                    break;
                }
            }
            if (pos != -1) {
                array[pos] = temp;
            }
        }
    }

}
