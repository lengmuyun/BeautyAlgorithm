package com.beauty.algorithm.match.string;

/**
 * RK算法
 */
public class RabinKarpStringMatcher implements StringMatcher {

    public static final int[] bitValue = new int[10];

    static {
        bitValue[0] = 1;
        for (int i=1; i<10; i++) {
            bitValue[i] = bitValue[i-1]*26;
        }
    }

    /**
     * 使用hash算法优化BF算法，主串和模式串只能包含小写字母，否则算法会出问题
     * @param main 主串
     * @param pattern 模式串
     * @return
     */
    @Override
    public int match(String main, String pattern) {
        if (main.length() < pattern.length()) return -1;

        int m = main.length(), p = pattern.length();
        int[] indexToHash = buildHash(main, m, p);
        int patternHash = hash(pattern, 0, p);
        for (int i=0; i<indexToHash.length; i++) {
            if (patternHash == indexToHash[i]) {
                if (isMatch(main, pattern, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int[] buildHash(String main, int m, int p) {
        int[] indexToHash = new int[m-p+1];
        int previousHash = hash(main, 0, p);
        indexToHash[0] = previousHash;
        int currentHash;
        for (int i=1; i<=m-p; i++) {
            currentHash = 26*(indexToHash[i-1] - bitValue[p-1] * (main.charAt(i - 1) - 'a')) + (main.charAt(i+p-1) - 'a');
            indexToHash[i] = currentHash;
        }
        return indexToHash;
    }

    public int hash(String main, int startIndex, int length) {
        int hashVal = 0;
        for (int i=0; i<length; i++) {
            hashVal += bitValue[length-i-1]*(main.charAt(startIndex+i) - 'a');
        }
        return hashVal;
    }

}
