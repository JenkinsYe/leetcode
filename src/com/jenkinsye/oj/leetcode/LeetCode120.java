package com.jenkinsye.oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 0; i < triangle.size(); i++) {
            if (i == 0)
                continue;
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i-1).get(0) + triangle.get(i).get(j));
                } else if (j == triangle.get(i).size() - 1) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(triangle.get(i-1).size() -1));
                }
                else {
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1)));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < triangle.get(triangle.size() - 1).size(); j++) {
            if (triangle.get(triangle.size() - 1).get(j) < min) {
                min = triangle.get(triangle.size() - 1).get(j);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        LeetCode120 leetCode120 = new LeetCode120();
        List<Integer> list1, list2, list3, list4;
        list1 = new ArrayList<>();
        list1.add(2);
        list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        System.out.println(leetCode120.minimumTotal(triangle));

    }
}
