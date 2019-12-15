package com.beauty.algorithm.heap;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HeapTest {

    private Heap heap;

    @Before
    public void initialize() {
        heap = new Heap(8);
        heap.insert(10);
        heap.insert(9);
        heap.insert(8);
        heap.insert(6);
        heap.insert(5);
        heap.insert(7);
        heap.insert(4);
        heap.insert(3);
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

}