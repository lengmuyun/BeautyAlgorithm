package com.beauty.algorithm.tree.binary.search;

public class BinarySearchTree {

    private Node tree;

    public BinarySearchTree() {
    }

    public Node find(int data) {
        Node node = tree;
        while (node != null) {
            if (data == node.data) {
                return node;
            } else if (data > node.data) {
                node = node.right;
            } else {
                node = node.left;
            }

        }
        return null;
    }

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node node = tree;
        while (true) {
            if (data > node.data) {
                if (node.right == null) {
                    node.right = new Node(data);
                    break;
                } else {
                    node = node.right;
                }
            } else {
                if (node.left == null) {
                    node.left = new Node(data);
                    break;
                } else {
                    node = node.left;
                }
            }
        }
    }

    public void delete(int data) {
        Node p = tree;
        Node pp = null;
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) p = p.right;
            else p = p.left;
        }
        if (p == null) return;



    }

    public static class Node {

        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

    }

}
