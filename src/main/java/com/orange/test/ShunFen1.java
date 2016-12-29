package com.orange.test;

import java.util.Scanner;

/**
 * Created by znb on 16-9-21.
 */
public class ShunFen1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.nextInt()!=0){
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i=0;i<n;i++){
                nums[i]=in.nextInt();
            }

            int min=0;
            for (int i=0;i<nums.length;i++){
                for (int j=i+1;j<nums.length;j++){
                    if (min>nums[j]){
                        min=nums[j];
                    }
                }
            }

        }
    }
}
