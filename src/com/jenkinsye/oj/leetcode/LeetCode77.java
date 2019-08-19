package com.jenkinsye.oj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Integer[] temp = new Integer[k];
        boolean[] flag = new boolean[n];
        for (int i = 0; i < k; i++) {
            flag[i] = false;
            temp[i] = 0;
        }
        dfs(flag, temp, 0, n, k, result);
        return result;
    }

    public void dfs(boolean[] flag, Integer[] temp, int index, int n, int k, List<List<Integer>> result) {
        if(index == k){
            ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(temp));
            result.add(arrayList);
            return;
        }
        for (int i = (index == 0 ? 0 : temp[index - 1]); i < n; i++) {
            if (!flag[i]) {
                flag[i] = true;
                temp[index] = i+1;
                dfs(flag, temp, index+1, n, k, result);
                flag[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode77 leetCode77 = new LeetCode77();
        System.out.println(leetCode77.combine(4, 2).toString());
    }
}
