package com.jenkinsye.oj.leetcode;

import com.jenkinsye.oj.leetcode.util.TreeNode;

public class LeetCode124 {
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        LeetCode124 leetCode124 = new LeetCode124();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        /*root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);*/
        System.out.println(leetCode124.maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return max;
    }

    /**
     * 必定包含root节点的最大权重
     * @param root
     * @return
     */
    public int getMax(TreeNode root) {
        if (root == null)
            return 0;
        int ls = Math.max(0, getMax(root.left));
        int rs = Math.max(0, getMax(root.right));
        max = Math.max(max, root.val + ls + rs);
        return root.val + Math.max(ls, rs);
    }
}
