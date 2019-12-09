package com.beauty.algorithm.search.binary;

import com.beauty.algorithm.search.Search;

/**
 * 查找第一个值等于给定值的元素
 */
public class FirstEqualsBinarySearch implements Search {

    @Override
    public int search(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] == value) {
                if (mid == 0 || array[mid - 1] != value) {
                    return mid;
                }
                high = mid - 1;
            } else if (array[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
