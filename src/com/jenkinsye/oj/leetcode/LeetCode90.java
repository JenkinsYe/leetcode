package com.jenkinsye.oj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int temp = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == temp) {
                count++;
            } else {
                List<List<Integer>> tempResult = new ArrayList<>();
                for (int j = 1; j <= count; j++) {
                    for (int k = 0; k < result.size(); k++) {
                        List<Integer> list = new ArrayList<>(result.get(k));
                        for (int m = 1; m <= j; m++) {
                            list.add(temp);
                        }
                        tempResult.add(list);
                    }
                }
                result.addAll(tempResult);
                temp = nums[i];
                count = 1;
            }
        }
        List<List<Integer>> tempResult = new ArrayList<>();
        for (int j = 1; j <= count; j++) {
            for (int k = 0; k < result.size(); k++) {
                List<Integer> list = new ArrayList<>(result.get(k));
                for (int m = 1; m <= j; m++) {
                    list.add(temp);
                }
                tempResult.add(list);
            }
        }
        result.addAll(tempResult);
        return result;
    }

    public static void main(String[] args) {
        LeetCode90 leetCode90 = new LeetCode90();
        int[] nums = new int[]{1, 2, 2};
        System.out.print(leetCode90.subsetsWithDup(nums).toString());
    }
}
