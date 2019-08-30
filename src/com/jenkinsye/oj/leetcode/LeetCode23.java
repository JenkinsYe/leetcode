import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class LeetCode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < lists.length; i++){
            ListNode temp = lists[i];
            while(temp != null){
                arrayList.add(temp.val);
                temp = temp.next;
            }
        }
        Collections.sort(arrayList);
        for(int i = 0; i < arrayList.size(); i++){
            ListNode temp = new ListNode(arrayList.get(i));
            cur.next = temp;
            cur = cur.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        LeetCode23 leetCode23 = new LeetCode23();

        int[] nums0 = {1, 4, 5};
        int[] nums1 = {1, 3, 4};
        int[] nums2 = {2, 6};
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = ListNode.createList(nums0);
        listNodes[1] = ListNode.createList(nums1);
        listNodes[2] = ListNode.createList(nums2);
        ListNode.printList(leetCode23.mergeKLists(listNodes));
    }
}
