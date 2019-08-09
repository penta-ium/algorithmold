package com.algo.common;

import java.util.LinkedList;
import java.util.Stack;

public class BSTreeNode {

    public int val;
    public BSTreeNode left;
    public BSTreeNode right;

    public BSTreeNode(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        BSTreeNode node_10 = new BSTreeNode(10);
        BSTreeNode node_6 = new BSTreeNode(6);
        BSTreeNode node_14 = new BSTreeNode(14);
        BSTreeNode node_4 = new BSTreeNode(4);
        BSTreeNode node_8 = new BSTreeNode(8);
        BSTreeNode node_12 = new BSTreeNode(12);
        BSTreeNode node_16 = new BSTreeNode(16);

        node_6.left = node_4;
        node_6.right = node_8;

        node_14.left = node_12;
        node_14.right = node_16;

        node_10.left = node_6;
        node_10.right = node_14;


        System.out.println("dfs recursive.");
        //dfs_recursive(node_10);
        System.out.println();
        System.out.println("dfs none recursive.");
        //dfs_none_recursive(node_10);
        System.out.println();
        BSTreeNode nodeA = new BSTreeNode(1);
        BSTreeNode nodeB = new BSTreeNode(2);
        BSTreeNode nodeC = new BSTreeNode(3);
        BSTreeNode nodeD = new BSTreeNode(4);
        BSTreeNode nodeE = new BSTreeNode(5);
        BSTreeNode nodeF = new BSTreeNode(6);
        BSTreeNode nodeG = new BSTreeNode(7);

        nodeB.left = nodeD;
        nodeB.right = nodeE;

        nodeC.left = nodeF;
        nodeC.right = nodeG;

        nodeA.left = nodeB;
        nodeA.right = nodeC;


        bfs(nodeA);

    }

    /**
     * 递归深度遍历
     * @param root
     */
    public static void dfs_recursive(BSTreeNode root) {

        if (root == null)
            return;

        dfs_recursive(root.left);
        System.out.print(root.val + " ");
        dfs_recursive(root.right);
    }

    /**
     * 非递归深度遍历
     * @param root
     */
    public static void dfs_none_recursive(BSTreeNode root) {

        Stack<BSTreeNode> stack = new Stack<BSTreeNode>();
        while (true) {

            if (root != null) {
                stack.push(root);
                root = root.left;
                continue;
            }

            if (stack.isEmpty())
                break;

            BSTreeNode node = stack.pop();
            System.out.print(node.val + " ");
            root = node.right;
            //continue;
        }
    }

    public static void bfs(BSTreeNode root) {

        LinkedList<BSTreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {

            BSTreeNode node = queue.pollFirst();
            System.out.print(node.val + "  ");

            if (node.left != null)
                queue.addLast(node.left);

            if (node.right != null)
                queue.addLast(node.right);
        }
    }

}
