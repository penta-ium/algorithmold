package com.algo.mergeKlist;

import com.algo.common.ArrayUtil;
import com.algo.common.ListNode;

public class MergeKSortedLink {

    public ListNode merge(ListNode[] lists) {

        for (int i = lists.length - 1; i >= 1; i--) {
            ListNode listNode = merge(lists[i - 1], lists[i]);
            lists[i - 1] = listNode;
            lists[i] = null;
        }
        return lists[0];
    }

    public ListNode merge(ListNode node1, ListNode node2) {

        ListNode res = null;
        ListNode p = null;

        for (; node1 != null || node2 != null;) {

            int v1 = node1 == null ? Integer.MAX_VALUE : node1.val;
            int v2 = node2 == null ? Integer.MAX_VALUE : node2.val;

            if (v1 < v2) {
                if (p == null) {
                    p = node1;
                    res = p;
                } else {
                    p.next = node1;
                    p = p.next;
                }
                if (node1 != null)
                    node1 = node1.next;
            } else {
                if (p == null) {
                    p = node2;
                    res = p;
                } else {
                    p.next = node2;
                    p = p.next;
                }
                if (node2 != null)
                    node2 = node2.next;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        MergeKSortedLink mergeKSortedLink =  new MergeKSortedLink();
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
