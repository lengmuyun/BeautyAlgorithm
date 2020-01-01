package com.beauty.algorithm.dynamic;

/**
 * 撸羊毛
 */
public class Wool {

    /** 商品价格 */
    private int[] values;

    /** 商品个数 */
    private int n;

    /** 满减条件 */
    private int w;

    public Wool(int[] values, int n, int w) {
        this.values = values;
        this.n = n;
        this.w = w;
    }

    public void double11advance() {
        boolean[][] states = new boolean[n][3*w+1];// 超过3倍就没有撸羊毛的价值了
        states[0][0] = true;
        if (values[0] <= 3*w) {
            states[0][values[0]] = true;
        }
        for (int i=1; i<n; i++) {
            for (int j=0; j<3*w; ++j) {
                if (states[i-1][j]) {
                    states[i][j] = true;
                }
            }
            for (int j=0; j<=3*w-values[i]; ++j) {
                if (states[i-1][j]) {
                    states[i][j+values[i]] = true;
                }
            }
        }
        int j;
        for (j=w; j<3*w+1; ++j) {
            if (states[n-1][j]) break;
        }
        if (j == 3*w+1) return;
        for (int i=n-1; i>=1; --i) {
            if (j-values[i] >= 0 && states[i-1][j-values[i]]) {
                System.out.println(values[i] + " ");
                j = j-values[i];
            }// 没有购买这个商品，j不变
        }
        if (j != 0) System.out.println(values[0]);
    }

}
