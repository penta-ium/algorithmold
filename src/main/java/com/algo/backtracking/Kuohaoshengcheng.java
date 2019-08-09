package com.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class Kuohaoshengcheng {

    int n = 0;
    int total = 0;

    public Kuohaoshengcheng(int n) {
        this.n = n;
        this.total = 2 * n;
    }

    public void recursive(String item, List<String> result, int left, int right) {
        if (item.length() == total){
            result.add(item);
            return;
        }

        if (left > 0) {
            recursive(item + "(", result, left - 1, right);
        }
        if (right > left) {
            recursive(item + ")", result, left, right - 1);
        }


/*        recursive(item + "(", result, left - 1, right);
        recursive(item + ")", result, left, right - 1);*/

    }

    public static void main(String[] args) {

        int n = 3;
        List<String> list = new ArrayList<>();
        new Kuohaoshengcheng(n).recursive("", list, n, n);

        System.out.println(list.toString());
    }
}
