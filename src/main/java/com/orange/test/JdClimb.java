package com.orange.test;

import java.util.*;

/**
 * Created by zhuningbin on 2016/9/6.
 */
public class JdClimb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> eachDayOfHigh = new HashMap<Integer, Integer>();
        List<Integer> dayList = new ArrayList<Integer>();
        while (scanner.hasNext()) {
            int n = scanner.nextInt();//天数
            int m = scanner.nextInt();//未遗失的记录数
            for (int i = 0; i < m; i++) {
                int d = scanner.nextInt();
                int h = scanner.nextInt();
                dayList.add(i, d);
                eachDayOfHigh.put(d, h);
            }
            System.out.println("n:" + n + " m:" + m);
            for (int i = 0; i < dayList.size(); i++) {
                System.out.print(dayList.get(i) + " ");
            }

            System.out.println();
            System.out.println("-----------");
            for (Map.Entry<Integer, Integer> entry : eachDayOfHigh.entrySet()) {
                System.out.println("map:" + entry.getKey() + " value:" + entry.getValue());
            }
            //对输入的天数排序
            Collections.sort(dayList);

            //1.处理第一个数据到第一天的最大值
            int max = eachDayOfHigh.get(dayList.get(0)) + dayList.get(0) - 1;

            //2.处理中间数据的最大值
            for (int i = 0; i <= dayList.size() - 2; i++) {
                if (Math.abs(eachDayOfHigh.get(dayList.get(i)) - eachDayOfHigh.get(dayList.get(i + 1))) > (dayList.get(i + 1) - dayList.get(i))) {
                    System.out.println("IMPOSSIBLE");
                    System.exit(0);
                } else {
                    //计算中间的最大值
                    int tmp = (eachDayOfHigh.get(dayList.get(i)) + eachDayOfHigh.get(dayList.get(i + 1))) / 2 + (dayList.get(i + 1) - dayList.get(i)) / 2;
                    if (tmp > max) {
                        max = tmp;
                    }
                }
            }
            //3.处理输入最后一个日期到结尾的最大值
            int temp = eachDayOfHigh.get(dayList.get(m - 1)) + (n - dayList.get(m - 1));
            if (temp > max)
                max = temp;
            System.out.println(max);
        }
    }
}
