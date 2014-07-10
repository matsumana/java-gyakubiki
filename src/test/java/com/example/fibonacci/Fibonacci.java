package com.example.fibonacci;

import java.math.BigDecimal;
import java.util.stream.IntStream;

public class Fibonacci {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            System.out.println(String.format("%d:%s", i, fib(i).toString()));
        });
    }

    static BigDecimal fib(int n) {
        if (n == 0) {
            return BigDecimal.ZERO;
        } else if (n == 1) {
            return BigDecimal.ONE;
        } else {
            return fib(n - 2).add(fib(n - 1));
        }
    }
}
