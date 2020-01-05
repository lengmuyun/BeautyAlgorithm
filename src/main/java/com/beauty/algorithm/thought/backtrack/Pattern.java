package com.beauty.algorithm.thought.backtrack;

public class Pattern {

    private boolean matched = false;

    /** 正则表达式 */
    private char[] pattern;

    /** 正则表达式长度 */
    private int plen;

    public Pattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }

    /**
     * 判断字符串是否匹配正则
     * @param text 文本串
     * @param tlen 文本串长度
     * @return
     */
    public boolean match(char[] text, int tlen) {
        matched = false;
        rmatch(0, 0, text, tlen);
        return matched;
    }

    private void rmatch(int ti, int pj, char[] text, int tlen) {
        // 如果已经匹配了，就不要继续递归了
        if (matched) return;
        // 正则表达式到结尾了
        if (pj == plen) {
            // 文本串也到结尾了
            if (ti == tlen) matched = true;
            return;
        }
        if (pattern[pj] == '*') { // * 匹配任意个字符
            for (int k=0; k<tlen-ti; k++) {
                rmatch(ti+k, pj+1, text, tlen);
            }
        } else if (pattern[pj] == '?') { // ? 匹配0个或1个字符
            rmatch(ti, pj+1, text, tlen);
            rmatch(ti+1, pj+1, text, tlen);
        } else if (ti < tlen && pattern[pj] == text[ti]) { // 纯字符匹配才行
            rmatch(ti+1, pj+1, text, tlen);
        }
    }

}
