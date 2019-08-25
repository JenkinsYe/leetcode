package com.jenkinsye.oj.leetcode;

import com.jenkinsye.oj.leetcode.util.ListNode;

public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode phead = new ListNode( - 1);
        phead.next = head;
        ListNode slow = phead;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            if (fast.val != fast.next.val) {
                slow = fast;
                fast = fast.next;
            } else {
                while (fast != null && fast.val == slow.next.val) {
                    fast = fast.next;
                }
                slow.next = fast;
            }
        }
        return phead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.createListFromArray(new int[]{1, 1, 1, 2, 3, 3});
        LeetCode82 leetCode82 = new LeetCode82();
        ListNode.printList(leetCode82.deleteDuplicates(listNode));
    }
}
