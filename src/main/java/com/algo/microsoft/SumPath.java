package com.algo.microsoft;

import com.algo.common.BSTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 从根节点到某一节点的路径等于指定的值
 */
public class SumPath {

    int VALUE = 22;

    public void trace(BSTreeNode root, int sum, String temp, List<String> result) {

        if (root == null) {
            return;
        }

        sum += root.val;
        temp += " " + root.val + " ";

        if (sum == VALUE && (root.left == null && root.right == null)) {
            result.add(temp);
            return;
        }
        if (sum > VALUE && (root.left != null || root.right != null))
            return;

        trace(root.left, sum, temp, result);
        trace(root.right, sum, temp, result);

    }

    public static void main(String[] args) {
        BSTreeNode node10 = new BSTreeNode(10);
        BSTreeNode node5 = new BSTreeNode(5);
        BSTreeNode node12 = new BSTreeNode(12);
        BSTreeNode node4 = new BSTreeNode(4);
        BSTreeNode node7 = new BSTreeNode(7);

        node5.left = node4;
        node5.right = node7;

        node10.left = node5;
        node10.right = node12;


        List<String> result = new ArrayList<>();

        new SumPath().trace(node10, 0, "", result);

        System.out.println(result);
    }
}
