package com.beauty.algorithm.match.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringMatcherTest {

    @Test
    public void bfMatch() {
        match(new BruteForceStringMatcher());
    }

    @Test
    public void rkMatch() {
        match(new RabinKarpStringMatcher());
    }

    @Test
    public void bmMatch() {
        StringMatcher bm = new BoyerMooreStringMatcher();
        assertEquals(5, bm.match("abcacabdc", "abd"));
    }

    private void match(StringMatcher stringMatcher) {
        assertEquals(-1, stringMatcher.match("a", "de"));
        assertEquals(-1, stringMatcher.match("ab", "de"));
        assertEquals(3, stringMatcher.match("abcdef", "de"));
    }

}