package com.example.basic.chapter03;

import org.junit.Test;

public class Recipe068_2Test {

    @Test
    public void サブクラスをインスタンス化した場合の初期化処理が実行される順番_２回目のインスタンス化の場合() {
        System.out.println("\n2回実行");
        System.out.println("+++++++++++++++++++++++");
        new Recipe068InitializeProccessSequenceSub();
        System.out.println("------------------");
        new Recipe068InitializeProccessSequenceSub();   // 2回目のnewではstaticイニシャライザは実行されない
        System.out.println("+++++++++++++++++++++++");
    }
}
