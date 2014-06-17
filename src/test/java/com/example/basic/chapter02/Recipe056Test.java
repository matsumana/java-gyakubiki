package com.example.basic.chapter02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Recipe056Test {

    @Test
    public void 正規表現で文字列を検索する() throws Exception {
        Pattern pattern = Pattern.compile("Recipe.");
        Matcher matcher = pattern.matcher("Java Recipe has many Recipes!");

        // 正規表現にヒットした単語の取り出し
        List<String> actual = new ArrayList<>();
        while (matcher.find()) {
            // group()メソッドを呼び出して、正規表現にヒットした文字列を取り出す
            String group = matcher.group();
            actual.add(group);
        }

        assertThat(actual.get(0), is("Recipe "));
        assertThat(actual.get(1), is("Recipes"));
    }

    @Test
    public void マッチした文字列の一部を取得する() throws Exception {
        Pattern pattern = Pattern.compile("(.*):(.*)");
        Matcher matcher = pattern.matcher("Java Recipe : many Recipes!");

        // 正規表現にヒットした単語の取り出し
        List<String> actual = new ArrayList<>();
        if (matcher.find()) {

            // group()メソッドに0を渡すと全体を取得
            assertThat(matcher.group(0), is("Java Recipe : many Recipes!"));

            // １つ目のグループにマッチした部分を取得
            assertThat(matcher.group(1), is("Java Recipe "));

            // ２つ目のグループにマッチした部分を取得
            assertThat(matcher.group(2), is(" many Recipes!"));
        }

    }
}
