package com.algo.uf;

import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class UFSolution2 {

    //5 * i + j;
    private int[][] inner = null;

    Map<String, String> map = Maps.newHashMap();

    public void init(int[][] island) {
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                String v = (5 *i + j) + "";
                map.put(v, v);
            }
        }

        System.out.println(map.toString());
        inner = island;

    }
    public void init(List<String>... lists) {
        for (List<String> list : lists) {
            String r = list.get(0);
            for (String s : list) {
                map.put(s, r);
            }
        }

        System.out.println(map.toString());

    }

    public String find(String s) {

        String f = new String(s);
        while (!f.equals(map.get(f))) {
            f = new String(map.get(f));
        }
        return f;
    }

    public void union(String s1, String s2) {
        String fs1 = find(s1);
        String fs2 =  find(s2);

        if (!fs1.equals(fs2)) {
            map.put(fs1, fs2);
        }
    }

    public void print() {
        System.out.println(map.toString());
    }

    public boolean isInter(String s1, String s2) {

        String fs1 = find(s1);
        String fs2 =  find(s2);

        return fs1.equals(fs2);
    }

    public int islandCount () {



        return -1;
    }

    public void deal(int[][] is, int row, int col) {

        int v = is[row][col];
        if (v == 0)
            return;



    }

    public static void main(String[] args) {

        int[][] island = new int[][]{
                {1, 1, 1, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 0}
        };

        UFSolution2 uf = new UFSolution2();
        uf.init(island);

    }
}
