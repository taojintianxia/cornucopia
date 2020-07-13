package com.github.taojintianxia.junitexample.parameterized;

/**
 * @author Nianjun Sun
 * @date 2019/10/17 20:20
 */
public class Fibonacci {

    public static int compute(int n) {
        int result = 0;

        if (n <= 1) {
            result = n;
        } else {
            result = compute(n - 1) + compute(n - 2);
        }

        return result;
    }
}
