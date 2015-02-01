package com.example.basic.chapter04;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Recipe101Test {

    @Test
    public void 配列を比較したい() {

        int[][] intArray1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] intArray2 = {{1, 2, 3}, {4, 5, 6}};

        // deepEqualsでは2つの配列の要素が同一であるかを比較
        assertThat(Arrays.deepEquals(intArray1, intArray2), is(true));

        // equalsでは2つの配列の参照先が同一であるかを比較
        assertThat(Arrays.equals(intArray1, intArray2), is(false));
        intArray2 = intArray1;
        assertThat(Arrays.equals(intArray1, intArray2), is(true));
    }
}
