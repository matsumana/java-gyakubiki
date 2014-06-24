package com.example.basic.chapter02;

import org.junit.Test;

import java.security.SecureRandom;
import java.util.Random;

public class Recipe060Test {

    @Test
    public void 通常の乱数生成() throws Exception {

        // Math#dandom()は0〜1のdouble値を生成する
        double d1 = Math.random();
        double d2 = Math.random();
        System.out.println(d1);
        System.out.println(d2);
    }

    @Test
    public void セキュリティを意識した乱数生成() throws Exception {

        // Math#dandom()は線形合同法というアルゴリズムを元に乱数を生成している
        // そのため、出力された値からシードを予測し、次の値を推測する事が可能
        // より複雑な乱数を生成するにはjava.security.SecureRandomクラスを使う事

        // アルゴリズム指定なし
        Random r1 = new SecureRandom();
        int value1 = r1.nextInt();
        int value2 = r1.nextInt();
        System.out.println(value1);
        System.out.println(value2);

        // アルゴリズム指定あり
        Random r2 = SecureRandom.getInstance("SHA1PRNG");
        int value3 = r2.nextInt();
        int value4 = r2.nextInt();
        System.out.println(value3);
        System.out.println(value4);
    }
}
