package com.example.basic.chapter04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Recipe112Test {

    @Test
    public void Listと配列を相互に変換したい() {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        String[] array = list.toArray(new String[list.size()]);
        assertThat(Arrays.deepEquals(array, new String[]{"A", "B", "C"}), is(true));

        String[] array1 = {"A", "B", "C", "D"};
        List<String> list1 = Arrays.asList(array1);
        List<String> list2 = Arrays.asList("A", "B", "C", "D");

        for (int i = 0; i < list1.size(); i++) {
            String s1 = list1.get(i);
            String s2 = list2.get(i);

            assertThat(s1.equals(s2), is(true));
        }
    }
}
