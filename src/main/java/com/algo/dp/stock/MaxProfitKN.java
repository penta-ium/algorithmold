package com.algo.dp.stock;

import com.google.common.primitives.Ints;

public class MaxProfitKN {

    /**
     * 最多可以交易K次
     * 手头可以持有N股
     *
     * @param prices
     */
    public int resolve(int[] prices, int K, int N) {

        //股票最多交易次数K（每次交易=买入+卖出）
        //手头最多持有股票数据为N
        int len = prices.length;
        int[][][] dp = new int[len][K + 1][N];

        int days = prices.length;
        for (int i = 0; i < days; i++) {
            for (int k = 0; k < K + 1; k++) {
                for (int n = 1; n <= N; n++) {

                    //边界
                    //... ...

                    dp[i][k][n] = Ints.max(dp[i - 1][k][n], //第i-1天、最大交易次数k不变、持股数目不变（不买不卖）
                            dp[i - 1][k][n + 1] + prices[i], //第i-1天、最大交易数k不变（只卖未买，k不变）、持股数减少1（卖掉1股）
                            dp[i - 1][k - 1][n - 1] - prices[i]);//第i-1天、最大交易数为k-1、持股数加1（买入一股）
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] prices = new int[]{3, 4, 5, 6, 7, 2, 8};
        int K = 3;
        int N = 2;

        int maxProfit = new MaxProfitKN().resolve(prices, K, N);
        System.out.println(maxProfit);

    }
}
