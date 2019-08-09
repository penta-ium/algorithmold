package com.algo.dp.string;

/**
 * 最大公共字串
 */
public class LCSubstring {


    public void substring(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        //abcdx     mbcefbcdg
        //dp[i][j] 为 包含word[i]、word2[j]在内的word1word2的子串，的最大公共字串长度
        //1、word[i] == word2[j] ==> dp[i][j] = dp[i-1][j-1] + 1
        //2、word[i] != word2[j] ==> max{dp[i-1][j], dp[i][j-1], ... ... }xxxxxxxxxxxxx
        //2、word[i] != word2[j] ==> 0;如果不相等，那么包含word1[i]、word2[j]的word1和word2的两个子串的公共长度就为0；

        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                char ch1 = word1.charAt(i);
                char ch2 = word2.charAt(j);

                if (ch1 == ch2) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        //print(dp);

        int max_i = 0;
        int max_j = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j] > dp[max_i][max_j]) {
                    max_i = i;
                    max_j = j;
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


        int v  = dp[max_i][max_j];
        System.out.println(max_i + ", " + max_j + ", " + v);

        System.out.println(word1.substring(max_i - v + 1, max_i + 1));
        System.out.println(word2.substring(max_j - v + 1, max_j + 1));


    }

    public void print(int[][] dp) {
        int max_i = 0;
        int max_j = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j] > dp[max_i][max_j]) {
                    max_i = i;
                    max_j = j;
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(max_i + ", " + max_j + ", " + dp[max_i][max_j]);
    }
    public static void main(String[] args) {

        String word1 = "abcddx";
        String word2 = "mbcefbcddag";

        new LCSubstring().substring(word1, word2);

    }
}
