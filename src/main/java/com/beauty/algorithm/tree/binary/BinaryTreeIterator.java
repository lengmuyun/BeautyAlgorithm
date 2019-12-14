package com.beauty.algorithm.tree.binary;

public interface BinaryTreeIterator {

    /**
     * 前序遍历，对于树中的任意节点来说，先打印这个节点，然后再打印它的左子树，最后打印它的右子树。
     */
    String preOrder();

    /**
     * 中序遍历，对于树中的任意节点来说，先打印它的左子树，然后再打印它本身，最后打印它的右子树。
     */
    String inOrder();

    /**
     * 后序遍历，对于树中的任意节点来说，先打印它的左子树，然后再打印它的右子树，最后打印这个节点本身。
     */
    String postOrder();

    /**
     * 按层遍历
     * @return
     */
    String floorOrder();

}
