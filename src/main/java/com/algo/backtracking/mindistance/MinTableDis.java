package com.algo.backtracking.mindistance;

import com.algo.common.ArrayUtil;

/**
 * 最小距离
 */
public class MinTableDis {


    public void dp_resolve(int[][] table) {
        //dp[i][j] 从[0][0]走到dp[i][j]的最短路径
        //dp[i][j]=min{dp[i-1][j], dp[i][j-1]};

        int[][] dp = new int[table.length][table[0].length];
        dp[0][0] = table[0][0];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (i == 0 && j == 0)
                    continue;

                if (i == 0) {
                    //dp[0][j] = Math.min(dp[0][j], dp[0][j-1]);
                    dp[0][j] = dp[0][j-1] + table[0][j];
                } else if (j == 0) {
                    //dp[i][0] = Math.min(dp[i-1][0], dp[i][0]);
                    dp[i][0] = dp[i-1][0] + table[i][0];
                } else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + table[i][j];
                }
            }
        }


        ArrayUtil.print2DArray(dp);

    }


    public static void main(String[] args) {

        //二维数组从[0][0]到[3][3]的最短路径
        int[][] table = new int[][]{
                {1, 3, 5, 9},
                {2, 1, 3, 4},
                {5, 2, 6, 7},
                {6, 8, 4, 3},
        };

        System.out.println("原路径表");
        ArrayUtil.print2DArray(table);

        System.out.println("DP");
        new MinTableDis().dp_resolve(table);
    }
}
