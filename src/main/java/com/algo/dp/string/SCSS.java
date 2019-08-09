package com.algo.dp.string;

/**
 * 最短公共超序列
 * 输入：str1 = "abac", str2 = "cab"
 * 输出："cabac"
 * 解释：
 * str1 = "abac" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 的第一个 "c"得到 "abac"。
 * str2 = "cab" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 末尾的 "ac" 得到 "cab"。
 * 最终我们给出的答案是满足上述属性的最短字符串。
 */
public class SCSS {

    public void dp(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();
        //
        int[][] dp = new int[len1 + 1][len2 + 1];
    }

    public static void main(String[] args) {
        String s1 = "abmcf";
        String s2 = "abecb";

        //输入：str1 = "abac", str2 = "cab"
        //输出："cabac"
        //解释：
        //str1 = "abac" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 的第一个 "c"得到 "abac"。
        //str2 = "cab" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 末尾的 "ac" 得到 "cab"。

        /**
         * dp[i][j]
         */

    }
}
