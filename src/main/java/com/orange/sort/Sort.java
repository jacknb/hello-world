package com.orange.sort;

/**
 * Created by znb on 16-10-10.
 * 排序算法
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = {43, 38, 49, 55, 30};
        selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    private static int[] insertSort(int[] arr) {
        int j;
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            for (j = i; j > 0 && arr[j - 1] > tmp; j--) {
                //后移
                arr[j] = arr[j - 1];
            }
            //替换
            arr[j] = tmp;
        }
        return arr;
    }

    /**
     * 希尔排序
     *
     * @param arr
     * @return
     */
    public static int[] shellSort(int[] arr) {
        for (int r = arr.length / 2; r > 0; r /= 2) {
            for (int i = r; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - r;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + r] = arr[j];
                    j -= r;
                }
                //交换
                arr[j + r] = tmp;
            }
        }
        return arr;
    }

    /**
     * 折半插入排序
     *
     * @param arr
     * @return
     */
    public static int[] bInsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int low = 0, high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] > tmp)
                    high = mid - 1;
                else
                    low = mid + 1;
            }

            for (int j = i - 1; j >= high + 1; --j) {
                //记录后移
                arr[j + 1] = arr[j];
            }
            //插入
            arr[high + 1] = tmp;
        }
        return arr;
    }

    /**
     * 直接选择排序
     *
     * @param arr
     * @return
     */
    public static int[] selectSort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (i != min) {
                //交换
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        return arr;
    }
}
