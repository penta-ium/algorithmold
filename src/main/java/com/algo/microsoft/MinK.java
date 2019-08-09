package com.algo.microsoft;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小的k个元素
 */
public class MinK {

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 9, 4, 6, 8, 3};
        int k = 4;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? -1 : (o1 < o2 ? 1 : 0);
            }
        });

        for (int i = 0; i < array.length; i++) {
            if (queue.size() < k) {
                queue.add(array[i]);
            }

            if (queue.size() >= k && array[i] < queue.peek()) {
                //大于堆顶，就忽略，小于堆顶，就poll再add
                queue.poll();
                queue.add(array[i]);
            }
        }

        while (queue.peek() != null) {
            System.out.print(queue.poll() + " ");
        }
    }

    /**
     * 通过1减去，变成最大
     * @param value
     * @return
     */
    public static int getVaule(int value) {
        return 1 - value;
    }
}
