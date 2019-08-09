package com.algo.microsoft;

import java.util.Stack;

public class CheckSingleLinkedListJoin {

    /**
     * 根据栈来处理
     * 如果空间复杂度没有要求，可以使用该方法
     * @param h1
     * @param h2
     * @return
     */
    public boolean check1(SingleLinkedListNode h1, SingleLinkedListNode h2) {

        SingleLinkedListNode hh1 = h1;
        SingleLinkedListNode hh2 = h2;

        Stack<SingleLinkedListNode> s1 = new Stack<>();
        Stack<SingleLinkedListNode> s2 = new Stack<>();
        while (hh1 != null) {
            s1.push(hh1);
            hh1 = hh1.next;
        }

        while (hh2 != null) {
            s2.push(hh2);
            hh2 = hh2.next;
        }

        if (s1.peek() != s2.peek())
            return false;

        SingleLinkedListNode joinNode = null;
        while (s1.peek() == s2.peek()) {
            joinNode = s1.pop();
            s2.pop();
        }

        System.out.println(joinNode == null ? null : joinNode.val);

        return true;
    }

    /**
     * 通过长度判断：
     * node1：l1
     * node2：l2
     * 获取长度的过程也可以获得链表最后一个元素，不相等则return false
     * 假如l1 > l2
     * 从node1的第（l1-l2）个元素，从node2的第0个元素，开始比较，第一个相等的就是相交的那个；
     * @param node1
     * @param node2
     * @return
     */
    public boolean check2(SingleLinkedListNode node1, SingleLinkedListNode node2) {


        return false;
    }

    public static void main(String[] args) {
        SingleLinkedListNode node0 = new SingleLinkedListNode(0);
        SingleLinkedListNode node1 = new SingleLinkedListNode(1);
        SingleLinkedListNode node2= new SingleLinkedListNode(2);
        SingleLinkedListNode node3 = new SingleLinkedListNode(3);
        SingleLinkedListNode node4 = new SingleLinkedListNode(4);
        SingleLinkedListNode node5 = new SingleLinkedListNode(5);
        SingleLinkedListNode node6 = new SingleLinkedListNode(6);

        node0.next = node1;
        node1.next =  node2;
        node2.next = node5;

        node3.next = node4;
        node4.next = node5;

        node5.next = node6;

        System.out.println(new CheckSingleLinkedListJoin().check1(node0, node3));
    }
}
