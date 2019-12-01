package com.beauty.algorithm.queue;

public class ArrayQueue<E> implements Queue<E> {

    private Object[] items;
    private int n;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        this.items = new Object[capacity];
        this.n = capacity;
    }

    @Override
    public boolean enqueue(E e) {
        if (tail == n) {
            if (head == 0) return false;

            // 数据搬移
            for (int i=head; i<tail; i++) {
                items[i-head] = items[i];
            }
            tail = tail - head;
            head = 0;
        }
        items[tail] = e;
        tail++;
        return true;
    }

    @Override
    public E dequeue() {
        if (head == tail) return null;
        E item = (E) items[head];
        head++;
        return item;
    }

}
