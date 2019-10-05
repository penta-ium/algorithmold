package com.algo.binarytree.narytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Layer {

    public List<List<Integer>> levelOrder(Node root) {

        if(root == null)
            return new ArrayList<List<Integer>>();

        List<List<Integer>> list = new ArrayList<List<Integer>>();

        LinkedList<Node> queue = new LinkedList();
        queue.addLast(root);

        while(!queue.isEmpty()){

            int queueSize = queue.size();
            List<Integer> layer = new ArrayList<>();
            while(queueSize-- > 0) {
                Node node = queue.removeFirst();

                layer.add(node.val);

                List<Node> children = node.children;

                if(children != null && children.size() != 0) {
                    for (Node child : children) {
                        queue.addLast(child);
                    }
                }
            }
            list.add(layer);
        }

        System.out.println(list.toString());
        return list;
    }

    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);

        List<Node> sub3 = new ArrayList<>();
        sub3.add(node5);
        sub3.add(node6);
        Node node3 = new Node(3, sub3);

        List<Node> sub1 = new ArrayList<>();
        sub1.add(node3);
        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);
        sub1.add(node2);
        sub1.add(node4);

        Node node1 = new Node(1, sub1);

        new Layer().levelOrder(node1);

    }
}

class Node{
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
