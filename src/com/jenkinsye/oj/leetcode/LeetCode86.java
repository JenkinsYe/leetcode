package com.jenkinsye.oj.leetcode;

import com.jenkinsye.oj.leetcode.util.ListNode;

public class LeetCode86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode smallerHeader = new ListNode(-1);
        ListNode largerHeader = new ListNode(-1);
        ListNode tail1 = smallerHeader;
        ListNode tail2 = largerHeader;

        while (head != null) {
            if (head.val < x) {
                ListNode temp = head;
                head = head.next;
                tail1.next = temp;
                tail1 = temp;
                tail1.next = null;
            } else {
                ListNode temp = head;
                head = head.next;
                tail2.next = temp;
                tail2 = temp;
                tail2.next = null;
            }
        }

        tail1.next = largerHeader.next;

        return smallerHeader.next;
    }

    public static void main(String[] args) {
        LeetCode86 leetCode86 = new LeetCode86();
        ListNode listNode = ListNode.createListFromArray(new int[]{1, 4, 3, 2, 5, 2});
        ListNode.printList(leetCode86.partition(listNode, 3));
    }
}
