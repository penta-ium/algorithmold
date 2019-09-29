package com.algo.binarytree.nonerecursive;

import com.algo.binarytree.BinaryTree;
import com.algo.binarytree.Order;

public class InOrder extends Order {

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
