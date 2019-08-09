package com.algo.dp.kingandgold;

public class KingAndGoldWithMemo {

    /**
     * F(n,w) = 0    (n<=1, w<p[0]);
     * n为剩余1个金矿，当前的矿工数w小于开采这1个金矿所需要的矿工数；
     * 那么值为0；
     *
     * F(n,w) = g[0]     (n==1, w>=p[0]);
     * n为剩余1个金矿，当前的矿工数w大于开采这1个金矿所需要的矿工数；
     * 那么值为这个金矿的金储量;
     *
     * #F(n,w) = F(n-1,w)    (n>1, w<p[n-1]);
     *
     * F(n,w) = max(F(n-1,w),  F(n-1,w-p[n-1])+g[n-1])    (n>1, w>=p[n-1]);
     * w个人，开采n座金矿，所能开采出来的黄金总量
     * =max(
     * w个人开采n-1座金矿，所能开采的黄金量;
     * p[n-1]个人开采第n座金矿+ (w-p[n-1])个人开采n-1座金矿;
     * );
     * @param args
     */

    //金矿数量
    static int N = 5;
    //工人数
    static int W = 10;
    //金矿的黄金量
    static int[] G = new int[]{400, 500, 200, 300, 350};
    //金矿的用工量
    static int[] P = new int[]{5, 5, 3, 4, 3};

    //计算次数
    static int calCnt = 0;

    static int[][] mem = new int[N + 1][W + 1];
    static {
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                mem[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    public static void main(String[] args) {
        //n=5,    m=10,    g = [400,500,200,300,350],    p = [5,5,3,4,3]
        System.out.println(String.format("%d个人挖%d个矿问题。", W, N));
        int golds = dig(N, W);
        System.out.println(golds);
        System.out.println("计算次数: " + calCnt);
    }

    public static int dig (int n, int w) {

        if (mem[n][w] != Integer.MIN_VALUE)
            return mem[n][w];

        calCnt ++;

        System.out.println(String.format("%d个人挖%d个矿。", w, n));

        if (n == 1 && w < P[n-1])
            return 0;

        if (n == 1 && w >= P[n-1])
            return G[n-1];

        if (w < P[n-1]) {
            return 0;
        }

        int N_1 = dig(n-1, w);
        int N_2 = dig(n-1, w-P[n-1]) + G[n-1];

        int max =  Math.max(N_1, N_2);
        System.out.println("最大数量为：" + max);
        mem[n][w] = max;
        return max;
    }
}
