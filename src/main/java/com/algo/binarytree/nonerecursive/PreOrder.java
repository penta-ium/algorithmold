package com.algo.binarytree.nonerecursive;

import com.algo.binarytree.BinaryTree;

import java.util.Stack;

public class PreOrder {

    /**
     * 左子树一股脑的入栈;入栈前visit；
     * 挨个弹出，并判断右子树；
     * 右子树有左子树就一股脑的进栈左子树；
     * @param root
     */
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

    /**
     * 1.先入栈根节点
     * 2.循环地从栈里pop
     * 3.如果有右子树，右子树入栈
     * 4.如果有左子树，左子树入栈
     * @param root
     */
    public void traverse2(BinaryTree root) {
        if (root == null)
            return;

        Stack<BinaryTree> stack = new Stack<>();
        //初始化
        stack.push(root);

        //hasNext
        while(!stack.isEmpty()) {
            BinaryTree node = stack.pop();
            //访问
            BinaryTree.visit(node);

            //next
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }


    public static void main(String[] args) {
        new PreOrder().traverse2(BinaryTree.generate());
    }
}
