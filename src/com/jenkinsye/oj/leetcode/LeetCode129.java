package com.jenkinsye.oj.leetcode;

import com.jenkinsye.oj.leetcode.util.TreeNode;

public class LeetCode129 {
    public static int result = 0;

    public int sumNumbers(TreeNode root) {
        result = 0;
        sum(root, 0);
        return result;
    }

    public void sum(TreeNode root, int temp) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            System.out.println(root.val + temp);
            result += root.val + temp;
        } else {
            int nSum = (temp + root.val) * 10;
            sum(root.left, nSum);
            sum(root.right, nSum);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(new LeetCode129().sumNumbers(root));
    }
}
