package com.algo.dp.string;

import com.algo.common.ArrayUtil;

public class LHuiwen {


    public String resolve(String s) {

        if (s == null || "".equals(s))
            return null;

        int n = s.length();

        char[] chars = s.toCharArray();

        //dp[][] 从i到j是否是回文的，回文填1，否则是0
        int[][] dp = new int[n][n];
        //如果chars[i]==chars[j]，那么dp[i][j]=dp[i+1]{j-1};
        //否则dp[i][j]=0;
        //注意的地方：需要由i+1推导出i，由j-1推导出j；


        //循环中j >= i
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }

                if (chars[i] == chars[j]) {
                    if (j == i + 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        ArrayUtil.print2DArray(dp);

        return null;
    }

    public static void main(String[] args) {

        String s = "abab";

        new LHuiwen().resolve(s);
    }
}
