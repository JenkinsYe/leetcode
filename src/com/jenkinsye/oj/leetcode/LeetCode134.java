package com.jenkinsye.oj.leetcode;

public class LeetCode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int start = i;
            int cur = start;
            int curGas = gas[i];
            if (curGas < cost[i]) {
                continue;
            }
            curGas -= cost[i];
            cur+=1;
            if (cur == gas.length)
                cur = 0;
            while (cur != start) {
                curGas += gas[cur] - cost[cur];
                if (curGas < 0) {
                    break;
                }
                cur+=1;
                if (cur == gas.length)
                    cur = 0;
            }
            if (cur == start) {
                return start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{2,3,4};
        int[] cost =new int[]{3,4,3};
        System.out.println(new LeetCode134().canCompleteCircuit(gas, cost));
    }
}
