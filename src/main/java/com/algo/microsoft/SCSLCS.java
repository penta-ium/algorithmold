package com.algo.microsoft;

import com.algo.common.ArrayUtil;

public class SCSLCS {

    public void resolve(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char ch1 = s1.charAt(i - 1);
                char ch2 = s2.charAt(j - 1);

                if (ch1 == ch2) {
                    dp[i][j] = dp[i -  1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        ArrayUtil.print2DArray(dp);

        System.out.println("构造");
        String scs = "";
        String lcs = "";

        for (int i = dp.length - 1; i >= 1; ) {
            for (int j = dp[0].length - 1; j >= 1; ) {

                System.out.println(i + "--" + j);

                if (i < 1 ^ j < 1) {
                    System.out.println(i + "--" + j);
                    if (i < 1) {
                        char ch = s2.charAt(j - 1);
                        j--;
                        lcs = ch + lcs;
                        continue;
                    }
                    if (j < 1) {
                        char ch = s1.charAt(i - 1);
                        i--;
                        lcs = ch + lcs;
                        continue;
                    }
                }

                char ch1 = s1.charAt(i - 1);
                char ch2 = s2.charAt(j - 1);

                //当前ch1和ch2相等，并且在dp。。。
                if (ch1 == ch2 && dp[i][j] == dp[i - 1][j - 1] + 1) {
                    scs = ch1 + scs;
                    lcs = ch1 + lcs;
                    i--;
                    j--;
                } else {
                    if (dp[i - 1][j] > dp[i][j - 1]) {
                        lcs = ch1 + lcs;
                        i--;
                    } else {
                        lcs = ch2 + lcs;
                        j--;
                    }
                }
            }
        }

        System.out.println(scs);
        System.out.println(lcs);

    }

    public static void main(String[] args) {

        String s1 = "ABCBDAB";
        String s2 = "BDCABA";

        new SCSLCS().resolve(s1, s2);

    }
}
