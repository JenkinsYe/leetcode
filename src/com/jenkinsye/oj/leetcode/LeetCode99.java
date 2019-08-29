package com.jenkinsye.oj.leetcode;

import com.jenkinsye.oj.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class LeetCode99 {

    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> inOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            inOrder.add(temp);
            root = temp.right;
        }
        TreeNode temp1, temp2;
        temp1 = temp2 = null;

        for (int i = 0; i < inOrder.size(); i++) {
            System.out.print(inOrder.get(i).val + " ");
        }
        System.out.println();
        for (int i = 0; i < inOrder.size(); i++) {
            if (i == 0) {
                if (inOrder.get(i).val > inOrder.get(i + 1).val) {
                    temp2 = inOrder.get(i);
                }
                continue;
            }
            if (i == inOrder.size() - 1) {
                if (inOrder.get(i).val < inOrder.get(i - 1).val) {
                    temp1 = inOrder.get(i);
                }
                continue;
            }
            if (inOrder.get(i).val < inOrder.get(i-1).val && inOrder.get(i).val < inOrder.get(i+1).val) {
                temp1 = inOrder.get(i);
            }
            if ( temp2 == null && inOrder.get(i).val > inOrder.get(i-1).val && inOrder.get(i).val > inOrder.get(i+1).val) {
                temp2 = inOrder.get(i);
            }
        }
        System.out.println(temp1.val + " " + temp2.val);
        int temp = temp1.val;
        temp1.val = temp2.val;
        temp2.val = temp;
    }

    public static void main(String[] args) {
        LeetCode99 leetCode99 = new LeetCode99();
        TreeNode root = new TreeNode(146);
        root.left = new TreeNode(71);
        root.right = new TreeNode(-13);
        root.left.left = new TreeNode(55);
        root.left.left.left = new TreeNode(321);
        root.left.left.left.left = new TreeNode(-31);
        root.right.right = new TreeNode(399);
        root.right.left = new TreeNode(231);
        leetCode99.recoverTree(root);

    }
}
