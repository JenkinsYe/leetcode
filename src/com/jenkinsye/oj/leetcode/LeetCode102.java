package com.jenkinsye.oj.leetcode;

import com.jenkinsye.oj.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!(queue1.isEmpty() && queue2.isEmpty())) {
            List<Integer> temp = new ArrayList<>();
            while (!queue1.isEmpty()) {
                TreeNode treeNode = queue1.poll();
                temp.add(treeNode.val);
                if (treeNode.left != null) {
                    queue2.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue2.offer(treeNode.right);
                }
            }
            result.add(temp);
            queue1 = queue2;
            queue2 = new LinkedList<>();
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        LeetCode102 leetCode102 = new LeetCode102();
        System.out.println(leetCode102.levelOrder(root).toString());
    }
}
