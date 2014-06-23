package com.example.basic.chapter02;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Recipe055Test {

    @Test
    public void 文字列が正規表現に一致するかどうか() throws Exception {
        Pattern pattern = Pattern.compile("^\\[INFO\\]");
        Matcher matcher = pattern.matcher("[INFO]info massage");
        boolean actual = matcher.find();

        assertThat(actual, is(true));
    }

    @Test
    public void 文字列が正規表現に一致するかどうか_囲んだ部分をエスケープ() throws Exception {
        // \Qと|Eで囲んだ部分をエスケープできる
        Pattern pattern = Pattern.compile("^\\Q[INFO]\\E");
        Matcher matcher = pattern.matcher("[INFO]info massage");
        boolean actual = matcher.find();

        assertThat(actual, is(true));
    }

    @Test
    public void compileメソッドに指定できるフラグ_大文字と小文字を区別しないマッチング() throws Exception {
        // 大文字と共地を区別しないマッチング （UNICODE_CASEなどもある）
        Pattern pattern = Pattern.compile("^\\Q[info]\\E", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("[INFO]info massage");
        boolean actual = matcher.find();

        assertThat(actual, is(true));
    }

    @Test
    public void compileメソッドに指定できるフラグ_複数行モード() throws Exception {
        {
            // 複数行モード
            Pattern pattern = Pattern.compile("^fuga", Pattern.MULTILINE);
            Matcher matcher = pattern.matcher("hoge\nfuga\npiyo");
            boolean actual = matcher.find();

            // 1行でもマッチすれがtrue
            assertThat(actual, is(true));
        }
        {
            Pattern pattern = Pattern.compile("^fuga");
            Matcher matcher = pattern.matcher("hoge\nfuga\npiyo");
            boolean actual = matcher.find();

            // デフォルトのモードではマッチしない
            assertThat(actual, is(false));
        }
    }

    @Test
    public void compileメソッドに指定できるフラグ_ドットを改行にもマッチさせるモード() throws Exception {
        Pattern pattern = Pattern.compile("^\\Q[INFO]\\E.*Hoge$", Pattern.DOTALL);
        Matcher matcher = pattern.matcher("[INFO]info massage\nHoge");
        boolean actual = matcher.find();

        assertThat(actual, is(true));
    }
}
