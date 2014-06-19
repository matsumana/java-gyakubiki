package com.example.basic.chapter02;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Recipe057Test {

    // StringクラスのreplaceやreplaceAllでも同じ事が出来ますが、
    // 内部でPatternクラスのcompileを実行しているので、
    // ループ内で使う場合は正規表現クラスを使い、Patternクラスのcompileをループの外で行いましょう。

    @Test
    public void 最初にヒットした文字列だけを置換() throws Exception {
        String replaceString = "レシピ ";
        Pattern pattern = Pattern.compile("Recipe.");
        Matcher matcher = pattern.matcher("Java Recipe has many Recipes!!");
        String actual = matcher.replaceFirst(replaceString);

        assertThat(actual, is("Java レシピ has many Recipes!!"));

        // 続けてMatcherのインスタンスを使いまわす場合、resetして移動したシーケンスを戻す必要あり
//        matcher.reset();
    }

    @Test
    public void ヒットした文字列すべてを置換() throws Exception {
        String replaceString = "レシピ ";
        Pattern pattern = Pattern.compile("Recipe.");
        Matcher matcher = pattern.matcher("Java Recipe has many Recipes!!");
        String actual = matcher.replaceAll(replaceString);

        assertThat(actual, is("Java レシピ has many レシピ !!"));

        // 続けてMatcherのインスタンスを使いまわす場合、resetして移動したシーケンスを戻す必要あり
//        matcher.reset();
    }

    @Test
    public void ヒットするごとに処理を実施() throws Exception {
        String replaceString = "レシピ ";
        Pattern pattern = Pattern.compile("Recipe.");
        Matcher matcher = pattern.matcher("Java Recipe has many Recipes!!");

        StringBuffer replacedString = new StringBuffer();
        while (matcher.find()) {
            // ヒットした対象を置換して追加
            // １回目に追加される文字列 -> "Java レシピ "
            // 2回目に追加される文字列  -> "has many レシピ "
            matcher.appendReplacement(replacedString, replaceString);
        }

        // 最後にヒットした部分以降の文字列を結合
        // ここで追加される文字列 -> "!!"
        StringBuffer actual = matcher.appendTail(replacedString);

        assertThat(actual.toString(), is("Java レシピ has many レシピ !!"));

        // 続けてMatcherのインスタンスを使いまわす場合、resetして移動したシーケンスを戻す必要あり
//        matcher.reset();
    }
}
