package com.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换大小写
 */
public class UpperLowderCase {

    String input = null;

    public UpperLowderCase(String input) {
        this.input = input;
    }

    public void recursive(String item, List<String> result, int index) {
        if (index == input.length()) {
            result.add(item);
            return;
        }

        char v = input.charAt(index);
        if (Character.isDigit(v)) {
            recursive(item + v, result, index + 1);
        } else {
/*            if (Character.isLowerCase(v)) {
               recursive(item + Character.toUpperCase(v), result, index + 1);
            } else {
                recursive(item + Character.toLowerCase(v), result, index + 1);
            }*/
            recursive(item + Character.toUpperCase(v), result, index + 1);
            recursive(item + Character.toLowerCase(v), result, index + 1);
        }

    }

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();

        new UpperLowderCase("a2B3q").recursive("", result, 0);

        System.out.println(result.toString());

    }
}
