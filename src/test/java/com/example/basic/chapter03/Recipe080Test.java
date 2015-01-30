package com.example.basic.chapter03;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class Recipe080Test {

    public class FileStore<T extends OutputStream> {
    }

    @Test
    public void 制限付き型パラメータに型を指定する() {
        // OK
        FileStore<FileOutputStream> store1 = new FileStore<>();

        // コンパイルエラー
//        FileStore<FileInputStream> store2 = new FileStore<>();

//        LocalDateTime ldt1 = LocalDateTime.of(2015, 1, 31, 0, 1, 30);
//        LocalDateTime ldt2 = LocalDateTime.of(2015, 2, 1, 0, 0, 0);

        // OK
        compare("abc", "xyz");

        // コンパイルエラー (ListはSerializableもComparableも継承していないため)
//        List<String> list1=  new ArrayList<>();
//        List<String> list2=  new ArrayList<>();
//        compare(list1, list2);
    }

    // &で複数の制限を指定可能
    private <E extends Serializable & Comparable<E>> int compare(E data1, E data2) {
        // EはComparableのサブクラスだと明白なため、compareToメソッドを呼び出せる
        return data1.compareTo(data2);
    }
}
