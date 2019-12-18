package com.beauty.algorithm.heap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {

    private Heap heap;

    @Before
    public void initialize() {
        heap = new Heap(8);
        heap.add(10);
        heap.add(9);
        heap.add(8);
        heap.add(6);
        heap.add(5);
        heap.add(7);
        heap.add(4);
        heap.add(3);
    }

    @Test
    public void insert() {
        assertEquals("[10, 9, 8, 6, 5, 7, 4, 3]", heap.toString());
    }

    @Test
    public void removeMax() {
        heap.removeMax();
        assertEquals("[9, 6, 8, 3, 5, 7, 4]", heap.toString());

        heap.removeMax();
        assertEquals("[8, 6, 7, 3, 5, 4]", heap.toString());

        heap.removeMax();
        assertEquals("[7, 6, 4, 3, 5]", heap.toString());
    }

    @Test
    public void testBuild() {
        int[] a = { 0, 5, 7, 6, 4, 2, 1 };
        Heap of = Heap.of(a, 6);
        assertEquals("[7, 5, 6, 4, 2, 1]", of.toString());
    }

}