package com.algo.binarytree.nonerecursive;

import com.algo.binarytree.BinaryTree;

import java.util.Stack;

/**
 * 先序也有两种思路：一股脑的把左子树入栈；挨个入栈左右子树；
 * 两种思路体现的也是类似于深度优先、广度优先的不同思想；
 */
public class PreOrder {

    /**
     * 1.左子树一股脑的入栈;入栈前visit！！！！！！；
     * 2.挨个弹出;
     * 3.判断右子树是否为空以及右子树是否有其左子树:
     *   右子树有左子树就将其作为“root”处理：一股脑的进栈左子树,然后挨个弹出；
     *
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
     * 1 4              4入栈（2出栈后，判断2有右子树）
     * 1 5              5入栈
     * 1 5 6            6入栈
     * Empty            1出栈
     *
     * 入栈之前visit节点，即可得到先序遍历结果（图中标为入栈的操作）：
     * 1 2 3 4 5 6
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
     * 2.循环地从栈里pop，pop的时候visit！！！！！！！；
     * 3.如果有右子树，右子树入栈
     * 4.如果有左子树，左子树入栈
     *     1
     *    /\
     *   2  5
     *  /\   \
     * 3  4   6
     * 还是相同于上面的一颗树，入栈出栈顺序为：
     * <-栈底   栈顶->
     * 1                1入栈
     * Empty            1出栈
     * 1 5 2            5 2入栈（5作为右子树、2作为左子树）
     * 1 5              2出栈
     * 1 5 4 3          4 3入栈（4作为右子树，3作为左子树）
     * 1 5 4            3出栈
     * 1 5              4出栈
     * 1                5出栈
     * 1 6              6入栈（5的左子树为空，6作为右子树）
     * Empty            6出栈
     *
     * 根据出栈的时候visit，得到访问顺序为：
     * 1 2 3 4 5 6
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
