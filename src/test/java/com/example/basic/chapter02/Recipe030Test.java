package com.example.basic.chapter02;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Recipe030Test {

    @Test
    public void 条件がtrueの間繰り返しを行う() throws Exception {

        int i = 1;
        int sum = 0;

        while (i <= 10) {
            sum += i;
            i++;
        }

        assertThat(sum, is(55));
    }

    @Test
    public void 最低1回は処理する時はdo_whileを使う() throws Exception {

        int i = 0;

        do {
            System.out.printf("1回は必ず実行");
        } while (i > 0);
    }
}
