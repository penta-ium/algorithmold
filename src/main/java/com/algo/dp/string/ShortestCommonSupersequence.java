package com.algo.dp.string;

import com.algo.common.ArrayUtil;

public class ShortestCommonSupersequence {

    public String resolve(String s1, String s2) {

        // find LCS.
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                }else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        ArrayUtil.print2DArray(dp);

        // Build result.
        StringBuilder sb = new StringBuilder();
        int i = m - 1, j = n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0 ^ j < 0) { // only one string reaches left end.
                char c = i < 0 ? s2.charAt(j--) : s1.charAt(i--); // remaining chars in the other string.
                sb.append(c);
            }else if (s1.charAt(i) == s2.charAt(j)) { // common char in LCS.
                sb.append(s1.charAt(i)); // append the char of either s1 or s2.
                --i; --j;
            }else { // the char is not in LCS.
                //System.out.println("dp["+i+"]["+(j+1)+"] ("+dp[i][j + 1]+") ? dp["+(i+1)+"]["+j+"] ("+dp[i + 1][j]+")");
                //这里的意思其实对应在dp[i+1][j+1]的计算过程
                //i、j是在字符串里的下边，但是在dp里i、j对应的坐标是i+1、j+1
                //这里等于加dp[i-1][j]>dp[i][j-1]
                char c = dp[i][j + 1] >= dp[i + 1][j] ? s1.charAt(i--) : s2.charAt(j--); // the char corresponding to larger dp value.
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        //String s1 = "abcd";
        //String s2 = "bnmcd";
        String s1 = "ABCBDAB";
        String s2 = "BDCABA";
        System.out.println(new ShortestCommonSupersequence().resolve(s1, s2));
    }
}
