package com.orange.test;

/**
 * Created by zhuningbin on 2016/9/8.
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 7, 1, 9};
//        insertSort(arr);
        shellSort(arr);
        for (int ar : arr) {
            System.out.print(ar);
        }
    }

    /**
     * 直接插入排序
     *
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr) {
        int j;
        for (int p = 1; p < arr.length; p++) {
            int tmp = arr[p];
            for (j = p; j > 0 && tmp < arr[j - 1]; j--)
                arr[j] = arr[j - 1];
            arr[j] = tmp;
        }
        return arr;
    }

    public static int[] shellSort(int[] arr) {
        int j;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                for (j = i; j >= gap && tmp < arr[j - gap]; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = tmp;
            }
        }
        return arr;
    }
}
