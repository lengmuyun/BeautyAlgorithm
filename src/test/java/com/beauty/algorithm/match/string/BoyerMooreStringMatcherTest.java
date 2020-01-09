package com.beauty.algorithm.match.string;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BoyerMooreStringMatcherTest {

    @Test
    public void generateGS() {
        BoyerMooreStringMatcher matcher = new BoyerMooreStringMatcher();
        char[] b = "cabcab".toCharArray();
        int[] suffix = new int[b.length];
        boolean[] prefix = new boolean[b.length];
        matcher.generateGS(b, b.length, suffix, prefix);
        assertEquals(Arrays.toString(new int[] { -1, 2, 1, 0, -1, -1 }), Arrays.toString(suffix));
        assertEquals(Arrays.toString(new boolean[] { false, false, false, true, false, false }), Arrays.toString(prefix));
    }

}