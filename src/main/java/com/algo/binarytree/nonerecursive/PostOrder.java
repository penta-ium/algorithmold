package com.algo.binarytree.nonerecursive;

import com.algo.binarytree.BinaryTree;

import java.util.HashMap;
import java.util.Map;
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

    /**
     * 使用课本中标准的方法：
     * 给每一个入栈的节点设置一个标志位 flag
     * 当节点第一次入栈时（位于栈顶），flag=0；
     * 当节点的右子树访问完成后（此时节点又位于栈顶），flag=1；
     * @param root
     */
    public void traverse2(BinaryTree root){

        if (root == null)
            return;

        Stack<BinaryTree> stack = new Stack<>();
        Map<BinaryTree, Integer> flags = new HashMap<>();

        //初始化
        while(root != null) {
            stack.push(root);
            flags.put(root, 0);
            root = root.left;
        }

        while(!stack.isEmpty()){
            BinaryTree node = stack.peek();
            //右子树为空，或者右子树被访问过
            if (node.right == null || (flags.containsKey(node) && flags.get(node) == 1)){
                stack.pop();
                BinaryTree.visit(node);
            } else{
                //右子树不为空并且右子树没有被访问过

                //设置右子树被访问过
                flags.put(node, 1);
                BinaryTree leftNode = node.right;
                while(leftNode != null){
                    stack.push(leftNode);
                    flags.put(leftNode, 0);
                    leftNode = leftNode.left;
                }
            }
        }

    }

    /**
     * 使用最经典的办法，左右子树分别入栈，然后弹出后再处理
     * @param root
     */
    public void traverse3(BinaryTree root){
        if (root == null)
            return;

        Stack<BinaryTree> stack = new Stack<>();
        Map<BinaryTree, Integer> flags = new HashMap<>();


        //init
        flags.put(root, 0);
        stack.push(root);

        //hasNext
        while(!stack.isEmpty()){
            BinaryTree node = stack.peek();

            //要用 == 1，不要用== new Integer(1)
            //visit
            if(node.right == null || (flags.containsKey(node) && flags.get(node) == 1)) {
                BinaryTree.visit(node);
                stack.pop();
            } else{
                //next
                if (node.right != null) {
                    flags.put(node, 1);
                    stack.push(node.right);
                }

                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }

    }

    public static void main(String[] args) {
        new PostOrder().traverse3(BinaryTree.generate());
        System.out.println();
        System.out.println(new Integer(1) == null);
    }
}
