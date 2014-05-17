package com.example.basic.chapter02;

import org.junit.Test;

import static org.junit.Assert.fail;

public class Recipe018Test {

    @Test(expected = NullPointerException.class)
    public void 論理演算子1() throws Exception {
        // 文字列がnullだった場合にもvalue.length() != 0が実行されてしまうため、NullPointerExceptionが発生してしまう。
        // ||と|も同様
        String value = null;
        if (value != null & value.length() != 0) {
            fail();
        }
    }

    @Test
    public void 論理演算子2() throws Exception {
        // 文字列がnullだった場合にはvalue.length() != 0は実行されないので、NullPointerExceptionは発生しない。
        // ||と|も同様
        String value = null;
        if (value != null && value.length() != 0) {
            System.out.println("hoge");
        }
    }
}
