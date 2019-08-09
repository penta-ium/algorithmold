package com.algo.dp.packages;

/**
 * 给定n种物品和一个背包。物品i的重量是wi，其价值为vi，背包的容量为C。应该如何选择装入背包中的物品，使得装入背包中物品的总价值最大？
 */
public class Package {

    //背包重量
    static int[] W = new int[]{3, 5, 1, 7, 6, 4};
    //背包价值
    static int[] V = new int[]{9, 4, 1, 5, 2, 8};
    //总容量C
    static int C = 15;

    //计算capacity容量的包存放num个的最大价值
    public int resolve(int capacity, int n) {

        if (n < 0 || capacity < 0) {
            return 0;
        }

        //第n个物品自己就超过了容量
        if (W[n] > capacity)
            return resolve(capacity, n - 1);

        //包含第n个
        int v1 = V[n] + resolve(capacity - W[n], n - 1);
        //不包含第n个
        int v2 = resolve(capacity, n - 1);

        return Math.max(v1, v2);
    }

    public static void main(String[] args) {

        //递归倒叙处理
        int v = new Package().resolve(C, W.length - 1);

        System.out.println(v);

    }
}
