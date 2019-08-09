package com.algo.dp.string;

import com.google.common.primitives.Ints;

/**
 * 最长回文子串
 */
public class LHuiwenWrong {


    public void huiwen(String word1) {

        //asdfdsmadfwq
        // sdfds

        //这个第一个错误的思路：
        //dp[i] 截止到第i下标，最大回文字串的长度
        //word[i] = word[i - dp[i]]
        //如果word[i] == word[i - dp[i]]，那么dp[i] = dp[i-1] + 2;
        //如果。。。
        //没法往下继续了

        //思路二
        //dp[i]为包含第i个下标，最大回文字串的长度
        //如果word[i] == word[i - dp[i]],那么dp[i] = dp[i-1] + 2;
        //如果不相等dp[i] = 1;

        int[] dp = new int[word1.length()];
        dp[0] = 1;

        for (int i = 1; i < word1.length(); i++) {
            System.out.println(String.format("i: %d, dp[i-1]: %d, i - dp[i-1] - 1: %d", i, dp[i-1], i - dp[i-1] - 1));
            if (i - dp[i-1] - 1 < 0) {
                dp[i] = 1;
                continue;
            }

            //如果当前的字符word1[1]等于与它对应位置的字符，下标减去dp[i-1];
            //abcbc?,当前的问号的问号位置等于index=1位置
            if (word1.charAt(i) == word1.charAt(i - dp[i-1] - 1)) {
                dp[i] = dp[i - 1] + 2;
            } else {
                //否则，如果不相等，那么当前字符作为一个新的回文字串，值为1；
                dp[i] = 1;
            }
        }

        System.out.print("max:");
        int max = Ints.max(dp);
        System.out.println(max);

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) {
                System.out.println(word1.substring(i - max + 1, i + 1));
            }
        }

    }

    public static void main(String[] args) {

        new LHuiwenWrong().huiwen("asdfdsamadfwq");
        new LHuiwenWrong().huiwen("abacbmnm");

    }
}
