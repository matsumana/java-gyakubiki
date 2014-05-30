package com.example.basic.chapter02;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Recipe037Test {

    @Test
    public void コレクションをソートする_匿名クラス版() throws Exception {

        List<String> list = Arrays.asList("Groovy", "Java", "Scala");
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        assertThat(list.get(0), is("Java"));
        assertThat(list.get(1), is("Scala"));
        assertThat(list.get(2), is("Groovy"));
    }

    @Test
    public void コレクションをソートする_ラムダ式版() throws Exception {

        List<String> list = Arrays.asList("Groovy", "Java", "Scala");
        list.sort((String s1, String s2) -> s1.length() - s2.length());

        assertThat(list.get(0), is("Java"));
        assertThat(list.get(1), is("Scala"));
        assertThat(list.get(2), is("Groovy"));
    }

    @Test
    public void コレクションをソートする_ラムダ式版_引数省略パターン１() throws Exception {

        List<String> list = Arrays.asList("Groovy", "Java", "Scala");

        // ラムダ式の引数の型が自明な場合は、型を省略する事ができる
        list.sort((s1, s2) -> s1.length() - s2.length());

        assertThat(list.get(0), is("Java"));
        assertThat(list.get(1), is("Scala"));
        assertThat(list.get(2), is("Groovy"));
    }

    @Test
    public void コレクションをソートする_ラムダ式版_引数省略パターン２() throws Exception {

        List<String> list = Arrays.asList("Groovy", "Java", "Scala");

        // ラムダ式の引数が１つの場合は、引数リストの()を省略する事ができる
        list.forEach(s -> System.out.println(s));
    }

    @Test
    public void 実質的final() throws Exception {
        outer("hoge");
    }

    private void outer(String outer) {

        // ラムダ式であっても、匿名クラスであっても、実質的にfinal（変数に再代入を行っていない）な変数を参照可能。

        // 代入を行っている場合はコンパイルエラーになる
//        outer = "fuga";

        // ラムダ式
        Runnable r = () -> {
            System.out.println(outer);
        };

        // 匿名クラス
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(outer);
            }
        };
    }
}
