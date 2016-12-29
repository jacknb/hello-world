package com.orange.test;

/**
 * Created by zhuningbin on 2016/9/1.
 */
public class SubSumClass extends ParentClass {
    public int i = 30;

    public static void main(String[] args) {
        ParentClass parentClass = new ParentClass();
        SubSumClass subSumClass = new SubSumClass();
        System.out.println(parentClass.i + subSumClass.i);
    }
}

class ParentClass {
    public int i = 10;
}