package com.example.basic.chapter02;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Recipe052Test {

    // 参考URL
    // http://www.ne.jp/asahi/hishidama/home/tech/java/formatter.html

    @Test
    public void 文字列を埋め込み() throws Exception {
        String str = "abc";
        String actual = String.format("文字列の書式 %s", str);
        assertThat(actual, is("文字列の書式 abc"));
    }

    @Test
    public void 真偽値を埋め込み_大文字() throws Exception {
        boolean bool = true;
        String actual = String.format("文字列の書式大文字 %B", bool);
        assertThat(actual, is("文字列の書式大文字 TRUE"));
    }

    @Test
    public void 真偽値を埋め込み_小文字() throws Exception {
        boolean bool = true;
        String actual = String.format("文字列の書式小文字 %b", bool);
        assertThat(actual, is("文字列の書式小文字 true"));
    }

    @Test
    public void 整数を埋め込み_１０進数() throws Exception {
        int i = 127;
        String actual = String.format("整数の書式10進数 %d", i);
        assertThat(actual, is("整数の書式10進数 127"));
    }

    @Test
    public void 整数を埋め込み_１０進数ゼロ埋め() throws Exception {
        int i = 127;
        String actual = String.format("整数の書式10進数 %05d", i);
        assertThat(actual, is("整数の書式10進数 00127"));
    }

    @Test
    public void 整数を埋め込み_１０進数空白埋め() throws Exception {
        int i = 127;
        String actual = String.format("整数の書式10進数 %5d", i);
        assertThat(actual, is("整数の書式10進数   127"));
    }

    @Test
    public void 整数を埋め込み_８進数() throws Exception {
        int i = 127;
        String actual = String.format("整数の書式10進数 %o", i);
        assertThat(actual, is("整数の書式10進数 177"));
    }

    @Test
    public void 整数を埋め込み_１６進数() throws Exception {
        int i = 127;
        String actual = String.format("整数の書式10進数 %x", i);
        assertThat(actual, is("整数の書式10進数 7f"));
    }

    @Test
    public void 絶対インデックスでも指定できる() throws Exception {
        String actual = String.format("整数の書式10進数 %5$d %4$d %3$d %2$d %1$d", 1, 2, 3, 4, 5);
        assertThat(actual, is("整数の書式10進数 5 4 3 2 1"));
    }

    @Test
    public void 相対インデックスでも指定できる() throws Exception {
        Date date = Date.from(ZonedDateTime.of(
                LocalDateTime.of(2014, 1, 2, 3, 4, 5),
                ZoneId.systemDefault()).toInstant());
        String actual = String.format("整数の書式10進数 %tY/%<tm/%<td %<tH:%<tM:%<tS", date);

        // kはゼロ埋めされないので注意
        assertThat(actual, is("整数の書式10進数 2014/01/02 03:04:05"));
    }
}
