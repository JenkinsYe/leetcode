package com.jenkinsye.oj.leetcode;

import com.jenkinsye.oj.leetcode.util.TreeNode;

public class LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        return handle(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode handle(int[] preOrder, int[] inOrder, int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart == pEnd) {
            return new TreeNode(preOrder[pStart]);
        }
        if (pStart > pEnd) {
            return null;
        }
        int target = preOrder[pStart];
        int i;
        for (i = iStart; i <= iEnd; i++) {
            if (inOrder[i] == target)
                break;
        }
        TreeNode root = new TreeNode(target);
        root.left = handle(preOrder, inOrder, pStart + 1, pStart + i - iStart, iStart, i - 1);
        root.right = handle(preOrder, inOrder, pEnd - iEnd + i + 1, pEnd, i + 1, iEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{1, 2};
        int[] inOrder = new int[]{2, 1};
        LeetCode105 leetCode105 = new LeetCode105();
        TreeNode root = leetCode105.buildTree(preOrder, inOrder);
        //System.out.println(root.right.val + " " + root.right.left.val + " " + root.right.right.val);
    }
}
