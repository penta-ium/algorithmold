package com.algo.dp.string;

import com.algo.common.ArrayUtil;

/**
 * 最短公共超序列
 */
public class ZuiduanGGSupersequence {

    public void dp(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();

        //dp[i][j]表示从s1的前i个字符字串到s2的前j个字符字串的最短公共序列长度
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1 + 1; i++) {
            for (int j = 0; j < len2 + 1; j++) {

                if (i == 0) {
                    dp[i][j] = j;
                }

                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {

                char ch1 = s1.charAt(i - 1);
                char ch2 = s2.charAt(j - 1);

                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        //TimeUnit.MINUTES.sleep(1);

        ArrayUtil.print2DArray(dp);

    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "bnmcd";
        new ZuiduanGGSupersequence().dp(s1, s2);
    }
}
