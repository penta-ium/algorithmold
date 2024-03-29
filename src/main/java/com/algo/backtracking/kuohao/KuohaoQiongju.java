package com.algo.backtracking.kuohao;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成-穷举
 */
public class KuohaoQiongju {

    static final int NUMS = 3;

    public static List<String> generateParenthesis(){
        List<String> result = new ArrayList<>();
        gene("", result);
        System.out.println(result);
        return result;
    }

    //穷举法:
    public static void gene(String subList, List<String> result){
        if (subList.length() == 2 * NUMS) {
            result.add(subList);
            return ;
        }
        gene(subList + "(", result);
        gene(subList + ")", result);
    }

    public static void main(String[] args) {
        generateParenthesis();
    }
}
