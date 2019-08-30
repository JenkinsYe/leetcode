public class LeetCode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;
        ListNode cur = head;

        while( k != 0){
            cur = cur.next;
            if(cur == null)
                cur = head;
            k--;
        }
        if(cur == head) return head;

        ListNode cur2 = head;
        ListNode tail = null;
        while(cur != null){
            if(cur.next == null)
                tail = cur2;
            cur2 = cur2.next;
            cur = cur.next;
        }
        tail.next = null;
        cur = cur2;
        while(cur.next != null)
            cur = cur.next;
        cur.next = head;
        return cur2;
    }

    public static void main(String[] args) {
        LeetCode61 leetCode61 = new LeetCode61();
        int[] nums = {1, 2};
        ListNode head = ListNode.createList(nums);
        ListNode.printList(leetCode61.rotateRight(head, 1));
    }
}
