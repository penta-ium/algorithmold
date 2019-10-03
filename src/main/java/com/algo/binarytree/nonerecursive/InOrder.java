package com.algo.binarytree.nonerecursive;

import com.algo.binarytree.BinaryTree;
import com.algo.binarytree.Order;

public class InOrder extends Order {

    /**
     * 1.一股脑(递归)地把左子树入栈;
     * 2.开始pop，pop的时候visit！！！！！！；
     * 3.挨个栈顶元素访问其右子树（因为其左子树肯定已经访问完成）
     *     1
     *    /\
     *   2  5
     *  /\   \
     * 3  4   6
     * 对于这么一颗二叉树，进栈、出栈的顺序为：
     * <-栈底   栈顶->
     * 1                1入栈
     * 1 2              2入栈
     * 1 2 3            3入栈
     * 1 2              3出栈
     * 1                2出栈
     * 1 4              4入栈
     * 1                4出栈
     * Empty            1出栈
     * 5                5入栈
     * Empty            5出栈
     * 6                6入栈
     * Empty            6出栈
     *
     * 按照出栈visit可以得到结果：
     * 3 2 4 1 5 6
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
