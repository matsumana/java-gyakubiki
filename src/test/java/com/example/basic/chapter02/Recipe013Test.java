package com.example.basic.chapter02;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Recipe013Test {

    @Test
    public void 数値リテラル() throws Exception {
        // Java7以降では数値リテラルをアンダーバーで区切る事が出来る
        assertThat(10000000, is(10_000_000));
    }
}
