package com.example.basic.chapter03;

// アウタークラス
public class Recipe066StaticNestedClassExample {

    // staticなネストクラス
    public static class Nested {
        private String innerFiled = "inner";

        private String InnerMethod() {
            // 外部クラスのメソッドやフィールドには直接アクセス不可能
//            outerMethod();      // コンパイルエラー
//            return outerFiled;  // コンパイルエラー

            return innerFiled;
        }
    }

    private String outerFiled = "outer";

    private String outerMethod() {
        Nested nested = new Nested();

        // staticなネストクラスのprivateなフィールドやメソッドにアクセス可能
        return nested.innerFiled + " " + nested.InnerMethod();
    }
}
