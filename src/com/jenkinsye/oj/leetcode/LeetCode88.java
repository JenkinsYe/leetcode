package com.jenkinsye.oj.leetcode;

public class LeetCode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m + n - 1;
        m--;
        n--;
        while (m >=0 && n >= 0) {
            if (nums1[m] >= nums2[n]) {
                nums1[total--] = nums1[m--];
            } else {
                nums1[total--] = nums2[n--];
            }
        }

        while (n >= 0) {
            nums1[total--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        LeetCode88 leetCode88 = new LeetCode88();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{};
        leetCode88.merge(nums1, 3, nums2, 0);
        for (int i = 0; i < 6; i++) {
            System.out.print(nums1[i] + " ");
        }
    }
}
