package com.algo.backtracking.mindistance;

import com.algo.common.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

public class MinTableDisReback {

    //int[][] table;

    public void recursive(int[][] table, int level, List<Integer> result, int row, int col) {
        if (row == table.length - 1 && col == table[0].length - 1) {
            level += table[row][col];
            result.add(level);
            return;
        }
        if (row + 1 < table.length) {
            recursive(table, level + table[row][col], result, row + 1, col);
        }
        if (col + 1 < table[0].length) {
            recursive(table, level + table[row][col], result, row, col + 1);
        }
    }

    public static void main(String[] args) {
        int[][] table = new int[][]{
                {1, 3, 5, 9},
                {2, 1, 3, 4},
                {5, 2, 6, 7},
                {6, 8, 4, 3},
        };
        System.out.println("原路径表");
        ArrayUtil.print2DArray(table);

        List<Integer> result = new ArrayList<>() ;
        new MinTableDisReback().recursive(table, 0, result, 0, 0);

        System.out.println(result);
        //System.out.println(Ints.min(result.toArray()));
        //Integer[] a = new Integer[result.size()];
        //Ints.min(result.toArray(a));
    }
}
