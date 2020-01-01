package com.beauty.algorithm.dynamic;

public class LevenshteinDistance implements Distance {

    private char[] a;
    private char[] b;
    private final int n;
    private final int m;
    private int minDist = Integer.MAX_VALUE;

    public LevenshteinDistance(String s1, String s2) {
        this.a = s1.toCharArray();
        this.b = s2.toCharArray();
        this.n = a.length;
        this.m = b.length;
    }

    @Override
    public int calculateEditDistance() {
        minDist = Integer.MAX_VALUE;
        lwsBT(0, 0, 0);
        return minDist;
    }

    public void lwsBT(int i, int j, int edist) {
        if (i == n || j == m) {
            if (i < n) edist += (n - i);
            if (j < m) edist += (m - j);
            if (edist < minDist) minDist = edist;
            return;
        }
        if (a[i] == b[j]) { // 两个字符匹配
            lwsBT(i+1, j+1, edist);
        } else { // 两个字符不匹配
            lwsBT(i+1, j, edist+1); // 删除a[i]或者b[j]前添加一个字符
            lwsBT(i, j+1, edist+1); // 删除b[j]或者a[i]前添加一个字符
            lwsBT(i+1, j+1, edist+1); // 将a[i]和b[j]替换为相同字符
        }
    }

    public int lwstDP() {
        int[][] states = new int[n][m];
        // 填充第一行
        states[0][0] = (a[0] == b[0] ? 0 : 1);
        for (int i=1; i<m; i++) {
            states[0][i] = (a[0] == b[i] ? states[0][i-1] : states[0][i-1] + 1);
        }
        // 填充第一列
        for (int j=1; j<n; j++) {
            states[j][0] = (b[0] == a[j] ? states[j-1][0] : states[j-1][0] + 1);
        }
        // 填充状态转移表
        for (int i=1; i<n; i++) {
            for (int j=1; j<m; j++) {
                if (a[i] == b[j]) {
                    states[i][j] = min(states[i-1][j]+1, states[i][j-1]+1, states[i-1][j-1]);
                } else {
                    states[i][j] = min(states[i-1][j]+1, states[i][j-1]+1, states[i-1][j-1]+1);
                }
            }
        }
        return states[n-1][m-1];
    }

    private int min(int x, int y, int z) {
        int minv = Integer.MAX_VALUE;
        if (x < minv) minv = x;
        if (y < minv) minv = y;
        if (z < minv) minv = z;
        return minv;
    }

}
