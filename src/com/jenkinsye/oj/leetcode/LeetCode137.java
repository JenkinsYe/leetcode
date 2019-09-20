package com.jenkinsye.oj.leetcode;

public class LeetCode137 {
    public static void main(String[] args) {
        int[] nums=new int[]{0,0,0,1,1,1,3,3,3,4,5,6,6,6,5,5,4,4,7};
        System.out.println(new LeetCode137().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            mask = 1 << i;
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((mask & nums[j]) != 0) {
                    cnt++;
                }
                if (cnt % 3 != 0) {
                    result = result | mask;
                }
            }
        }
        return result;
    }
}
