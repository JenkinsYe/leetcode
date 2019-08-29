package com.jenkinsye.oj.leetcode;

import com.jenkinsye.oj.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            int count = queue.size();
            while (count != 0) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                if (level % 2 == 0) {
                    temp.add(treeNode.val);
                } else {
                    ((LinkedList<Integer>) temp).addFirst(treeNode.val);
                }
                count--;
            }
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        LeetCode103 leetCode103 = new LeetCode103();
        System.out.println(leetCode103.zigzagLevelOrder(root).toString());
    }
}
