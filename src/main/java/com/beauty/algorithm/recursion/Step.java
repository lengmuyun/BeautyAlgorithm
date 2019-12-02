package com.beauty.algorithm.recursion;

import java.util.HashMap;
import java.util.Map;

public class Step {

    /** 缓存走n级台阶的走法，避免重复计算 */
    private Map<Integer, Integer> stepMap;

    public Step() {
        stepMap = new HashMap<>();
    }

    /**
     * 返回n级台阶一共有多少种走法，一次只能走一级或二级台阶
     * @param n 台阶的级数
     * @return
     */
    public int move(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (stepMap.containsKey(n)) {
            return stepMap.get(n);
        }

        int res = move(n - 1) + move(n - 2);
        stepMap.put(n, res);
        return res;
    }

    /**
     * 去递归写法
     * @param n
     * @return
     */
    public int simpleMove(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int a1 = 1, a2 = 2;
        int res = 0;
        for (int i=3; i<=n; i++) {
            res = a1 + a2;
            a1 = a2;
            a2 = res;
        }
        return res;
    }

}
