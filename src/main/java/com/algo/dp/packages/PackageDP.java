package com.algo.dp.packages;

import com.algo.common.ArrayUtil;

/**
 * 给定n种物品和一个背包。物品i的重量是wi，其价值为vi，背包的容量为C。应该如何选择装入背包中的物品，使得装入背包中物品的总价值最大？
 */
public class PackageDP {

    //背包重量
    static int[] W = new int[]{3, 5, 1, 7, 6, 4};
    //背包价值
    static int[] V = new int[]{9, 4, 1, 5, 2, 8};
    //总容量C
    static int C = 15;

    public static void main(String[] args) {

        //dp[i][j]
        //被背包容量为i存放前j个物品的最大价值
        int[][] dp = new int[C + 1][W.length + 1];

        //dp[i][j]
        //W[j} > i
        //dp[i][j] = dp[i][j - 1];
        //dp[i][j] = max(dp[i][j - 1], V[j - 1] + dp[i - W[i - 1]][j - 1])

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= C; i++) {
            for (int j = 1; j <= W.length; j++) {
                if (W[j - 1] > i)
                    dp[i][j] = dp[i][j - 1];
                else {
                    //不包括当前物品
                    int v1 = dp[i][j - 1];
                    int v2 = V[j - 1] + dp[i - W[j - 1]][j - 1];
                    dp[i][j] = Math.max(v1, v2);
                }
            }
        }

        ArrayUtil.print2DArray(dp);
        System.out.println(dp[dp.length - 1][dp[0].length - 1]);
    }
}
