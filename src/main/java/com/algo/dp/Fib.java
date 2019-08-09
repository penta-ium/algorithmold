package com.algo.dp;

import java.util.HashMap;
import java.util.Map;

public class Fib {

    static long SIZE = 0;
    static Map<Long, Long> fibs = new HashMap<>();

    public static void main(String[] args) {

        //Fib test = new Fib();
        System.out.println(fib1(20));
        System.out.println("执行步数：" + SIZE);
        SIZE = 0;
        System.out.println(fib2(20));
        System.out.println("执行步数：" + SIZE);
        SIZE = 0;
        System.out.println(fib3(20));
        System.out.println("执行步数：" + SIZE);

    }

    public static long fib1(long n) {

        SIZE ++;

        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        long v = fib1(n - 1) + fib1(n - 2);
        return v;

    }


    public static long fib2(long n) {

        SIZE ++;

        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        if (fibs.containsKey(n)) {
            return fibs.get(n);
        } else {
            long v = fib2(n - 1) + fib2(n - 2);
            fibs.put(n, v);
            return v;
        }

    }

    public static long fib3 (int n) {

        long fn1 = 0;
        long fn2 = 0;
        for (int i = 1; i<=n; i++) {
            SIZE++;
            if (i == 1) {
                fn2 = 0;
                fn1 = 1;
                continue;
            }
             if (i == 2) {
                 fn2 = 1;
                 fn1 = 1;
                 continue;
             }

             long temp = fn1 + fn2;
             fn2 =fn1;
             fn1 = temp;
        }

        return fn1;
    }

}
