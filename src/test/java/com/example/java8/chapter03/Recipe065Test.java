package com.example.java8.chapter03;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Recipe065Test {

    public interface HelloWorld {
        default public String hello(String name) {
            return "Hello " + name;
        }
    }

    public interface HeyWorld {
        default public String hello(String name) {
            return "Hey " + name;
        }
    }

    public static class HelloWorldImpl implements HelloWorld {
    }

    public static class HelloHeyWorldImpl implements HelloWorld, HeyWorld {
        @Override
        public String hello(String name) {
            // HeyWorldのデフォルトメソッドを明示的に実行
            return HeyWorld.super.hello(name);
        }
    }

    public static class HelloWorldJapaneseImpl implements HelloWorld {
        @Override
        public String hello(String name) {
            return "やぁ " + name;
        }
    }

    public static class ChaoWorld {
        public String hello(String name) {
            return "Chao " + name;
        }
    }

    public static class ChaoHelloWorld extends ChaoWorld implements HelloWorld {
    }

    @Test
    public void デフォルトメソッドのテスト() throws Exception {
        // デフォルト実装が呼ばれる
        assertThat(new HelloWorldImpl().hello("hoge"), is("Hello hoge"));
    }

    @Test
    public void デフォルトメソッドをオーバーライドするのテスト() throws Exception {
        // デフォルト実装が呼ばれる
        assertThat(new HelloWorldJapaneseImpl().hello("hoge"), is("やぁ hoge"));
    }

    @Test
    public void 同じデフォルトメソッドを持つインターフェースを複数implementsする場合はオーバーライドしないとコンパイルエラーになる() throws Exception {
        // デフォルト実装が呼ばれる
        assertThat(new HelloHeyWorldImpl().hello("hoge"), is("Hey hoge"));
    }

    @Test
    public void 親クラスとインターフェースのデフォルトメソッドで同じシグネチャがある場合は親クラスが持つメソッドが実行される() throws Exception {
        // Class Always Win.
        assertThat(new ChaoHelloWorld().hello("hoge"), is("Chao hoge"));
    }
}
