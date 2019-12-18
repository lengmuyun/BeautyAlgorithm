package com.beauty.algorithm.tree.trie;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieTest {

    @Test
    public void contains() {
        Trie trie = new Trie();
        trie.add("aaa".toCharArray());

        assertTrue(trie.contains("aaa".toCharArray()));
        assertFalse(trie.contains("aa".toCharArray()));
    }

}