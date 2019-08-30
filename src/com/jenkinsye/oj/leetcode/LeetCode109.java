package com.jenkinsye.oj.leetcode;

import com.jenkinsye.oj.leetcode.util.ListNode;
import com.jenkinsye.oj.leetcode.util.TreeNode;

public class LeetCode109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);
        ListNode pre = head;
        ListNode slow = head.next;
        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {
            pre = pre.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createListFromArray(new int[]{-10, -3, 0, 5, 9});
        LeetCode109 leetCode109 = new LeetCode109();
        TreeNode root = leetCode109.sortedListToBST(head);
        System.out.println(root.val + " " + root.left.val + " " + root.right.val);
    }
}
