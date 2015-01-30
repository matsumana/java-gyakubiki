package com.example.java8.chapter02;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Recipe039Test {

    // java.util.functionパッケージで定義されている汎用的な関数型インターフェースでは
    // カバーできない場合（3つ以上の引数を取るラムダ式を使いたい場合など）、
    // 独自の関数型インターフェースを定義できます。

    @FunctionalInterface
    public interface TriFunction {
        int apply(int a, int b, int c);
    }

    @Test
    public void 独自の関数型インターフェースを定義したい() throws Exception {

        TriFunction function = (a, b, c) -> a + b + c;

        assertThat(function.apply(1, 2, 3), is(6));
    }
}
