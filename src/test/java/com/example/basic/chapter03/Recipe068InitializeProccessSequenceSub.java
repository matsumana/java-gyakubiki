package com.example.basic.chapter03;

public class Recipe068InitializeProccessSequenceSub extends Recipe068InitializeProccessSequenceSuper {

    static {
        System.out.println("サブクラス: staticイニシャライザ");
    }

    {
        System.out.println("サブクラス: インスタンスイニシャライザ");
    }

    public Recipe068InitializeProccessSequenceSub() {
        System.out.println("サブクラス: コンストラクタ");
    }
}
