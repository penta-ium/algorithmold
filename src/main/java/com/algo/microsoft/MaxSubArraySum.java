package com.algo.microsoft;

import com.algo.common.ArrayUtil;

/**
 * 求和最大的连续子数组
 */
public class MaxSubArraySum {

    public void dp(int[] array) {

        int[] dp = new int[array.length];
        dp[0] = array[0];

        //dp[i] 为包含第i个元素的子数组的和的最大值
        //dp[i] = array[i] ,dp[i-1]<0
        //dp[i] = dp[i-1] + array[i],dp[i-1]>0

        for (int i = 1; i < array.length; i++) {
            if (dp[i - 1] >= 0)
                dp[i] = dp[i - 1] + array[i];
            else
                dp[i] = array[i];
        }

        ArrayUtil.printArray(dp);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, -2, 3, 10, -4, 7, 2};

        new MaxSubArraySum().dp(array);

    }
}
