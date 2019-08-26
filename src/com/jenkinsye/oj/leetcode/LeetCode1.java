package com.jenkinsye.oj.leetcode;

import java.util.HashMap;

public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dict.containsKey(target - nums[i])) {
                return new int[]{dict.get(target - nums[i]), i};
            } else {
                dict.put(nums[i], i);
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        LeetCode1 leetCode1 = new LeetCode1();
        System.out.println(leetCode1.twoSum(nums, target).toString());
    }
}
