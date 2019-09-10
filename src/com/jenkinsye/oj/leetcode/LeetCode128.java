package com.jenkinsye.oj.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        HashSet<Integer> dict = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            dict.add(nums[i]);
        int max = 0;
        for (int integer : nums) {
            if (dict.contains(integer)) {
                int cur = 0;
                while (dict.contains(integer)) {
                    dict.remove(integer);
                    integer--;
                    cur++;
                }
                integer += cur + 1;
                while (dict.contains(integer)) {
                    dict.remove(integer);
                    integer++;
                    cur++;
                }
                max = Math.max(max, cur);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(new LeetCode128().longestConsecutive(nums));
    }
}
