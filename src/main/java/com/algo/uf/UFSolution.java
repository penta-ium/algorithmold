package com.algo.uf;

import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class UFSolution {

    //5 * i + j;
    int[][] island = new int[][]{
            {1, 1, 1, 0, 0},
            {1, 1, 1, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {1, 1, 0, 0, 0}
    };

    Map<String, String> map = Maps.newHashMap();

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

    public void printIsLand() {
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                System.out.println(5 * i + j);
            }
        }
    }

    public static void main(String[] args) {

        new UFSolution().printIsLand();

/*        List<String> list1 = Lists.newArrayList("1", "2", "3");
        List<String> list2 = Lists.newArrayList("5", "6");

        UFSolution uf = new UFSolution();
        uf.init(list1, list2);

        System.out.println(uf.isInter("2", "3"));
        System.out.println(uf.isInter("2", "5"));
        uf.union(uf.find("2"), uf.find("5"));

        System.out.println(uf.find("2"));
        System.out.println(uf.find("5"));

        uf.print();

        System.out.println(uf.isInter("2", "3"));
        System.out.println(uf.isInter("2", "5"));*/

    }
}
