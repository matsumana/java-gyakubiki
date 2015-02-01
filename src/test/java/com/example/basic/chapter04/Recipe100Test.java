package com.example.basic.chapter04;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Recipe100Test {

    @Test
    public void 配列に特定の要素が含まれているか調べたい() {

        int[] array = {30, 10, 20, 15};

        // まず配列をソートしておく
        Arrays.sort(array);

        // 15が格納されたインデックスを取得
        int result1 = Arrays.binarySearch(array, 15);
        assertThat(result1, is(1));

        // 1が格納されたインデックスを取得
        int result2 = Arrays.binarySearch(array, 1);
        assertThat(result2, is(-1));
    }
}
