package com.algo.backtracking.kuohao;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号--回溯
 */
public class KuohaoBtrack {

    static final int NUMS = 3;

    public static List<String> generateParenthesis(){
        List<String> result = new ArrayList<>();
        gene("", result, 0, 0);
        System.out.println(result);
        return result;
    }

    /**
     * 回溯中的递归方法体
     * @param tmpStr 临时字符串结果
     * @param result 结果集合
     * @param leftNum 已经使用的左括号数量
     * @param rightNum 已经使用的右括号数量
     */
    public static void gene(String tmpStr, List<String> result, int leftNum, int rightNum){
        if (tmpStr.length() == 2 * NUMS && leftNum == NUMS && rightNum == NUMS) {
            result.add(tmpStr);
            return ;
        }
        if(leftNum < NUMS)//只有左括号数<n(只能是<，不能是<=)，才添加左括号
            gene(tmpStr + "(", result, leftNum+1, rightNum);

        if(rightNum < NUMS && leftNum > rightNum)//右括号数<n，并且左括号数>右括号数，才添加右括号
            gene(tmpStr + ")", result, leftNum, rightNum + 1);
    }

    public static void main(String[] args) {
        generateParenthesis();
    }
}
