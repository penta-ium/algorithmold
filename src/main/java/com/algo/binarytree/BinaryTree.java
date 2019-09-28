package com.algo.binarytree;

/**
 * 二叉树
 */
public class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
