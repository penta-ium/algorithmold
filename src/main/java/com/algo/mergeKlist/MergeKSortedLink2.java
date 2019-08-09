package com.algo.mergeKlist;

import com.algo.common.ArrayUtil;
import com.algo.common.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLink2 {

    public ListNode merge(ListNode[] lists) {

        ListNode result = null;
        ListNode p = null;

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for (ListNode node : lists) {
            for (; node != null; node = node.next) {
                queue.add(node.val);
            }
        }

        p = new ListNode(queue.poll());
        result = p;

        while(queue.peek() != null) {
            Integer v = queue.poll();
            ListNode t = new ListNode(v);
            p.next = t;
            p = p.next;
        }
        return result;
    }


    public static void main(String[] args) {

        MergeKSortedLink2 mergeKSortedLink =  new MergeKSortedLink2();
        int total = 5 + 3 + 3;
        ListNode node1 = mergeKSortedLink.genLinkList(1, 3, 6, 8, 9);
        ListNode node2 = mergeKSortedLink.genLinkList(2, 4, 5);
        ListNode node3 = mergeKSortedLink.genLinkList(1, 7, 9);

        ListNode[] lists = new ListNode[]{node1, node2, node3};
        ArrayUtil.printListNode(mergeKSortedLink.merge(lists));
    }

    public ListNode genLinkList(Integer... nums) {

        ListNode node = new ListNode(nums[0]);
        ListNode p = node;
        for (int i = 1; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }

        return p;
    }
}
