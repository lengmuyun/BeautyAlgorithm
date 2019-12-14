package com.beauty.algorithm.tree.binary;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ArrayBinaryTreeTest {

    private ArrayBinaryTree<String> binaryTree;

    @Before
    public void initialize() {
        binaryTree = new ArrayBinaryTree<>(7);
        Stream.of("A", "B", "C", "D", "E", "F", "G").forEach(binaryTree::add);
    }

    @Test
    public void preOrder() {
        assertEquals("A->B->D->E->C->F->G", binaryTree.preOrder());
    }

    @Test
    public void inOrder() {
        assertEquals("D->B->E->A->F->C->G", binaryTree.inOrder());
    }

    @Test
    public void postOrder() {
        assertEquals("D->E->B->F->G->C->A", binaryTree.postOrder());
    }

}