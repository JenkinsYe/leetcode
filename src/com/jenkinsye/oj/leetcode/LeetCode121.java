package com.jenkinsye.oj.leetcode;

public class LeetCode121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > max){
                max = prices[i] - min;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        LeetCode121 leetCode121 = new LeetCode121();
        System.out.println(leetCode121.maxProfit(prices));
    }
}
