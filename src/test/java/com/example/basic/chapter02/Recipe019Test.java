package com.example.basic.chapter02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class Recipe019Test {

    // instanceof演算子は、指定した方、またはそのサブクラス、サブインターフェースの場合にtrueを返す。
    // また、nullの場合はfalseを返す。

    @Test
    public void テスト１() throws Exception {
        Object obj = "abc";
        if (obj instanceof String) {
            String str = (String) obj;
        } else {
            fail();
        }
    }

    @Test
    public void テスト２() throws Exception {
        Object obj = new ArrayList<>();
        if (obj instanceof List) {
            // 実際のオブジェクトはArrayListだが、ArrayListはListの実装クラスなのでtrueになる
        } else {
            fail();
        }
    }

    @Test
    public void テスト３() throws Exception {
        Object obj = null;
        if (obj instanceof Object) {
            // nullなのでfalseを返す
            fail();
        }
    }
}
