package com.beauty.algorithm.divide;

public class MergeSort {

    private int num = 0;

    public int count(int[] a, int n) {
        num = 0;
        mergeSortCounting(a, 0, n-1);
        return num;
    }

    private void mergeSortCounting(int[] a, int p, int r) {
        if (p >= r) return;
        int q = (p+r)/2;
        mergeSortCounting(a, p, q);
        mergeSortCounting(a, q+1, r);
        mergeSort(a, p, q, r);
    }

    private void mergeSort(int[] a, int p, int q, int r) {
        int i=p, j=q+1, k=0;
        int[] tmp = new int[r-q+1];
        while (i<=q && j<=r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                num += (q-i+1);
                tmp[k++] = a[j++];
            }
        }
        while (i<=q) {
            tmp[k++] = a[j++];
        }
        while (j<=r) {
            tmp[k++] = a[j++];
        }
        for (i=0;i<r-p;++i) {
            a[p+i] = tmp[i];
        }
    }

}
