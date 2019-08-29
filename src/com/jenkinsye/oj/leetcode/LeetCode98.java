package com.jenkinsye.oj.leetcode;

import com.jenkinsye.oj.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class LeetCode98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        ArrayList<Integer> inOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            inOrder.add(temp.val);
            root = temp.right;
        }
        if (inOrder.size() == 1)
            return true;
        for (int i = 1; i < inOrder.size(); i++) {
            if (inOrder.get(i) <= inOrder.get(i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode98 leetCode98 = new LeetCode98();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        System.out.println(leetCode98.isValidBST(root));
    }
}
