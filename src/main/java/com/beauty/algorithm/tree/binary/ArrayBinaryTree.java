package com.beauty.algorithm.tree.binary;

import com.beauty.algorithm.queue.ArrayQueue;
import com.beauty.algorithm.queue.Queue;

public class ArrayBinaryTree<E> implements BinaryTree {

    private Object[] data;
    private int index;

    public ArrayBinaryTree(int initialCapacity) {
        this.data = new Object[initialCapacity + 1];
        this.index = 1;
    }

    public boolean add(E e) {
        if (index > data.length - 1) {
            return false;
        }
        data[index] = e;
        index++;
        return true;
    }

    @Override
    public String preOrder() {
        ArrayQueue<E> queue = new ArrayQueue<>(data.length - 1);
        preOrder(1, queue);
        if (queue.isEmpty()) return null;
        return print(queue);
    }

    private void preOrder(int index, Queue<E> queue) {
        if (index > data.length - 1) return;

        if (data[index] != null) queue.enqueue((E) data[index]);
        preOrder(index * 2, queue);
        preOrder(index * 2 + 1, queue);
    }

    @Override
    public String inOrder() {
        Queue<E> queue = new ArrayQueue<>(data.length - 1);
        inOrder(1, queue);
        if (queue.isEmpty()) return null;
        return print(queue);
    }

    private void inOrder(int index, Queue<E> queue) {
        if (index > data.length - 1) return;

        inOrder(index * 2, queue);
        queue.enqueue((E) data[index]);
        inOrder(index * 2 + 1, queue);
    }

    @Override
    public String postOrder() {
        Queue<E> queue = new ArrayQueue<>(data.length - 1);
        postOrder(1, queue);
        if (queue.isEmpty()) return null;
        return print(queue);
    }

    private void postOrder(int index, Queue<E> queue) {
        if (index > data.length - 1) return;

        postOrder(index * 2, queue);
        postOrder(index * 2 + 1, queue);
        queue.enqueue((E) data[index]);
    }

    private String print(Queue<E> queue) {
        E element = queue.dequeue();
        StringBuilder sb = new StringBuilder();
        sb.append(element);

        while (!queue.isEmpty()) {
            sb.append("->").append(queue.dequeue());
        }
        return sb.toString();
    }

}
