package com.algo.dp.string;

import com.google.common.primitives.Ints;
import com.algo.common.ArrayUtil;

public class MinEdit {

    public void dp(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();
        //
        int[][] dp = new int[len1 + 1][len2 + 1];

        //初始化
        for (int i = 0; i < len1 + 1; i++) {
            for (int j = 0; j < len2 + 1; j++) {
                if (i == 0)
                    dp[i][j] = j;

                if (j == 0)
                    dp[i][j] = i;
            }
        }

        ArrayUtil.print2DArray(dp);

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                char ch1 = s1.charAt(i - 1);
                char ch2 = s2.charAt(j - 1);

                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Ints.min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
            }
        }

        ArrayUtil.print2DArray(dp);

    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        new MinEdit().dp(s1, s2);
    }
}
