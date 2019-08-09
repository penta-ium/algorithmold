package com.algo.microsoft;

import com.algo.common.BSTreeNode;

public class IsArrayPostOrderBST {

    /**
     * 判断数组是否是一个BST的后续遍历
     * 判断array的从start到end，是不是一颗BST
     * 如果左右两颗树都是BST，那么这棵树是BST
     * @param array
     */
    public boolean check(int[] array, int start, int end){

        boolean isLeftBST = true;
        boolean isRightBST = true;

        int leftTreeRootIndex = Integer.MIN_VALUE;
        int rightTreeFirstIndex = Integer.MIN_VALUE;

        int root = array[end];
        int i = end;
        for (; i >= start; i--) {
            if (array[i] < root) {
                leftTreeRootIndex = i;
                break;
            }
        }

        if (leftTreeRootIndex <= start)
            isLeftBST = true;
        else {
            for (int k  = start; k <= leftTreeRootIndex; k++) {
                if (array[k] >= array[end]) {
                    isLeftBST = false;
                }
            }
            if (isLeftBST)
                isLeftBST = check(array, start, leftTreeRootIndex);
        }

        int j = start;
        for (; j <= end; j++) {
            if (array[j] > root) {
                rightTreeFirstIndex = j;
                break;
            }
        }

        if (j >= end) {
            isRightBST = true;
        } else {
            for (int k = rightTreeFirstIndex; k < end; k ++) {
                if (array[k] < array[end]) {
                    isRightBST = false;
                    break;
                }
            }
            if (isRightBST)
                isRightBST = check(array, rightTreeFirstIndex, end - 1);
        }

        return isLeftBST && isRightBST;
    }

    /**
     * 后续遍历
     * @param root
     */
    public void postOrder(BSTreeNode root) {

        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 先序遍历
     * @param root
     */
    public void preOrder(BSTreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


    /**
     * @param args
     */
    public static void main(String[] args) {

        /**
         *       8
         *     /  \
         *    6   10
         *  /  \ /  \
         * 5   7 9  11
         */

        BSTreeNode nodeA = new BSTreeNode(8);
        BSTreeNode nodeB = new BSTreeNode(6);
        BSTreeNode nodeC = new BSTreeNode(10);
        BSTreeNode nodeD = new BSTreeNode(5);
        BSTreeNode nodeE = new BSTreeNode(7);
        BSTreeNode nodeF = new BSTreeNode(9);
        BSTreeNode nodeG = new BSTreeNode(11);

        nodeA.left = nodeB;
        nodeA.right = nodeC;

        nodeB.left = nodeD;
        nodeB.right = nodeE;

        nodeC.left = nodeF;
        nodeC.right = nodeG;

        //new IsArrayPostOrderBST().postOrder(nodeA);
        //new IsArrayPostOrderBST().preOrder(nodeA);


        int[] array = new int[]{5, 7, 6, 9, 11, 10, 9};

        System.out.println(new IsArrayPostOrderBST().check(array, 0, array.length - 1));

    }
}