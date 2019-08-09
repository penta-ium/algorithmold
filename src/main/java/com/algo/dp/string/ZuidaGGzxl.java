package com.algo.dp.string;

import com.algo.common.ArrayUtil;

public class ZuidaGGzxl {

    public void resolve(String s1, String s2) {

        //abcd bmmcfd.
        //dp[i][j]:s1的子串[0,i]与s2的子串[0,j]的公共子序列长度


        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0)
                    dp[i][j] = 0;

                if (j == 0)
                    dp[i][j] = 0;
            }
        }

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                char ch1 = s1.charAt(i - 1);
                char ch2 = s2.charAt(j - 1);

                if (ch1 == ch2) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        ArrayUtil.print2DArray(dp);
    }

    public static void main(String[] args) {
        String s1 = "TGGGATCGACTT";
        String s2 = "AGCCTACGTA";

        new ZuidaGGzxl().resolve(s1, s2);

    }
}
