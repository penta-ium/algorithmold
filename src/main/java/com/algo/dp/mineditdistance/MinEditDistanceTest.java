package com.algo.dp.mineditdistance;

import com.google.common.primitives.Ints;

/**
 * 求解从字符串word1编辑到word2的次数（距离）
 * 也就是插入、删除、替换的次数
 * 比如：
 * 从if编辑到iff需要一次插入f，那么编辑距离为1；
 * 从if编辑到ie需要一次替换f为e，那么编辑距离也为1；
 * 。。。
 */
public class MinEditDistanceTest {

    public int dp(String word1, String word2) {

        int len1 = word1.length();
        int len2 = word2.length();

        //dp[i][j]表示从word1的一个子串，编辑到word2的一个子串的编辑距离；
        //i、j表示子串的长度，如果为0表示空的子串，如果i == len1,j == len2，那么表示完整长度的子串
        int[][] dp = new int[len1 + 1][len2 + 1];

        //动态转移方程
        //如果word1[i] == word2[j]，那么dp[i][j] = dp[i - 1][j - 1];
        //如果word1[i] != word2[j]:
        //那么dp[i][j]可以在dp[i - 1][j]的基础上执行一个额外的删除操作得到；
        //也可以在dp[i][j - 1]的基础上执行一个额外的插入操作得到；
        //也可以在dp[i - 1][j - 1]基础上执行一个额外的替换操作得到；
        /**
         * 举例说明：
         * 求从horse编辑到ros的编辑距离x，右如下情况：
         * 当前已经有了从hors到ros的编辑距离y1，那么x = y1 + 1，即在horse的基础上，删除最后的e，得到ros；
         * 当前已经有了从horse到ro的编辑距离y2，那么x = y2 + 1，即在horse的基础上，插入一个s，得到ros；
         * 当前已经有了从hors到ro的编辑距离y3，那么x = y3 + 1，即在horse的基础上，替换最后e为s，得到ros；
         */

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++)
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    dp[i][j] = Ints.min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }

        return dp[len1][len2];
    }

    public static void main(String[] args) {
        //String word1 = "horse";
        //String word2 = "ros";
        String word1 = "iff";
        String word2 = "i";

        System.out.println(new MinEditDistanceTest().dp(word1, word2));


    }

}
