package com.jenkinsye.oj.leetcode.util;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }

    public static final ListNode createListFromArray(int[] array) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (int i = 0; i < array.length; i++) {
            ListNode temp = new ListNode(array[i]);
            tail.next = temp;
            tail = temp;
        }
        return head.next;
    }

    public static final void printList(ListNode head) {
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static final void printNode(ListNode node) {
        System.out.println(node.val);
    }
}
