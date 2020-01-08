package com.beauty.algorithm.match.string;

public class BoyerMooreStringMatcher implements StringMatcher {

    private static final int SIZE = 256; // 全局变量或成员变量

    @Override
    public int match(String main, String pattern) {
        char[] a = main.toCharArray();
        char[] b = pattern.toCharArray();
        return bm(a, a.length, b, b.length);
    }

    /**
     * bm算法字符串匹配
     * @param a 主串
     * @param n 主串的长度
     * @param b 模式串
     * @param m 模式串的长度
     * @return
     */
    public int bm(char[] a, int n, char[] b, int m) {
        // 记录模式串中每个字符最后出现的位置
        int[] bc = new int[SIZE];
        // 构建坏字符哈希表
        generateBC(b, m, bc);
        int i=0;
        while (i <= n - m) {
            int j;
            // 模式串从后往前匹配
            for (j = m - 1; j >= 0; --j) {
                // 坏字符对应模式串中的下标是j
                if (a[i+j] != b[j]) break;
            }
            if (j < 0) {
                // 匹配成功，返回主串与模式串第一个匹配的字符的位置
                return i;
            }
            // 这里等同鱼将模式串往后滑动j-bc[a[i+j]]位
            i = i + (j - bc[a[i+j]]);
        }
        return -1;
    }

    /**
     * 构建坏字符哈希表
     * @param b 模式串
     * @param m 模式串长度
     * @param bc 坏字符串哈希表
     */
    private void generateBC(char[] b, int m, int[] bc) {
        for (int i=0; i<SIZE; i++) {
            bc[i] = -1;
        }
        for (int i=0; i<m; i++) {
            int ascii = b[i];
            bc[ascii] = i;
        }
    }

}
