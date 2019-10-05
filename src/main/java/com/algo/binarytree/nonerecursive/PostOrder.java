package com.algo.binarytree.nonerecursive;

import com.algo.binarytree.BinaryTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 第一个思路traverse：
 * 比较巧妙，把先序遍历的结果暂存，然后再输出，就可以得到后续遍历的结果；
 * 第二个思路traverse2：
 * 二、三两种思路整体都是使用了增加一个标志位，来标识父节点是否可以弹出栈visit；
 * 不同点是思路二是一种深度优先的思想，思路三是一种广度优先的思想；
 * 左子树一股脑的入栈，然后在出栈的时候只判断右子树是否为空或者右子树已经处理完成；
 * 第三个思路traverse3：
 * 入栈根节点，然后分别入栈左子树和右子树，这时候需要分别判断左右子树，逻辑上复杂一点；
 *
 * 广度优先用途更广泛，可以用在N叉树；
 */
public class PostOrder {

    /**
     * 1.按照“先序顺序”遍历
     * 2.在第1步遍历的时候，按照根、左、右的顺序，push到stack2里
     * 3.遍历stack2，就可以得到按照后续遍历的结果
     *     1
     *    /\
     *   2  5
     *  /\   \
     * 3  4   6
     * 对于这么一颗二叉树，进栈、出栈的顺序为：
     * <-底--s1--栈->        |<-底--s2--栈->
     * 1         1入栈       |Empty
     * Empty     1出栈       |1           1入栈
     * 2 5       2 5入栈     |1
     * 2         5出栈       |1 5         5入栈
     * 2 6       6入栈       |1 5
     * 2         6出栈       |1 5 6       6入栈
     * Empty     2出栈       |1 5 6 2     2入栈
     * 3         3入栈       |1 5 6 2
     * 3 4       4入栈       |1 5 6 2
     * 3         4出栈       |1 5 6 2 4   4入栈
     * Empty     3出栈       |1 5 6 2 4 3 3入栈
     *
     * 得到stack2的顺序为：
     * 1 5 6 2 4 3
     * 依次对stack2的元素出栈，得到最终后续遍历的结果：
     * 3 4 2 6 5 1
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
                    leftNode = leftNode.left;
                }
            }
        }

    }

    /**
     * 使用最经典的办法，左右子树分别入栈，然后弹出后再处理
     *
     *     1
     *    /\
     *   2  5
     *  /\   \
     * 3  4   6
     * 对于这么一颗二叉树，进栈、出栈的顺序为：
     * <-栈底   栈顶->            |map:
     * 1                1入栈     |{}
     * 1 5 2            5 2入栈   |{1:1}
     * 1 5 2 4 3        4 3入栈   |{1:1, 2:1}
     * 1 5 2 4          3出栈     |{1:1, 2:1}--因为3没有right
     * 1 5 2            4出栈     |{1:1, 2:1}--因为4没有right
     * 1 5              2出栈     |{1:1, 2:1}--因为2的flag为1(右子树4入栈时设置为1，右子树4访问完毕)
     * 1 5 6            6入栈     |{1:1, 2:1, 5:1}
     * 1 5              6出栈     |{1:1, 2:1, 5:1}--因为6没有right
     * 1                5出栈     |{1:1, 2:1, 5:1}--因为5的flag为1（右子树6入栈时设置为1，右子树6访问完毕）
     * Empty            1出栈     |{1:1, 2:1, 5:1}--因为1的flag为1（右子树5入栈时设置为1，右子树5访问完毕）
     *
     * 得到顺序为：
     * 3 4 2 6 5 1
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
            if((node.right == null && node.left == null)
                    || (flags.containsKey(node) && flags.get(node) == 1)) {
                BinaryTree.visit(node);
                stack.pop();
            } else{
                //next
                flags.put(node, 1);
                if (node.right != null) {
                    stack.push(node.right);
                }

                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }

    }

    public static void main(String[] args) {
        new PostOrder().traverse3(BinaryTree.generateSpe());
        //new PostOrder().traverse3(BinaryTree.generate());
        System.out.println();
        System.out.println(new Integer(1) == null);
    }
}
