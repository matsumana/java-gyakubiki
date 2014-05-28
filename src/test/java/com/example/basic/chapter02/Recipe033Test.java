package com.example.basic.chapter02;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Recipe033Test {

    @Test(expected = IOException.class)
    public void 例外のマルチキャッチ() throws Exception {

//        // 継承関係にある例外はマルチキャッチできない
//        // この例の場合、FileNotFoundExceptionはIOExceptionのサブクラスなのでコンパイルエラーになる
//        try {
//            // Do Something.
//        } catch (FileNotFoundException | IOException e) {  // コンパイルエラー
//            // コンパイルエラーメッセージはこれ。
//            // 複数catch文の代替をサブクラス化によって関連付けることはできません
//            // 代替java.io.FileNotFoundExceptionは代替java.io.IOExceptionのサブクラスです
//        }

        try {
            Date date = new SimpleDateFormat("yyyyMMdd").parse("20140401");
            FileSystem fs = FileSystems.getDefault();
            Path path = fs.getPath(System.getProperty("java.io.tmpdir"),
                    String.valueOf(date.getTime()),
                    "newfile.txt");
            path.toFile().createNewFile();
        } catch (ParseException | IOException e) {
            // 複数の例外をマルチキャッチした場合、catchブロックの変数eの型はcatchに列挙したクラス全てに共通するスーパークラスになる。
            // このサンプルコードの場合、変数eの型はExceptionになる。
            // ただし、実行時には実際に発生した例外がcatchされる

            throw e;
        }
    }
}
