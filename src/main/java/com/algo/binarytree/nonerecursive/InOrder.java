package com.algo.binarytree.nonerecursive;

import com.algo.binarytree.BinaryTree;
import com.algo.binarytree.Order;

public class InOrder extends Order {

    /**
     * 1.递归地把左子树入栈
     * 2.开始pop
     * 3.挨个栈顶元素访问其右子树（因为其左子树肯定已经访问完成）
     * @param root
     */
    public void traverse(BinaryTree root) {

        if (root == null)
            return;


        //初始化
        push_left(root);

        //hasNext
        while (!stack.isEmpty()) {
            BinaryTree pop = stack.pop();
            //visit
            BinaryTree.visit(pop);

            //next
            BinaryTree node = pop.right;
            push_left(node);
        }
    }


    public static void main(String[] args) {
        new InOrder().traverse(BinaryTree.generate());
    }
}
