package com.beauty.algorithm.dynamic;

public class ZeroOneBagUpgrade {

    private int maxV = Integer.MIN_VALUE;
    private int[] items = { 2, 2, 4, 6, 3 };
    private int[] values = { 3, 4, 8, 9, 6 };
    private int n = 5;
    private int w = 9;

    public void f(int i, int cw, int cv) {
        if (cw >= w || i == n) {
            if (cv > maxV) maxV = cv;
            return;
        }
        f(i+1, cw, cv);// 第i个不装
        if (cw + items[i] <= w) {
            f(i+1, cw+items[i], cv+values[i]);
        }
    }

    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w+1];
        for (int i=0; i<n; i++) {// 初始化states
            for (int j=0; j<w+1; j++) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        for (int i=1; i<n; i++) {
            for (int j=0; j<=w; ++j) {
                if (states[i-1][j] >= 0) {
                    states[i][j] = states[i-1][j];
                }
            }
            for (int j=0; j<=w-weight[i]; ++j) {
                if (states[i-1][j] >= 0) {
                    int v = states[i-1][j] + value[i];
                    if (v > states[i][j+weight[i]]) {
                        states[i][j+weight[i]] = v;
                    }
                }
            }
        }
        int maxValue = -1;
        for (int j=0; j<=w; ++j) {
            if (states[n-1][j] > maxValue) {
                maxValue = states[n-1][j];
            }
        }
        return maxValue;
    }

    /**
     * 优化方法knapsack3,降低states空间复杂度
     * @param weight
     * @param value
     * @param n
     * @param w
     * @return
     */
    public static int knapsack4(int[] weight, int[] value, int n, int w) {
        int[] states = new int[w+1];
        for (int j=0; j<w+1; j++) {
            states[j] = -1;
        }
        states[0] = 0;
        if (weight[0] <= w) {
            states[weight[0]] = value[0];
        }
        for (int i=1; i<n; i++) {
            for (int j=0; j<=w-weight[i]; ++j) {
                if (states[j] >= 0) {
                    int v = states[j] + value[i];
                    if (v > states[j+weight[i]]) {
                        states[j+weight[i]] = v;
                    }
                }
            }
        }
        int maxValue = -1;
        for (int j=0; j<=w; ++j) {
            if (states[j] > maxValue) {
                maxValue = states[j];
            }
        }
        return maxValue;
    }

    public int getMaxV() {
        return maxV;
    }

    public int[] getItems() {
        return items;
    }

    public int[] getValues() {
        return values;
    }

    public int getN() {
        return n;
    }

    public int getW() {
        return w;
    }

}
