package com.beauty.algorithm.search.binary;

import com.beauty.algorithm.search.Search;

public class BinarySearch implements Search {

    @Override
    public int search(int[] array, int n, int value) {
        int low = 0;
        int high = n-1;

        while (low <= high) {
            int mid = (low + high)/2;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearch(int[] array, int low, int high, int value) {
        if (low > high) return -1;

        int mid = low + (high - low) >> 1;
        if (array[mid] == value) {
            return mid;
        } else if (array[mid] > value) {
            return binarySearch(array, low, mid - 1, value);
        } else {
            return binarySearch(array, mid + 1, high, value);
        }
    }

}
