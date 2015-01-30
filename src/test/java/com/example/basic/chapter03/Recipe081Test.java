package com.example.basic.chapter03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recipe081Test {

    @Test
    public void ワイルドカードって何に使うの() {
        // raw型で受け取ると警告が出るので、アノテーションで抑制する必要がある
        @SuppressWarnings("rawtypes")
        List list1 = getList();

        // ワイルドカードにする事で型がある事を保証できる
        List<?> list2 = getList();
    }

    // raw型を返すメソッド
    private List getList() {
        return new ArrayList<>();
    }

    private void replace(List<?> list, int i) {
        // ワイルドカードを使ったListにはnull以外を設定できない。コンパイルエラーになる
//        list.set(i, list.get(i - 1));
        list.set(i, null);

        // このような場合は、
        // ワイルドカードを補足してヘルパーメソッドに実装を委譲するキャプチャ・ヘルパと呼ばれるイディオムを使うと
        // 解決できる
        replaceHelper(list, i);
    }

    private <E> void replaceHelper(List<E> list, int i) {
        // Listから取得した値はE型なので、設定できる
        list.set(i, list.get(i - 1));
    }

    private void ワイルドカードに境界を付ける() {

        // ワイルドカードには、以下のように境界をつける事ができる
        // <? extends MyClass> → MyClassもしくはそのサブクラスを代入できる
        // <? super MyClass>   → MyClassもしくはそのスーパークラスを代入できる

        // <?>の場合、取得はObject型、設定はnull以外不可という強い成約があるが、
        // 境界となる型を決めることで、指定した型で取得および設定ができるようになる

        // Number型が上限であると保証されるので、Number型で取得できる
        List<? extends Number> list1 = Arrays.asList(1);
        Number number1 = list1.get(0);

        // Intger型が下限であると保証されるので、Intger型を設定できる
        Number number2 = 1;
        List<? super Integer> list2 = Arrays.asList(number2);
        list2.add(2);
    }
}
