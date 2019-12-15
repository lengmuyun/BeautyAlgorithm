package com.beauty.algorithm.sort;

import com.beauty.algorithm.util.ArrayUtil;

public interface Sort {

    /**
     * 排序
     * @param array
     * @param n
     */
    void sort(int[] array, int n);

    default void swap(int[] array, int i, int j) {
        ArrayUtil.swap(array, i, j);
    }

}
