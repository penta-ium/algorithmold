package com.algo.dp.stock;

public class MaxProfitCooldown {

    /**
     * 最多可以交易1次
     * 手头最多可以持有1股
     *
     * @param prices
     */
    public int resolve(int[] prices) {

        return -1;
    }

    public static void main(String[] args) {
        //int[] prices = new int[]{3, 4, 5, 6, 7, 2, 8};
        int[] prices = new int[]{7, 6, 5, 4, 3, 2};

        int maxProfit = new MaxProfitCooldown().resolve(prices);
        System.out.println("最大利润：" + maxProfit);

    }
}
