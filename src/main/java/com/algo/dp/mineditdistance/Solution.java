package com.algo.dp.mineditdistance;

import com.google.common.primitives.Ints;

/**
 * 最小编辑距离
 */
public class Solution {

    public int minEdit(String word1, String word2){

        int size1 = word1.length();
        int size2 = word2.length();
        int[][] dp = new int[size1][size2];

        for (int i = 0; i < size1; i++){
            dp[i][0] = i;
        }

        for (int j = 0; j < size2; j++) {
            dp[0][j] = j;
        }

        int result = Integer.MAX_VALUE;

        for (int i = 1; i < size1; i++) {
            for (int j = 1; j < size2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Ints.min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1;
                }
                result = Ints.min(dp[i][j], result);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String word1 = "horse";
        String word2 = "ros";

        int min = new Solution().minEdit(word1, word2);
        System.out.println(min);
    }
}
