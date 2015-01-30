package com.example.basic.chapter03;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Recipe076Test {

    public interface Color {
        String getColor();
    }

    public enum Sex implements Color {
        MAN {
            @Override
            public String getColor() {
                return "青";
            }
        },
        WOMAN {
            @Override
            public String getColor() {
                return "赤";
            }
        }
    }

    @Test
    public void enum定数ごとにメソッドをオーバーライドしたい() {
        Color color1 = Sex.MAN;
        assertThat(color1.getColor(), is("青"));

        Color color2 = Sex.WOMAN;
        assertThat(color2.getColor(), is("赤"));
    }
}

