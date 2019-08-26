package com.jenkinsye.oj.leetcode;

import com.jenkinsye.oj.leetcode.util.ListNode;

public class LeetCode83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode dummyHeader = new ListNode(-1);
        dummyHeader.next = head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (fast.val != slow.val) {
                fast = fast.next;
                slow = slow.next;
            } else {
                while (fast != null && fast.val == slow.val){
                    fast = fast.next;
                }
                slow.next = fast;
            }
        }
        return dummyHeader.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.createListFromArray(new int[]{1, 1, 1, 2, 3, 3});
        LeetCode83 leetCode83 = new LeetCode83();
        ListNode.printList(leetCode83.deleteDuplicates(listNode));
    }
}
