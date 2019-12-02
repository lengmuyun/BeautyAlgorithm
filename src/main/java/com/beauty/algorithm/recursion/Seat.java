package com.beauty.algorithm.recursion;

public class Seat {

    private int depth;
    public static final int MAX_RECURSION_DEPTH = 50;

    public Seat() {
        this.depth = 0;
    }

    /**
     * 找座位
     * @param n
     * @return
     */
    public int find(int n) {
        depth++;
        if (depth > MAX_RECURSION_DEPTH) {
            throw new RuntimeException("Exceeds maximum recursion depth: " + MAX_RECURSION_DEPTH);
        }

        if (n == 1) return 1;
        return find(n-1) + 1;
    }

    /**
     * 去递归写法
     * @param n
     * @return
     */
    public int simpleFind(int n) {
        int res = 1;
        for (int i=2; i<=n; i++) {
            res = res + 1;
        }
        return res;
    }

}
