package com.beauty.algorithm.match.string;

public interface StringMatcher {

    /**
     * 在主串中检索模式串，返回模式串在主串中的索引
     * @param main 主串
     * @param pattern 模式串
     * @return
     */
    int match(String main, String pattern);

    default boolean isMatch(String main, String pattern, int i) {
        for (int j=0; j<pattern.length(); j++) {
            if (main.charAt(i+j) != pattern.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
