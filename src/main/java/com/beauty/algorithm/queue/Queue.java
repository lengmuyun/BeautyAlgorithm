package com.beauty.algorithm.queue;

public interface Queue<E> {

    /**
     * 入队，在队尾插入数据
     * @param e
     * @return
     */
    boolean enqueue(E e);

    /**
     * 出队，从队头取一个元素
     * @return
     */
    E dequeue();

    /**
     * 返回队列是否为空
     * @return
     */
    boolean isEmpty();

}
