package com.jenkinsye.oj.leetcode;

public class LeetCode96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode96 leetCode96 = new LeetCode96();
        System.out.println(leetCode96.numTrees(3));
    }
}
