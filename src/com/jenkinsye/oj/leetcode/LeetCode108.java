package com.jenkinsye.oj.leetcode;

import com.jenkinsye.oj.leetcode.util.TreeNode;

public class LeetCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return handle(nums, 0 ,nums.length - 1);
    }

    public TreeNode handle(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = handle(nums, start, mid - 1);
        root.right = handle(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        LeetCode108 leetCode108 = new LeetCode108();
        int[] nums = new int[]{-10 , -3, 0, 5, 9};
        TreeNode root = leetCode108.sortedArrayToBST(nums);
        System.out.println(root.val);
    }
}
