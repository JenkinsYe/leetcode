package com.jenkinsye.oj.leetcode;

public class LeetCode80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int target = nums[0];
        int count = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != target) {
                target = nums[i];
                count = 1;
                nums[result++] = target;
            } else {
                if (count == 1) {
                    count++;
                    nums[result++] = target;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode80 leetCode80 = new LeetCode80();
        int[] nums = new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 9};
        System.out.println(leetCode80.removeDuplicates(nums));
    }
}
