package com.algo.dp.kingandgold;

import com.algo.common.ArrayUtil;

/**
 * 国王和金矿
 * DP
 */
public class KingAndGoldDP {

    /**
     * F(n,w) = 0    (n<=1, w<p[0]);
     * n为剩余1个金矿，当前的矿工数w小于开采这1个金矿所需要的矿工数；
     * 那么值为0；
     * <p>
     * F(n,w) = g[0]     (n==1, w>=p[0]);
     * n为剩余1个金矿，当前的矿工数w大于开采这1个金矿所需要的矿工数；
     * 那么值为这个金矿的金储量;
     * <p>
     * #F(n,w) = F(n-1,w)    (n>1, w<p[n-1]);
     * <p>
     * F(n,w) = max(F(n-1,w),  F(n-1,w-p[n-1])+g[n-1])    (n>1, w>=p[n-1]);
     * w个人，开采n座金矿，所能开采出来的黄金总量
     * =max(
     * w个人开采n-1座金矿，所能开采的黄金量;
     * p[n-1]个人开采第n座金矿+ (w-p[n-1])个人开采n-1座金矿;
     * );
     *
     * @param args
     */

    //工人数
    static int W = 10;
    //金矿数量
    static int N = 5;
    //金矿的黄金量
    static int[] G = new int[]{400, 500, 200, 300, 350};
    //金矿的用工量
    static int[] P = new int[]{5, 5, 3, 4, 3};

    //计算次数
    public static void main(String[] args) {

        //dp[i][j]i个人挖j(实际上是从1...j)个金矿，所能挖出来的最大黄金量

        int[][] dp = new int[W + 1][N + 1];

        for (int i = 0; i < W + 1; i++)
            dp[i][0] = 0;

        for (int j = 0; j < N + 1; j++)
            dp[0][j] = 0;

        for (int i = 1; i <= W; i++) {
            for (int j = 1; j <= N; j++) {
                //dp[i][j] = ;
                //第j个金矿的用工量大于当前的工人数
                if (P[j - 1] > i)
                    dp[i][j] = dp[i][j - 1];
                else {
                    //不包含第j座金矿
                    //包含第j座金矿
                    dp[i][j] = Math.max(dp[i][j - 1], G[j - 1] + dp[i - P[j - 1]][j - 1]);
                }
            }
        }

        ArrayUtil.print2DArray(dp);

    }
}
