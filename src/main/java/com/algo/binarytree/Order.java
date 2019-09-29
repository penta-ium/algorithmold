package com.algo.binarytree;

import java.util.Stack;

public class Order {

    public Stack<BinaryTree> stack = new Stack<>();

    /**
     * 递归地把左子节点入栈
     * @param node
     */
    public void push_left(BinaryTree node){
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
