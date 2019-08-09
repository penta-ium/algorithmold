package com.algo.dp.string;

import com.algo.common.ArrayUtil;

public class ZuiGGzc {

    public void resolve(String s1, String s2) {

        //dp[i][j] s1[0,i]与s2[0,j]的最大公共字串
        //包含s1[i]和s2[j]的子串

        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 ) {
                    dp[i][j] = 0;
                }
                if (j == 0) {
                    dp[i][j] = 0;
                }
            }
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {

                char ch1 = s1.charAt(i - 1);
                char ch2 = s2.charAt(j - 1);

                if (ch1 == ch2) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        ArrayUtil.print2DArray(dp);
    }

    public static void main(String[] args) {

        String s1 = "xabcde";
        String s2 = "yxbabc";

        new ZuiGGzc().resolve(s1, s2);
    }
}
