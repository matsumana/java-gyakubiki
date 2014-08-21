package com.example.basic.chapter03;

import org.junit.Test;

public class Recipe068_1Test {

    @Test
    public void サブクラスをインスタンス化した場合の初期化処理が実行される順番() {
        System.out.println("\n1回だけ実行");
        System.out.println("+++++++++++++++++++++++");
        new Recipe068InitializeProccessSequenceSub();
        System.out.println("+++++++++++++++++++++++");
    }
}
