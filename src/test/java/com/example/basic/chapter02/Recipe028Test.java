package com.example.basic.chapter02;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class Recipe028Test {

    @Test
    public void Java7からはswitch_caseに文字列を指定可能() throws Exception {

        String str = "abc";
        String ret;

        switch (str) {
            case "a":
            case "b":
                ret = "aまたはbです";
                break;
            case "c":
                ret = "cです";
                break;
            case "abc":
                ret = "abcです";
                break;
            default:
                ret = "その他です";
        }

        assertThat(ret, is("abcです"));
    }

    @Test(expected = NullPointerException.class)
    public void 評価対象がnullの場合はNullPointerExceptionが発生する() throws Exception {

        String str = null;

        switch (str) {
            case "a":
            case "b":
                System.out.printf("aまたはbです");
                break;
            case "c":
                System.out.printf("cです");
                break;
            case "abc":
                System.out.printf("abcです");
                break;
            default:
                System.out.printf("その他です");
        }

        fail();
    }

    @Test
    public void 評価対象がnullの場合はif_else_switchを使うと安全() throws Exception {

        String str = null;
        String ret;

        if (str == null) {
            ret = "nullです";
        } else {
            switch (str) {
                case "a":
                case "b":
                    ret = "aまたはbです";
                    break;
                case "c":
                    ret = "cです";
                    break;
                case "abc":
                    ret = "abcです";
                    break;
                default:
                    ret = "その他です";
            }
        }

        assertThat(ret, is("nullです"));
    }
}
