package com.beauty.algorithm.search.binary;

import com.beauty.algorithm.search.Search;

public class CycleBinarySearch implements Search {

    @Override
    public int search(int[] array, int n, int value) {
        int low = 0;
        int min = array[0];
        for (int i=1; i<n; i++) {
            if (array[i] < min) {
                min = array[i];
                low = i;
            }
        }
        return 0;
    }

}
