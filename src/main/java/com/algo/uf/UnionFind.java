package com.algo.uf;

public class UnionFind {

    int size = 100;

    int[] pre = new int[size];


    public void init() {
        for (int i = 0; i < size; i++) {
            pre[i] = i;
        }
    }

    //return the root that x belongs to
    public int find(int x) {

        int fx = x;
        while (fx != pre[fx]) {
            fx = pre[fx];
        }

        return fx;
    }

    public void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        pre[rx] = ry;
    }

    public boolean inter(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        //List<Integer> list1 = Lists.newArrayList(2, 5, 7);
        //List<Integer> list2 = Lists.newArrayList(3, 6);
        //List<Integer> list3 = Lists.newArrayList(8, 9);
    }
}
