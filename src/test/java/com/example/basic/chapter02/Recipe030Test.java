package com.example.basic.chapter02;

import org.junit.Test;

public class Recipe030Test {

    @Test
    public void 最低1回は処理する時はdo_whileを使う() throws Exception {

        int i = 0;

        do {
            System.out.printf("1回は必ず実行");
        } while (i > 0);
    }
}
