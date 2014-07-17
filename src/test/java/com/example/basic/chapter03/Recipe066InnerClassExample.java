package com.example.basic.chapter03;

// アウタークラス
public class Recipe066InnerClassExample {

    // インナークラス
    public class Inner {
        private String innerFiled = "inner";

        private String InnerMethod() {
            // 外部クラスのメソッドやフィールドへ直接アクセス可能
            outerMethod();
            return outerFiled + " " + innerFiled;
        }
    }

    private String outerFiled = "outer";

    private String outerMethod() {
        Inner inner = new Inner();

        // インナークラスのprivateなフィールドやメソッドにアクセス可能
        return inner.innerFiled + " " + inner.InnerMethod();
    }
}
