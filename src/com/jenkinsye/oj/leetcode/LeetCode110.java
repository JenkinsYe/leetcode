package com.jenkinsye.oj.leetcode;

import com.jenkinsye.oj.leetcode.util.TreeNode;

public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        else return isBalanced(root.left) && isBalanced(root.right) && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        else return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(10);
        root.right = new TreeNode(21);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(8);
        root.right.right.right = new TreeNode(100);
        LeetCode110 leetCode110 = new LeetCode110();
        System.out.println(leetCode110.isBalanced(root));
    }
}
