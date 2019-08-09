package com.algo.dp.stock;

import com.algo.common.ArrayUtil;

public class MaxProfit11 {

    /**
     * 最多可以交易1次
     * 手头最多可以持有1股
     *
     * @param prices
     */
    public int resolve(int[] prices) {
        int number = prices.length;
        //dp[i][j][k] int[][][] dp = new int[number][2][];
        //dp[i][0][0]第i天、最大交易0次、当前不持有股票的情况下的最大利润 = 0
        //dp[i][1][0]第i天、最大交易1次、当前不持有股票的情况下的最大利润
        //dp[i][0][1]第i天、最大交易0次、当前持有股票的情况下的最大利润 = 不可能 Integer.MIN_VALUE
        //dp[i][1][1]第i天、最大交易1次、当前持有股票的情况下的最大利润

        //dp[i][0][0] = max(dp[i - 1][0][0], dp[i - 1][0][1] + prices[i])
        //dp[i][1][0] = dp[i - 1][1][0]
        //dp[i][0][1] = Integer.MIN_VALUE（不可能）
        //dp[i][1][1] = max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i])!!!! 不正确，应该为
        //dp[i][1][1] = max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i])//必须在0的基础上交易，因为最大只允许交易1次

        //可以把[j]的维度省略掉
        //dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
        //dp[i][1] = max(dp[i][1], dp[i - 1][0] - prices[i])
        int[][] dp = new int[number][2];
        for (int i = 0; i < number; i++) {

            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = - prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
        }

        ArrayUtil.print2DArray(dp);
        return dp[number - 1][0];
    }

    public static void main(String[] args) {
        //int[] prices = new int[]{3, 4, 5, 6, 7, 2, 8};
        int[] prices = new int[]{7, 6, 5, 4, 3, 2};

        int maxProfit = new MaxProfit11().resolve(prices);
        System.out.println("最大利润：" + maxProfit);

    }
}
