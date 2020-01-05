package com.beauty.algorithm.dynamic;

import com.beauty.algorithm.thought.dynamic.Distance;
import com.beauty.algorithm.thought.dynamic.LevenshteinDistance;
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