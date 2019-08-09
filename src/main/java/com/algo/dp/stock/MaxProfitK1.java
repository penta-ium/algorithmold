package com.algo.dp.stock;

import com.algo.common.ArrayUtil;

public class MaxProfitK1 {

    /**
     * 最多可以交易k次
     * 手头最多可以持有1股
     *
     * @param prices
     */
    public int resolve(int[] prices, int K) {

        int len = prices.length;
        //dp[i][k][j]
        //第i天、最大交易k次，当前持有或者不持有{0,1}股票的情况下的最大利润
        int[][][] dp = new int[len][K + 1][2];

        //dp
        //dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i])
        //dp[i][k][1] = max(dp[i - 1][k][0], dp[i - 1][k - 1][0] - prices[i])
        //边界
        //i = 0, k = 0, j = 0
        //i = 0, k = 1, j = 0
        //i = 0, k = 0, j = 1
        //i = 0, k = 1, j = 1

        //i = 0 dp[i][k][0] = 0
        //i = 0 dp[i][k][1] = 0
        //k = 0 dp[i][k][0] = 0
        //k = 0 dp[i][k][1] = 不可能

        for (int i = 0; i < len; i++) {
            for (int k = 0; k <= K; k++) {

                if (i == 0 ^ k == 0) {
                    if (i == 0) {
                        dp[0][k][0] = 0;
                        dp[0][k][1] =  -prices[i];
                    }
                    if (k == 0) {
                        dp[i][0][0] = 0;
                        dp[i][0][1] = -prices[i];
                    }
                    continue;
                } else if (i == 0 && k == 0){
                    dp[0][0][0] = 0;
                    dp[0][0][1] = -prices[0];//买+卖 = 一个交易
                    continue;
                }

                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        ArrayUtil.print3DArray(dp);
        return dp[len - 1][K][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 4, 5, 6, 7, 2, 8};
        int K = 2;
        //int[] prices = new int[]{7, 6, 5, 4, 3, 2};

        ArrayUtil.printArray(prices);

        int maxProfit = new MaxProfitK1().resolve(prices, 2);
        System.out.println("最大利润：" + maxProfit);

    }
}
