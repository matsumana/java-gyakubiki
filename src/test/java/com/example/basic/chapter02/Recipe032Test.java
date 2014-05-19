package com.example.basic.chapter02;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.Assert.fail;

public class Recipe032Test {

    // 例外の種類と継承関係
    //
    //    java.lang.Throwable ------------------> スーパークラス
    //      ├── java.lang.Error ----------------> エラー ※システムが異常な状態で実行不能な時に発生するので、catchして例外処理は行わない
    //      └── java.lang.Exception ------------> チェック例外（検査例外） ※catchまたは、throwsする必要がある
    //          └── java.lang.RuntimeException -> ランタイム例外（実行時例外） ※通常は例外処理不要

    private class MyRuntimeException extends RuntimeException {
        MyRuntimeException(String message) {
            super(message);
        }

        MyRuntimeException(Throwable cause) {
            super(cause);
        }
    }

    @Test(expected = MyRuntimeException.class)
    public void 例外処理の基本形() {

        FileInputStream is = null;

        // catchとfinallyは必ず両方書かないといけない訳ではなく、どちらかだけ書いてもOK
        // 例えば、ランタイム例外が発生しても、終了処理を行いたい場合はfinallyだけ書く。

        try {
            is = new FileInputStream("a.txt");
        } catch (FileNotFoundException e) {
            throw new MyRuntimeException(e);
        } finally {
            System.out.println("finally!!!");
        }

        fail();
    }

    @Test(expected = FileNotFoundException.class)
    public void throwsを指定すると例外処理を呼出側で行わせる事が可能_ここではcatch不要になる() throws FileNotFoundException {

        FileInputStream is = null;

        is = new FileInputStream("a.txt");

        fail();
    }

    private void ランタイム例外をスローする可能性があるメソッド() throws MyRuntimeException {
        throw new MyRuntimeException("ランタイム例外をスローします");
    }

    @Test(expected = MyRuntimeException.class)
    public void throwsにランタイム例外処理を書いても意味がない() {

        // メソッドのthrowsにランタイム例外処理を書いても、そのメソッドを呼ぶ側はcatchもthrowsも書く必要がないので、意味がない。

        ランタイム例外をスローする可能性があるメソッド();

        fail();
    }

    @Test
    public void ランタイム例外をキャッチするシチュエーション() {

        // ランタイム例外は、フレームワークの例外処理機能で処理されるので、基本的にcatch不要だが、
        // 場合によってはcatchする事もある（リトライする時など）

        int i = 0;

        // 例外が発生しても3回リトライする
        while (i <= 3) {
            try {
                System.out.println("メソッド実行 " + (i + 1) + "回目");
                ランタイム例外をスローする可能性があるメソッド();
            } catch (MyRuntimeException e) {
                System.out.println("catch " + (i + 1) + "回目");
                i++;
            }
        }
    }
}
