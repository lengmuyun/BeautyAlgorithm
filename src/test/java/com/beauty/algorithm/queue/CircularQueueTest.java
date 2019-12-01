package com.beauty.algorithm.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class CircularQueueTest {

    @Test
    public void enqueue() {
        Queue<String> queue = new CircularQueue<>(3);
        queue.enqueue("A");

        assertTrue(queue.enqueue("B"));
        assertFalse(queue.enqueue("C"));
    }

    @Test
    public void dequeue() {
        Queue<String> queue = new CircularQueue<>(3);
        queue.enqueue("A");
        queue.enqueue("B");

        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertNull(queue.dequeue());
    }

}