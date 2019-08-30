package com.jenkinsye.oj.leetcode;

import com.jenkinsye.oj.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), result);
        return result;
    }

    public void dfs(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> result) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                temp.add(root.val);
                result.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            }
        }
        temp.add(root.val);
        dfs(root.right, sum - root.val, temp, result);
        dfs(root.left, sum - root.val, temp, result);
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        LeetCode113 leetCode113 = new LeetCode113();
        System.out.println(leetCode113.pathSum(root, 22));
    }
}
