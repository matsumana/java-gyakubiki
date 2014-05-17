package com.example.java8.chapter02;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class Recipe023Test {

    @Test
    public void Optionalな変数からgetで値を取得する() throws Exception {
        Optional<String> optional = Optional.ofNullable("123");
        assertThat(optional.get(), is("123"));
    }

    @Test(expected = NullPointerException.class)
    public void Optionalな変数にnullを代入する事は可能() throws Exception {
        Optional<String> optional = null;
        System.out.printf(optional.get());  // ここでNullPointerExceptionが発生する
        fail();
    }

    @Test(expected = NullPointerException.class)
    public void ofメソッドにnullを渡すと例外が発生する() throws Exception {
        Optional<String> optional = Optional.of(null);  // ここでNullPointerExceptionが発生する
        fail();

        // ※ofは一切使わずに、全てofNullableを使った方が良いのかな？？？
    }

    @Test(expected = NoSuchElementException.class)
    public void 空のOptionalからgetで値を取り出すとNoSuchElementExceptionが発生する() throws Exception {
        Optional<String> optional = Optional.empty();
        System.out.printf(optional.get());  // ここでNoSuchElementExceptionが発生する

        // isPresentメソッドかifPresentメソッドを使い、空のOptionalかどうか判定する必要がある。
    }

    @Test
    public void ofNullableを使えば値がnullの場合は空のOptionalが生成される() throws Exception {
        // 空のOptional
        Optional<String> optional = Optional.ofNullable(null);
        if (optional.isPresent()) {
            fail();
        }

        // 値を持つOptional
        optional = Optional.ofNullable("123");
        if (optional.isPresent()) {
            assertThat(optional.get(), is("123"));
        }

        // ifPresentを使えば、値を持つ場合のみ実行される処理をラムダ式で書ける
        optional.ifPresent(s -> assertThat(s, is("123")));
    }

    @Test
    public void 空のOptionalの場合orElseやorElseGetで任意の値を返す事が出来る() throws Exception {
        Optional<String> optional = Optional.empty();

        assertThat(optional.orElse("abc"), is("abc"));

        // orElseGetは処理をラムダ式で書ける
        assertThat(optional.orElseGet(() -> {
            return "def";
        }), is("def"));
    }

    @Test(expected = RuntimeException.class)
    public void orElseThrowを使えば空のOptionalの場合例外をスロー出来る() throws Throwable {
        Optional<String> optional = Optional.empty();

        // ※orElseThrowはチェック例外をスローされるのでcatchかthrowsしないといけない
        optional.orElseThrow(() -> {
            throw new RuntimeException("orElseThrowでスローした例外");
        });
    }

    @Test
    public void Optionalに対してmapを実行する() throws Throwable {
        Optional<String> optional = Optional.ofNullable("abc123");
        Optional<String> mapped = optional.map(s -> s.toUpperCase());

        assertThat(optional.get(), is("abc123"));
        assertThat(mapped.get(), is("ABC123"));
    }

    @Test
    public void Optionalに対してmapを実行する_引数に指定したラムダ式がnullを返す場合は空のOptionalが返される() throws Throwable {
        Optional<String> optional = Optional.ofNullable("abc123");
        Optional<String> mapped = optional.map(s -> null);

        if (mapped.isPresent()) {
            fail();
        }
    }

    @Test
    public void Optionalに対してflatMapを実行する() throws Throwable {
        // flatMapメソッドはmapメソッドに似ているが、引数に渡すラムダ式はOptionalを返すようにする。
        // ラムダ式の返したOptionalがflatMapメソッドの戻り値となるが、
        // 空のOptionalに対してflatMapメソッドを呼び出した場合はmapメソッドと同様にラムダ式は実行されず、空のOptionalが戻り値となる。
        // この性質を利用することで、複数のOptionalから値を取り出す処理を以下のように記述出来る。

        // ※mapメソッドはOptionalを返す

        Optional<String> userName = Optional.ofNullable("user01");
        Optional<String> password = Optional.ofNullable("hoge");

        boolean isValid = userName.flatMap(u -> {
            // flatMapの戻り値はOptionalにする必要がある
            return password.map(p -> {
                return u.equals("user01") && p.equals("hoge");
            });
        }).orElse(false);

        assertThat(isValid, is(true));
    }
}
