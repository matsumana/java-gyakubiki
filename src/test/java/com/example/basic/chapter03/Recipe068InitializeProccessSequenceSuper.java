package com.example.basic.chapter03;

public class Recipe068InitializeProccessSequenceSuper {

    static {
        System.out.println("スーパークラス: staticイニシャライザ");
    }

    {
        System.out.println("スーパークラス: インスタンスイニシャライザ");
    }

    public Recipe068InitializeProccessSequenceSuper() {
        System.out.println("スーパークラス: コンストラクタ");
    }
}
