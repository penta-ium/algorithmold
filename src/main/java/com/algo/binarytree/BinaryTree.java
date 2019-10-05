package com.algo.binarytree;

/**
 * 二叉树
 */
public class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public static BinaryTree generate() {
        BinaryTree tree3 = new BinaryTree(3, null, null);
        BinaryTree tree4 = new BinaryTree(4, null, null);
        BinaryTree tree2 = new BinaryTree(2, tree3, tree4);

        BinaryTree tree6 = new BinaryTree(6, null, null);
        BinaryTree tree5 = new BinaryTree(5, null, tree6);

        BinaryTree tree1 = new BinaryTree(1, tree2, tree5);
        return tree1;
    }

    public static BinaryTree generateSpe() {

        BinaryTree node3 = new BinaryTree(3, null, null);
        BinaryTree node2 = new BinaryTree(2, node3, null);
        BinaryTree node1 = new BinaryTree(1, null, node2);

        return node1;
    }

    public static void visit(BinaryTree node) {
        if (node == null) {
            System.out.print("null ");
            return;
        }

        System.out.print(node.value + " ");
    }
}
