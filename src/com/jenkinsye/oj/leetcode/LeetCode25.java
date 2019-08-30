package com.jenkinsye.oj.leetcode;
import com.jenkinsye.oj.leetcode.util.ListNode;

public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head == null) return head;
        ListNode dummyHeader = new ListNode(-1);
        dummyHeader.next = head;
        int count = 0;
        ListNode slow = dummyHeader;
        ListNode fast = dummyHeader;
        ListNode last = dummyHeader;
        while(fast.next != null){
            fast = fast.next;
            count++;
            if(count == k){
                count = 0;
                ListNode temp2 = slow.next;
                slow = slow.next.next;
                temp2.next = fast.next;
                fast.next = null;
                while (slow != null){
                    ListNode trans = slow;
                    slow = slow.next;
                    trans.next =last.next;
                    last.next = trans;
                }
                last = slow = fast = temp2;
            }
        }
        return dummyHeader.next;
    }

    public static void main(String[] args) {
        LeetCode25 leetCode25 = new LeetCode25();
        int[] nums = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.createListFromArray(nums);
        int k = 3;
        ListNode.printList(leetCode25.reverseKGroup(listNode, k));
    }
}
