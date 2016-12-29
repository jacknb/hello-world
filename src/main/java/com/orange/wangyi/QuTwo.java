package com.orange.wangyi;

/**
 * Created by Administrator on 2016/9/23.
 */
public class QuTwo {
    public static void main(String[] args) {


        /*Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();

        }*/
        System.out.println(foo(3,5));
    }

    public static int foo(int x,int y){
        if (x<=0||y<=0)
            return 1;
        return 3*foo(x-1,y/2);
    }
}
