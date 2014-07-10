package com.example.fibonacci;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

// メモ化 computeIfAbsentバージョン
public class FibonacciMemoizationComputeIfAbsent {

    static Map<Integer, BigDecimal> cache = new HashMap<>();

    public static void main(String[] args) {
        cache.put(0, BigDecimal.ZERO);
        cache.put(1, BigDecimal.ONE);

        IntStream.rangeClosed(1, 100).forEach(i -> {
            System.out.println(String.format("%d:%s", i, fib(i).toString()));
        });
    }

    static BigDecimal fib(int n) {
        return cache.computeIfAbsent(n, i -> fib(i - 2).add(fib(i - 1)));
    }
}
