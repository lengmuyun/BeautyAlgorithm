package com.beauty.algorithm.queue;

public class CircularQueue<E> implements Queue<E> {

    private Object[] items;
    private int n;
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        this.items = new Object[capacity];
        this.n = capacity;
    }

    @Override
    public boolean enqueue(E e) {
        if ((tail + 1) % n == head) return false;
        items[tail] = e;
        tail = (tail + 1) % n;
        return true;
    }

    @Override
    public E dequeue() {
        if (head == tail) return null;
        E item = (E) items[head];
        head = (head + 1) % n;
        return item;
    }

}
