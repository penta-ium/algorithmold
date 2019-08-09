package com.algo.backtracking.kuohao;

import java.util.ArrayList;
import java.util.List;

public class KuohaoBtrack {

    static final int NUMS = 3;

    public static List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        gene("", result, 0, 0);
        System.out.println(result);
        return result;
    }

    //leftNum  左括号数量
    //rightNum 右括号数量
    public static void gene(String subList, List<String> result, int leftNum, int rightNum){
        if (subList.length() == 2 * NUMS && leftNum == NUMS && rightNum == NUMS) {
            result.add(subList);
            return ;
        }
        if(leftNum < NUMS)//只有左括号数<n，才添加左括号
            gene(subList + "(", result, leftNum+1, rightNum);

        if(rightNum < NUMS && leftNum > rightNum)//右括号数<n，并且左括号数>右括号数，才添加右括号
            gene(subList + ")", result, leftNum, rightNum + 1);
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }
}
