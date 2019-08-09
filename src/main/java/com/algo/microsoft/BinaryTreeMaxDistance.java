package com.algo.microsoft;

import com.algo.common.BSTreeNode;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeMaxDistance {

    Map<BSTreeNode, Integer> map = new HashMap<>();

    public int maxHeight(BSTreeNode root) {

        int left_height = 0;
        int right_height = 0;

        if (root.left != null)
            left_height = maxHeight(root.left);
        if (root.right != null)
            right_height = maxHeight(root.right);

        int max = left_height + right_height + 1;
        System.out.println("root: " + root.val + ", max: " + max);
        map.put(root, max);
        return max;
    }

    public int max(BSTreeNode root) {

        maxHeight(root);

        int l = 0;
        if (root.left != null) {
            l = map.get(root.left);
            max(root.left);
        }

        int r = 0;
        if (root.right != null) {
            r = map.get(root.right);
            max(root.right);
        }

        System.out.println(root.val + "--" + (l + r + 1));



        return -1;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        /**
         *       8
         *     /  \
         *    6   10
         *       /  \
         *      9   11
         *     /
         *    5
         *     \
         *      7
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

        //nodeB.left = nodeD;
        //nodeB.right = nodeE;

        nodeC.left = nodeF;
        nodeC.right = nodeG;

        //
        nodeF.left = nodeD;
        nodeD.right = nodeE;

        //int[] array = new int[]{5, 7, 6, 9, 11, 10, 9};
        new BinaryTreeMaxDistance().max(nodeA);


    }
}