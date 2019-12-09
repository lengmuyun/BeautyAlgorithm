package com.beauty.algorithm.search.binary;

import com.beauty.algorithm.search.Search;

/**
 * 查找最后一个小于等于给定值的元素
 */
public class LastLowEqualsBinarySearch implements Search {

    @Override
    public int search(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] <= value) {
                if (mid == n - 1 || array[mid + 1] > value) {
                    return mid;
                }
                low = mid + 1;
            } else if (array[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
