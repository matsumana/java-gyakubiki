package com.example.basic.chapter02;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Recipe045Test {

    String source = "A,B,C,";

    @Test
    public void 第２引数なしのsplit() throws Exception {
        String[] actual = source.split(",");
        assertThat(actual, is(new String[]{"A", "B", "C"}));
    }

    @Test
    public void カンマで２つに分割() throws Exception {
        String[] actual = source.split(",", 2);
        assertThat(actual, is(new String[]{"A", "B,C,"}));
    }

    @Test
    public void カンマで３つに分割() throws Exception {
        String[] actual = source.split(",", 3);
        assertThat(actual, is(new String[]{"A", "B", "C,"}));
    }

    @Test
    public void カンマで４つに分割() throws Exception {
        String[] actual = source.split(",", 4);
        assertThat(actual, is(new String[]{"A", "B", "C", ""}));
    }

    @Test
    public void カンマで５つに分割() throws Exception {
        String[] actual = source.split(",", 5);
        assertThat(actual, is(new String[]{"A", "B", "C", ""}));
    }

    @Test
    public void 第２引数に０を指定() throws Exception {
        String[] actual = source.split(",", 0);

        // 第２引数なしの場合と同じ
        assertThat(actual, is(new String[]{"A", "B", "C"}));
    }

    @Test
    public void 第２引数に府の値を指定() throws Exception {
        String[] actual = source.split(",", -1);

        // 分割数の制限なし、かつ、末尾の空白文字列を含む
        assertThat(actual, is(new String[]{"A", "B", "C", ""}));
    }
}
