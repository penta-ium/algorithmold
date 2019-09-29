package com.algo.binarytree.nonerecursive;

import com.algo.binarytree.BinaryTree;

import java.util.Stack;

public class PostOrder {

    public void traverse(BinaryTree root) {
        if (root == null)
            return;

        Stack<BinaryTree> stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {

            BinaryTree pop = stack.pop();

            BinaryTree node = pop.right;
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

    public static void main(String[] args) {
        new PostOrder().traverse(BinaryTree.generate());
    }
}
