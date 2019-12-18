package com.beauty.algorithm.tree.trie;

public class Trie {

    private TrieNode root = new TrieNode('/');

    /**
     * 往Trie树中插入一个字符串
     * @param text
     */
    public void add(char[] text) {
        TrieNode node = root;
        for (int i=0; i<text.length; i++) {
            int index = text[i] - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(text[i]);
            }
            node = node.children[index];
        }
        node.isEndingChar = true;
    }

    /**
     * 检索Trie树中是否包含某个字符串
     * @param text
     * @return
     */
    public boolean contains(char[] text) {
        TrieNode node = root;
        for (int i=0; i<text.length; i++) {
            int index = text[i] - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndingChar;
    }

    public class TrieNode {

        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }

    }

}
