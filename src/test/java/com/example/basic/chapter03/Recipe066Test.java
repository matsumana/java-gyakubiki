package com.example.basic.chapter03;

import org.junit.Test;

public class Recipe066Test {

    @Test
    public void 外部からインナークラスをnewする場合はアウタークラスのインスタンスを使ってnewする必要がある() {
        Recipe066InnerClassExample outer = new Recipe066InnerClassExample();
        Recipe066InnerClassExample.Inner inner = outer.new Inner();
    }

    @Test
    public void staticなネストクラスは通常のクラスと同じようにnewできる() {
        Recipe066StaticNestedClassExample.Nested nested = new Recipe066StaticNestedClassExample.Nested();
    }
}
