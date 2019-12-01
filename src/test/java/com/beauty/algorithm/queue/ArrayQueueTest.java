package com.beauty.algorithm.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ArrayQueueTest {

    @Test
    public void enqueue() {
        Queue<String> queue = new ArrayQueue<>(2);
        queue.enqueue("A");

        assertTrue(queue.enqueue("B"));
        assertFalse(queue.enqueue("C"));

        queue.dequeue();
        assertTrue(queue.enqueue("C"));
    }

    @Test
    public void dequeue() {
        Queue<String> queue = new ArrayQueue<>(2);
        queue.enqueue("A");
        queue.enqueue("B");

        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertNull(queue.dequeue());
    }

}