package com.algo.binarytree.nonerecursive;

import com.algo.binarytree.BinaryTree;

import java.util.Stack;

public class PostOrder {

    /**
     * 1.按照“先序顺序”遍历
     * 2.在第1步遍历的时候，按照根、左、右的顺序，push到stack2里
     * 3.遍历stack2，就可以得到按照后续遍历的结果
     * @param root
     */
    public void traverse(BinaryTree root) {
        if (root == null)
            return;

        Stack<BinaryTree> stack1 = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();

        //初始化
        stack1.push(root);
        while(!stack1.isEmpty()) {
            BinaryTree node = stack1.pop();
            stack2.push(node);

            if (node.left != null) {
                stack1.push(node.left);
            }

            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        //hasNext
        while(!stack2.isEmpty()) {
            BinaryTree node = stack2.peek();
            //访问
            BinaryTree.visit(node);

            //next
            stack2.pop();
        }
    }

    public void traverse2(BinaryTree root){

        if (root == null)
            return;


    }

    public static void main(String[] args) {
        new PostOrder().traverse(BinaryTree.generate());
    }
}
