package com.beauty.algorithm.sort.merge;

import com.beauty.algorithm.sort.Sort;

public class MergeSort implements Sort {

    @Override
    public void sort(int[] array, int n) {
        mergeSort(array, 0, n-1);
    }

    public void mergeSort(int[] array, int p, int r) {
        if (p >= r) return;

        int q = (p + r)/2;
        mergeSort(array, p, q);
        mergeSort(array, q+1, r);
        merge(array, p, q, q+1, r);
    }

    /**
     * 如何使用哨兵节点优化代码，使之为原地排序?
     * @param array
     * @param p1
     * @param r1
     * @param p2
     * @param r2
     */
    private void merge(int[] array, int p1, int r1, int p2, int r2) {
        int size = (r1 - p1 + 1) + (r2 - p2 + 1);
        int[] temp = new int[size];

        int i = p1, j = p2;
        int pos = 0;
        while (i <= r1 && j <= r2) {
            if (array[i] < array[j]) {
                temp[pos] = array[i];
                i++;
            } else {
                temp[pos] = array[j];
                j++;
            }
            pos++;
        }

        while (i <= r1) {
            temp[pos++] = array[i++];
        }

        while (j <= r2) {
            temp[pos++] = array[j++];
        }

        System.arraycopy(temp, 0, array, p1, size);
    }

}
