package com.algo.backtracking.maxproduct;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大乘积
 */
public class MaxProduct {

    static int[] nums = new int[]{2, 3, 1/2, 4, 2, 3, 1/11, 3, 6};

    public static void main(String[] args) {

        //dp[i]表示(0->i)所有的子乘积中，最大的值；
        //那么最终结果result = max{dp[0], dp[1], dp[2]......dp[n-1]};
        //状态转移
        //a[i] > 1 dp[i] = dp[i-1]*a[i]
        //a[i] < 1 dp[i] = dp[i-1]
        // 边界i=0,i = a[0]

        //递归法：
        List<Integer> result = new ArrayList<>();
        recursive(0, 1 ,result);

        System.out.println(result.toString());

    }

    public static void recursive(int index, int subs, List<Integer> result) {

        int v = nums[index];

        if (subs * v >= subs ) {
            if (index + 1 < nums.length) {
                recursive(index + 1, subs * v, result);
            } else {
                result.add(subs * v);
            }
        }
        if (subs * v < subs) {
            result.add(subs);
            if ( index + 1 < nums.length) {
                recursive(index + 1, 1, result);
            }
        }
    }

}
