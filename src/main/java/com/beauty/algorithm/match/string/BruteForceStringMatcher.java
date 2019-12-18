package com.beauty.algorithm.match.string;

/**
 * BF算法
 */
public class BruteForceStringMatcher implements StringMatcher {

    @Override
    public int match(String main, String pattern) {
        if (main.length() < pattern.length()) return -1;

        int m = main.length(), p = pattern.length();
        for (int i=0; i<=m-p; i++) {
            if (isMatch(main, pattern, i)) {
                return i;
            }
        }
        return -1;
    }

}
