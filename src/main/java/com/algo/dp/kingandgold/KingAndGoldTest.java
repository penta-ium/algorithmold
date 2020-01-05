package com.algo.dp.kingandgold;

public class KingAndGoldTest {

    static int N = 5;
    static int W = 10;
    static int[] G = new int[]{400, 500, 200, 300, 350};
    static int[] P = new int[]{5, 5, 3, 4, 3};

    static int[][] MEMO = new int[N][W];

    public static void main(String[] args) {

        System.out.println(new KingAndGoldTest().dig(N, W));
        System.out.println(new KingAndGoldTest().digWithMemo(N, W));
    }

    /**
     * 第一种解法 - 递归解法
     * @param n 第几座矿，并不是数组的下标
     * @param w 工人的个数
     * @return
     */
    public int dig(int n, int w) {

        //挖到最后一个矿，人手不够了
        if (n == 1 && w < P[n - 1])
            return 0;

        //无矿可挖了
        if (n <=0 || w <= 0)
            return 0;

        //决定挖第n座矿的最大值
        int value1 = 0;
        //不挖第n座矿的最大值
        int value2 = 0;

        //挖第n个矿,分两种情况：
        if (w >= P[n - 1]) {//当前的人数w够挖第n个矿，挖了第n个，然后挖剩余的n-1个之和；
            value1 = G[n - 1] + dig(n - 1, w - P[n - 1]);
        } else {//当前的人数不够挖第n个矿，等同于直接去挖剩余的n-1；
            value1 = dig(n - 1, w);
        }
        //不挖掘第n个
        value2 = dig(n - 1, w);

        return Math.max(value1, value2);
    }

    /**
     * 第二种解法 - 递归 + 暂存
     */
    public int digWithMemo(int n, int w) {

        //从缓存里找数据，防止重复计算
        if (MEMO[n - 1][w - 1] != 0)
            return MEMO[n - 1][w - 1];

        //挖到最后一个矿，人手不够
        if (n == 1 && w < P[n - 1])
            return 0;

        //无矿可挖 或者 无人可用
        if (n == 0 || w <= 0)
            return 0;

        //决定挖第n座矿的最大值
        int value1 = 0;
        //不挖第n座矿的最大值
        int value2 = 0;

        //挖第n座矿分两种情况：
        //1、w个人够挖第n座矿；2、w个人不够挖第n座矿
        if (w >= P[n - 1]) {
            value1 = G[n - 1] + dig(n - 1, w - P[n - 1]);
        } else {
            value1 = dig(n - 1, w);
        }

        //不挖第n座矿
        value2 = dig(n - 1, w);

        //写入缓存
        int gold = Math.max(value1, value2);
        MEMO[n - 1][w - 1] = gold;

        return gold;
    }

    /**
     * 第三种解法就是dp
     * @return
     */
    public int dp() {

        int[][] dp = new int[N][W];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < W; j++) {

            }
        }

        return 0;
    }
}
