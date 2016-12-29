package com.orange.test;

import java.util.*;

/**
 * Created by Administrator on 2016/9/4.
 */
public class CardTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int t = scanner.nextInt();//数据组数
            Map<Integer, List<Integer>> listMap = new HashMap<Integer, List<Integer>>();
            for (int i = 1; i <= t; i++) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                List<Integer> resultList = new ArrayList<Integer>();
                for (int j = 0; j < 2 * n; j++) {
                    resultList.add(scanner.nextInt());
                }
                for (int l = 0; l < k; l++) {
                    resultList = shuffer(resultList);
                }
                listMap.put(i, resultList);
            }
            for (Map.Entry<Integer, List<Integer>> entry : listMap.entrySet()) {
                for (int i = 0; i < entry.getValue().size(); i++) {
                    if (i == entry.getValue().size() - 1) {
                        System.out.print(entry.getValue().get(i));
                    } else {
                        System.out.print(entry.getValue().get(i) + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    private static List<Integer> shuffer(List<Integer> list) {
        Stack<Integer> stack = new Stack<Integer>();
        int start = list.size() / 2 - 1;
        int end = list.size() - 1;
        while (start >= 0 && end >= list.size() / 2) {
            stack.push(list.get(end));
            stack.push(list.get(start));
            end--;
            start--;
        }
        list.clear();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
