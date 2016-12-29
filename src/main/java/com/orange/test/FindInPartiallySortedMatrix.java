package com.orange.test;

/**
 * Created by Administrator on 2016/9/15.
 * 面试题3：二维数组中的查找
 * 查找二维数组中是否存在某个数字，二维数组已经按照一定的顺序排列好
 */
public class FindInPartiallySortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(FindLeftDownNum(matrix, 4, 4, 3));
    }

    /**
     * 采取从右上角数字开始比
     *
     * @param matrix
     * @param rows
     * @param columns
     * @param number
     * @return
     */
    public static boolean Find(int[][] matrix, int rows, int columns, int number) {
        boolean find = false;
        if (matrix != null && rows > 0 && columns > 0) {
            int row = 0;
            int column = columns - 1;
            while (row < rows && column >= 0) {
                if (matrix[row][column] == number) {
                    find = true;
                    break;
                } else if (matrix[row][column] > number) {
                    --column;
                } else {
                    ++row;
                }
            }
        }
        return find;
    }

    /**
     * 从左下角数字开始比较
     *
     * @param matrix
     * @param rows
     * @param colums
     * @param number
     * @return
     */
    public static boolean FindLeftDownNum(int[][] matrix, int rows, int colums, int number) {
        boolean found = false;
        if (matrix != null && rows > 0 && colums > 0) {
            int row = rows - 1;
            int colum = 0;
            while (row >= 0 && colum < colums) {
                if (matrix[row][colum] == number) {
                    found = true;
                    break;
                } else if (matrix[row][colum] > number) {
                    --row;
                } else {
                    ++colum;
                }
            }
        }
        return found;
    }
}
