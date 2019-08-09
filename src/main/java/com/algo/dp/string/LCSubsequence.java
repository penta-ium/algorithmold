package com.algo.dp.string;

import com.algo.common.ArrayUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 最大公共子序列
 */
public class LCSubsequence {

    public String zixulie(String word1, String word2) {

        System.out.println(String.format("%s\n%s.", word1, word2));

        int l1 = word1.length();
        int l2 = word2.length();

        //dp[i][j] 为  到[i][j]位置，最大公共子序列长度
        //dp[i][j]为word1的子串sub(0, i)、word2的子串sub(0, j)，的最大公共子序列长度--公共子序列不一定包含word1[i]或者word2[j]
        //如果word1[i] == word2[j]，那么dp[i][j] = dp[i-1][j-1] + 1
        //否则dp[i][j] == dp[i-1][j-1]???????
        //否则dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]);--这里包含之前的结果

        int[][] dp = new int[l1 + 1][l2 + 1];
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
               if (i ==0 || j == 0) {
                   dp[i][j] = 0;
                   map.put(getKey(i, j), "");
               }
            }
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                char ch1 = word1.charAt(i-1);
                char ch2 = word2.charAt(j-1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i -1][j-1] +1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

                }
            }
        }

        ArrayUtil.print2DArray(dp);
        //shortestCommonSupersequnce
        String scs = "";
        //longestCommonSubsequence
        String lcs = "";

        int i = dp.length - 1, j = dp[0].length - 1;

        while (i >= 1 || j >= 1) {

            if (i < 1 ^ j < 1) {
                //System.out.println(i + "-" + j);
                char ch = i < 1 ? word2.charAt(j-1) : word1.charAt(i-1);
                if (i < 1) {
                    j--;
                } else {
                    i--;
                }
                scs = ch + scs;
                continue;
            }

            char ch1 = word1.charAt(i - 1);
            char ch2 = word2.charAt(j - 1);
            if (ch1 == ch2) {
                scs = ch1 + scs;
                lcs = ch1 + lcs;
                i--;
                j--;
            }else {
                if (dp[i-1][j] >= dp[i][j-1]) {
                    scs = ch1 + scs;
                    i--;
                } else {
                    scs = ch2 + scs;
                    j--;
                }
            }
        }

        System.out.println("最短公共超序列; " + scs);
        System.out.println("最长公共子序列: " + lcs);

        return scs;
    }

    public String getKey(int i, int j) {
        return i + ":" + j;
    }

    public static void main(String[] args) {

        String s1 = "ABCBDAB";
        String s2 = "BDCABA";
        new LCSubsequence().zixulie(s1, s2);
    }

}
