package com.algo.dp.string;

import com.google.common.primitives.Ints;
import com.algo.common.ArrayUtil;

import java.util.HashMap;
import java.util.Map;

public class Zuidagonggongzixulie {


    public void parse(String s1, String s2) {

        Map<String, String> map = new HashMap<>();
        int len1 = s1.length();
        int len2 = s2.length();
        //dp[i][j] 表示
        //s1.sub(0, i)、s2.sub(0, j)的最长公共子序列长度(不一定包含第i和第j个）
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                char ch1 = s1.charAt(i - 1);
                char ch2 = s2.charAt(j - 1);

                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else{
                    dp[i][j] = Ints.max(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        ArrayUtil.print2DArray(dp);
    }

    public static void main(String[] args) {
        new Zuidagonggongzixulie().parse("abecd", "axbmcfd");
    }
}
