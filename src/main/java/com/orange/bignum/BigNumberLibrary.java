package com.orange.bignum;

import java.math.BigInteger;

/**
 * Created by znb on 17-9-8.
 * 大数加、减、乘、除、取模运算
 */
public class BigNumberLibrary {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("232091389120839021830912839012839012");
        BigInteger bigInteger1 = new BigInteger("9890283019283100012313123123131231312312");

        System.out.println("两个大数的计算");
        BigInteger addNum = bigInteger.add(bigInteger1);
        BigInteger subNum = bigInteger1.subtract(bigInteger);
        BigInteger mulNum = bigInteger.multiply(bigInteger1);
        BigInteger divNum = bigInteger1.divide(bigInteger);
        BigInteger remNum = bigInteger.remainder(bigInteger1);

        System.out.println("Add :"+addNum);
        System.out.println("subtract :"+subNum);
        System.out.println("multiply :"+mulNum);
        System.out.println("divide :"+divNum);
        System.out.println("remainder :"+remNum);
    }
}
