package com.orange.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by adelmo on 2016/8/31.
 * 3. Longest Substring Without Repeating Characters
 */
public class LeetCode3 {

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
        System.out.println(lengthOfLongestSubstring1(str));
    }

    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int[] countTable = new int[256];
        Arrays.fill(countTable, -1);
        int max = 1;
        int start = 0;
        int end = 1;

        countTable[s.charAt(0)] = 0;
        while (end < length) {
            //Has not reached a duplicate char
            if (countTable[s.charAt(end)] >= start) {
                start = countTable[s.charAt(end)] + 1;
            }
            max = Math.max(max, end - start + 1);
            countTable[s.charAt(end)] = end;
            end++;
        }
        return max;
    }
}
