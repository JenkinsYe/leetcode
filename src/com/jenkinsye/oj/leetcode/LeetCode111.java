package com.jenkinsye.oj.leetcode;

import com.jenkinsye.oj.leetcode.util.TreeNode;

public class LeetCode111 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        if (root.left != null && root.right == null)
            return minDepth(root.left) + 1;
        if (root.left == null && root.right != null)
            return minDepth(root.right) + 1;
        else return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
    }
}
