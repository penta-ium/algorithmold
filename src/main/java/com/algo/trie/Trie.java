package com.algo.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 字典树
 */
public class Trie {

    public char val;
    public boolean isWord;
    public Map<Character, Trie> children = new HashMap<Character, Trie>();

    public Trie() {

    }

    public Trie(Character ch) {
        this.val = ch;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new Trie(ch));
            }
            node = node.children.get(ch);
        }
        node.isWord = true;
    }

    public boolean search(String word) {

        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children.containsKey(ch)) {
                node = node.children.get(ch);
            } else {
                return false;
            }
        }
        return node.isWord;
    }

    public boolean startsWith(String word) {

        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children.containsKey(ch)) {
                node = node.children.get(ch);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie(' ');

        trie.insert("app");
        trie.insert("apple");
        trie.insert("apply");
        trie.insert("application");
        trie.insert("admin");
        trie.insert("abort");
        trie.insert("avenue");


        System.out.println(trie.search("appl"));
        System.out.println(trie.startsWith("appl"));

        System.out.println(trie.search("admin"));
        System.out.println(trie.startsWith("admin"));
    }
}
