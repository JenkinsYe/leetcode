package com.jenkinsye.oj.leetcode;

import com.jenkinsye.oj.leetcode.util.TreeNode;

public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return compareTree(root.left, root.right);
    }

    public boolean compareTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 != null && root2 != null) {
            if (root1.val != root2.val)
                return false;
            return compareTree(root1.left, root2.right) && compareTree(root1.right, root2.left);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
