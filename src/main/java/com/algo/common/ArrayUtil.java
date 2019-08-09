package com.algo.common;

import com.algo.common.ListNode;

import java.util.Arrays;

public class ArrayUtil {

    public static void print3DArray(int[][][] dp) {
        System.out.println("----------------------------------------");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
/*                for (int k = 0; k < dp[i][j].length; k++) {
                    System.out.print(dp[i][j][k] + "\t");
                }*/
                System.out.print(Arrays.toString(dp[i][j]));
            }
            System.out.println();
        }
    }

    public static void print2DArray(int[][] dp) {
        System.out.println("----------------------------------------");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }

            System.out.println();
        }
    }

    public static void printListNode(ListNode node) {
        if (node == null)
            return;

        for (ListNode p = node; p != null; p = p.next) {
            System.out.print(p.val + " ");
        }
        System.out.println(" ");
    }

    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
