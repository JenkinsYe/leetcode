package com.jenkinsye.oj.leetcode;

import com.jenkinsye.oj.leetcode.util.ListNode;

public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        ListNode dummyHeader = new ListNode(-1);
        dummyHeader.next = head;
        ListNode temp = dummyHeader;
        m--;
        while (m > 0) {
            temp =temp.next;
            m--;
            n--;
        }
        ListNode tail1 = temp.next;
        ListNode cur = temp.next;
        while (n > 0) {
            ListNode move = cur;
            cur = cur.next;
            move.next = temp.next;
            temp.next = move;
            n--;
        }
        tail1.next = cur;
        return dummyHeader.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.createListFromArray(new int[]{1,2,3,4,5});
        ListNode.printList(new LeetCode92().reverseBetween(listNode, 1 ,2));
    }
}
