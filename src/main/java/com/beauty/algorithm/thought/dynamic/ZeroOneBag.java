package com.beauty.algorithm.thought.dynamic;

public class ZeroOneBag {

    private int maxW = Integer.MIN_VALUE;
    private int[] weight = { 2, 2, 4, 6, 3 };
    private int n = 5;
    private int w = 9;
    private boolean[][] mem = new boolean[5][10];

    public void f(int i, int cw) {
        if (cw == w || i == n) {
            if (cw > maxW) maxW = cw;
            return;
        }
        if (mem[i][cw]) return; // 重复状态
        mem[i][cw] = true;
        f(i+1, cw);
        if (cw + weight[i] <= w) {
            f(i+1, cw + weight[i]);
        }
    }

    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w+1];
        states[0][0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        for (int i=1; i<n; ++i) {
            for (int j=0; j<=w; ++j) {// 不把第i个物品放入背包
                if (states[i-1][j]) {
                    states[i][j] = states[i-1][j];
                }
            }
            for (int j=0; j<=w-weight[i]; j++) {//把第i个物品放入背包
                if (states[i-1][j]) {
                    states[i][j+weight[i]] = true;
                }
            }
        }
        for (int i=w; i>=0; --i) {
            if (states[n-1][i]) return i;
        }
        return 0;
    }

    public int knapsack2(int[] weight, int n, int w) {
        boolean[] states = new boolean[w+1];
        states[0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
        if (weight[0] <= w) {
            states[weight[0]] = true;
        }
        for (int i=1; i<n; ++i) {
            for (int j=w-weight[i]; j>=0; j--) {//把第i个物品放入背包
                if (states[j]) {
                    states[j+weight[i]] = true;
                }
            }
        }
        for (int i=w; i>=0; --i) {
            if (states[i]) return i;
        }
        return 0;
    }

}
