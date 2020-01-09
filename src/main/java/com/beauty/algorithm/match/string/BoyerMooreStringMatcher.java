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
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b, m, suffix, prefix);
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
            int x = j - bc[a[i+j]];
            int y = 0;
            if (j < m - 1) { // 如果有好后缀的话
                y = moveByGS(j, m, suffix, prefix);
            }
            i = i + Math.max(x, y);
        }
        return -1;
    }

    /**
     *
     * @param j 表示坏字符对应的模式串的字符下标
     * @param m 模式串长度
     * @param suffix
     * @param prefix
     * @return
     */
    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - 1 - j; // 好后缀长度
        if (suffix[k] != -1) {
            return j - suffix[k] + 1;
        }
        for (int r = j + 2; r < m - 1; ++r) {
            if (prefix[m - r]) {
                return r;
            }
        }
        return m;
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

    /**
     *
     * @param b 模式串
     * @param m 模式串的长度
     * @param suffix
     * @param prefix
     */
    public void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i=0; i<m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i=0; i<m-1; i++) {
            int j = i;
            int k = 0; // 公共后缀子串长度
            while (j >= 0 && b[j] == b[m-1-k]) { // 与b[0, m-1]求公共子串
                --j;
                ++k;
                suffix[k] = j+1; // j+1表示公共后缀子串在b[0, i]中的起始下标
            }
            if (j == -1) prefix[k] = true;
        }
    }

}
