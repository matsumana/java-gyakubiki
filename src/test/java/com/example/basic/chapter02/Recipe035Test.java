package com.example.basic.chapter02;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.fail;

public class Recipe035Test {

    // 例外がtryブロックの中（たとえばファイル読み込み時）で発生し、かつリソースをクローズする際にも発生した場合、
    // tryブロックで発生した例外のみスローされる。クローズに伴って発生した例外はgetSuppressedで取得できる
    // 参考URL
    // http://d.hatena.ne.jp/irof/20110227/p1

    @Test
    public void リソースを確実にクローズしたい() throws Exception {

        // カレントディレクトリにあるファイルを読む
        Path in = FileSystems.getDefault().getPath(
                getClass().getResource("").getFile(),
                "test.txt");
        Path out = FileSystems.getDefault().getPath(
                System.getProperty("java.io.tmpdir"),
                "Recipe035Test-out.txt");

        // FileInputStream, FileOutputStreamを使用し、明示的にエンコーディングを指定する
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(in.toFile()), UTF_8));
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream(out.toFile()), "Windows-31J"))) {

            // テキストファイルをUTF8で読み、Windows-31Jで別ファイルに書き出す
            String line = null;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.write("\r\n");
            }
        }
    }

    @Test
    public void try_with_resource文で例外は発生した場合tryブロックの中は実行されない() throws Exception {

        // カレントディレクトリにあるファイルを読む
        Path in = FileSystems.getDefault().getPath(
                getClass().getResource("").getFile(),
                "test.txt");
        Path out = FileSystems.getDefault().getPath(
                System.getProperty("java.io.tmpdir"),
                "Recipe035Test-out2.txt");

        // FileInputStream, FileOutputStreamを使用し、明示的にエンコーディングを指定する
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(in.toFile()), UTF_8));
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream(out.toFile()), "xxx"))) {

            // try-with-resource文で例外は発生した場合、tryブロックの中は実行されない
            fail();
        } catch (UnsupportedEncodingException e) {
            // try-with-resource文の中で"xxx"という存在しないエンコーディングを指定しているので、UnsupportedEncodingExceptionが発生する
        } finally {
            System.out.println("finally!!");
        }
    }

    @Test
    public void catchブロックおよびfinallyブロックはtry_with_resource文の処理が完了後に実行される() throws Exception {

        // カレントディレクトリにあるファイルを読む
        Path in = FileSystems.getDefault().getPath(
                getClass().getResource("").getFile(),
                "test.txt");
        Path out = FileSystems.getDefault().getPath(
                System.getProperty("java.io.tmpdir"),
                "Recipe035Test-out3.txt");

        // FileInputStream, FileOutputStreamを使用し、明示的にエンコーディングを指定する
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(in.toFile()), UTF_8));
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream(out.toFile()), "Windows-31J"))) {

            // テキストファイルをUTF8で読み、Windows-31Jで別ファイルに書き出す
            String line = null;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.write("\r\n");

                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            // catchブロックおよびfinallyブロックはtry-with-resource文の処理が完了後に実行される
            // なので、Recipe035Test-out3.txtには1行だけ出力されているはず。
        } finally {
            System.out.println("finally!!");
        }
    }
}
