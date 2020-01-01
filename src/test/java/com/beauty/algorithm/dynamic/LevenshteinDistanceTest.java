package com.beauty.algorithm.dynamic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LevenshteinDistanceTest {

    @Test
    public void calculateEditDistance() {
        Distance distance = new LevenshteinDistance("mitcmu", "mtacnu");
        assertEquals(3, distance.calculateEditDistance());
    }

    @Test
    public void calculateEditDistanceByDynamic() {
        LevenshteinDistance distance = new LevenshteinDistance("mitcmu", "mtacnu");
        assertEquals(3, distance.lwstDP());
    }

}