package com.beauty.algorithm.stack;

public interface Stack<E> {

    /**
     * 入栈
     * @param e
     * @return
     */
    boolean push(E e);

    /**
     * 出栈
     * @return
     */
    E pop();

    /**
     * 判断栈空
     * @return
     */
    boolean isEmpty();

    /**
     * 返回栈顶元素
     * @return
     */
    E peak();

}
