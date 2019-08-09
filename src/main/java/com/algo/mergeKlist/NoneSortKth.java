package com.algo.mergeKlist;

import java.util.PriorityQueue;

/**
 * 未排序的数组求第k大（小）
 */
public class NoneSortKth {

    public int getKth(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for (int i = 0; i < nums.length; i++) {

            if (queue.size() >= k) {
            //if (queue.size() >= (nums.length - k)) {
                queue.poll();
            }
            queue.add(nums[i]);
        }

        return queue.peek();
    }

    public static void main(String[] args) {

        System.out.println( new Object());
        System.out.println( new Object());
        System.out.println( new Object());

        int[] nums = new int[]{ 8, 9, 10, 5, 2, 3, 7};
        int k = 3;

        System.out.println(new NoneSortKth().getKth(nums, k));
    }
}
