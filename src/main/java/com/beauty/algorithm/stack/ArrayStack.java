package com.beauty.algorithm.stack;

/**
 * 基于数组实现的顺序栈
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

    private Object[] items;
    private int count;
    private int n;

    public ArrayStack(int n) {
        this.items = new Object[n];
        this.n = n;
        this.count = 0;
    }

    @Override
    public boolean push(E e) {
        if (count == n) return false;
        items[count] = e;
        count++;
        return true;
    }

    @Override
    public E pop() {
        E item = peak();
        if (item != null) {
            count--;
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public E peak() {
        if (count == 0) return null;
        Object item = items[count-1];
        return (E) item;
    }
}
