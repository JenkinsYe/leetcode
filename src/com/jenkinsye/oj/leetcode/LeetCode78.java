package com.jenkinsye.oj.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultSet = new ArrayList<>();
        List<Integer> emptySet = new ArrayList<>();
        resultSet.add(emptySet);
        if (nums.length == 0) return resultSet;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            List<List<Integer>> tempResultSet = new ArrayList<>();
            for (int j = 0; j < resultSet.size(); j++) {
                List<Integer> tempList = new ArrayList<>(resultSet.get(j));
                tempList.add(temp);
                tempResultSet.add(tempList);
            }
            resultSet.addAll(tempResultSet);
        }
        return resultSet;
    }

    public static void main(String[] args) {
        LeetCode78 leetCode78 = new LeetCode78();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(leetCode78.subsets(nums).toString());
    }

}
