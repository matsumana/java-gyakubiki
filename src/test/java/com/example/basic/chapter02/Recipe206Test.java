package com.example.basic.chapter02;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Recipe206Test {

    @Test
    public void ファイルの内容を文字列で読み込みたい() throws Exception {

        // カレントディレクトリにあるファイルを読む
        Path path = FileSystems.getDefault().getPath(
                getClass().getResource("").getFile(),
                "test.txt");

        // FileInputStream, FileOutputStreamを使用し、明示的にエンコーディングを指定する
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(path.toFile()), UTF_8))) {

            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
