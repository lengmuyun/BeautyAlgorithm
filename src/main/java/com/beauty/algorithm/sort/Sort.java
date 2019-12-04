package com.beauty.algorithm.sort;

public interface Sort {

    /**
     * 排序
     * @param array
     * @param n
     */
    void sort(int[] array, int n);

    default void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
