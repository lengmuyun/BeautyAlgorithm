package com.beauty.algorithm.match.string;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RabinKarpStringMatcherTest {

    @Test
    public void hash() {
        RabinKarpStringMatcher stringMatcher = new RabinKarpStringMatcher();
        assertEquals(0, stringMatcher.hash("abcd", 0, 1));
        assertEquals(1, stringMatcher.hash("abcd", 0, 2));
        assertEquals(1353, stringMatcher.hash("cabcd", 0, 3));
    }

    @Test
    public void buildHash() {
        RabinKarpStringMatcher stringMatcher = new RabinKarpStringMatcher();
        assertEquals(Arrays.toString(new int[] { 0, 1, 2, 3 }), Arrays.toString(stringMatcher.buildHash("abcd", 4, 1)));
        assertEquals(Arrays.toString(new int[] { 1, 28, 55 }), Arrays.toString(stringMatcher.buildHash("abcd", 4, 2)));
        assertEquals(Arrays.toString(new int[] { 731, 1434, 2137 }), Arrays.toString(stringMatcher.buildHash("bcdef", 5, 3)));
    }

}