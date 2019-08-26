package com.jenkinsye.oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode89 {

    /**
     * 格雷码生成过程 G(i) = i ^ (i / 2)
     * <li>
     *     for(int i = 0; i < 1 << n; i++) {
     *         result.add(i ^ i>>1);
     *     }
     * </li>
     * */
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        } else {
            List<Integer> result = grayCode(n - 1);
            int size = result.size();
            for (int i = size - 1; i >= 0; i--) {
                result.add(result.get(i) + (int)Math.pow(2, n - 1));
            }
            return result;
        }
    }

    public static void main(String[] args) {
        LeetCode89 leetCode89 = new LeetCode89();
        System.out.print(leetCode89.grayCode(3).toString());
    }
}
