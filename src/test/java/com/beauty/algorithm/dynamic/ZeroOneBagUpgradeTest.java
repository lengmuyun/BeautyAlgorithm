package com.beauty.algorithm.dynamic;

import com.beauty.algorithm.thought.dynamic.ZeroOneBagUpgrade;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZeroOneBagUpgradeTest {

    @Test
    public void test() {
        ZeroOneBagUpgrade zeroOneBag = new ZeroOneBagUpgrade();
        int maxValue = ZeroOneBagUpgrade.knapsack3(zeroOneBag.getItems(), zeroOneBag.getValues(), zeroOneBag.getN(), zeroOneBag.getW());
        int maxV = ZeroOneBagUpgrade.knapsack4(zeroOneBag.getItems(), zeroOneBag.getValues(), zeroOneBag.getN(), zeroOneBag.getW());
        assertEquals(maxV, maxValue);
    }

}