package com.beauty.algorithm.sort.quick;

import com.beauty.algorithm.sort.Sort;

public class QuickSort implements Sort {

    @Override
    public void sort(int[] array, int n) {
        quickSort(array, 0, n-1);
    }

    private void quickSort(int[] array, int p, int r) {
        if (p >= r) return;

        int q = partition(array, p, r);
        quickSort(array, p, q-1);
        quickSort(array, q+1, r);
    }

    private int partition(int[] array, int p, int r) {
        int pivot = array[r];
        int i = p;
        for (int j=p; j<r; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, r);
        return i;
    }

}
