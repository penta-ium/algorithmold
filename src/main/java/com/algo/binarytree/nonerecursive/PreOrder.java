package com.algo.binarytree.nonerecursive;

import com.algo.binarytree.BinaryTree;

import java.util.Stack;

public class PreOrder {

    public void traverse(BinaryTree root) {
        if (root == null)
            return;

        Stack<BinaryTree> stack = new Stack<>();

        //初始化
        while (root != null) {
            BinaryTree.visit(root);
            stack.push(root);
            root = root.left;
        }

        //hasNext
        while (!stack.isEmpty()) {

            BinaryTree pop = stack.pop();
            BinaryTree node = pop.right;
            while(node != null) {
                BinaryTree.visit(node);
                stack.push(node);
                node = node.left;
            }
        }
    }


    public void traverse2(BinaryTree root) {
        if (root == null)
            return;

        Stack<BinaryTree> stack = new Stack<>();

        //初始化
        while (root != null) {
            BinaryTree.visit(root);
            stack.push(root);
            root = root.left;
        }

        //hasNext
        while (!stack.isEmpty()) {

            BinaryTree pop = stack.pop();
            BinaryTree node = pop.right;
            while(node != null) {
                BinaryTree.visit(node);
                stack.push(node);
                node = node.left;
            }
        }
    }


    public static void main(String[] args) {
        new PreOrder().traverse(BinaryTree.generate());
    }
}
