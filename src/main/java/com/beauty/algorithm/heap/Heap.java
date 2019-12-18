package com.beauty.algorithm.heap;

import java.util.Arrays;

import static com.beauty.algorithm.util.ArrayUtil.swap;

/**
 * 大顶堆
 */
public class Heap {

    /** 数组，从下标1开始存储数据 */
    private int[] a;

    /** 堆可以存储的最大数据个数 */
    private int n;

    /** 堆中已经存储的数据个数 */
    private int count;

    public Heap(int capacity) {
        this.a = new int[capacity + 1];
        this.n = capacity;
        count = 0;
    }

    private Heap(int[] a, int n) {
        this.a = a;
        this.n = n;
    }

    public boolean add(int data) {
        if (count >= n) return false;

        count++;
        a[count] = data;

        // 自下而上堆化
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]) {
            swap(a, i, i/2);
            i = i/2;
        }
        return true;
    }

    public boolean removeMax() {
        if (count == 0) return false;

        a[1] = a[count];
        count--;
        heapify(a, count, 1);
        return true;
    }

    @Override
    public String toString() {
        int[] toString = new int[count];
        System.arraycopy(a, 1, toString, 0, count);
        return Arrays.toString(toString);
    }

    /**
     * 数组中1-n存储数据
     * @param a
     * @param n
     */
    public static Heap of(int[] a, int n) {
        Heap heap = new Heap(a, n);
        heap.rebuild();
        return heap;
    }

    private void rebuild() {
        this.count = 1;
        for (int i=2; i<a.length; i++) {
            add(a[i]);
        }
    }

    private static void buildHeap(int[] a, int n) {
        for (int i = n/2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i*2 <= n && a[i] < a[i*2]) maxPos = i*2;
            if (i*2+1 <= n && a[maxPos] < a[i*2+1]) maxPos = i*2+1;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }


    // n表示数据的个数，数组a中的数据从下标1到n的位置。
    public static void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }

}
