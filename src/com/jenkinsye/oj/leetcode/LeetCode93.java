package com.jenkinsye.oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode93 {
    public List<String> restoreIpAddresses(String s) {
        int[] offset = new int[]{0, 0, 0};
        List<String> result = new ArrayList<>();
        dfs(result, s, 0, offset);
        return result;
    }

    private void dfs(List<String> result, String s, int count, int[] offset) {
        if (count == 3) {
            String last = s.substring(offset[2]);
            if (isLegal(last)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(s.substring(0, offset[0]) + '.');
                stringBuilder.append(s.substring(offset[0], offset[1]) + '.');
                stringBuilder.append(s.substring(offset[1], offset[2]) + '.');
                stringBuilder.append(last);
                result.add(stringBuilder.toString());
            }
        } else {
            for (int i = 1; i <= 3; i++) {
                int start = count != 0 ? offset[count - 1] : 0;
                if (start + i > s.length()) break;
                if (isLegal(s.substring(start, start + i))) {
                    offset[count] = start + i;
                    dfs(result, s,count + 1, offset);
                }
            }
        }
    }

    private boolean isLegal(String s) {
        if (s.length() == 0) return false;
        if (s.equals("0")) return true;
        if (s.length() < 3 && !s.startsWith("0")) return true;
        else if (s.length() == 3 && !s.startsWith("0")) {
            return s.compareTo("255") <= 0;
        } else return false;
    }

    public static void main(String[] args) {
        LeetCode93 leetCode93 = new LeetCode93();
        System.out.println(leetCode93.restoreIpAddresses("1111").toString());
    }
}
