package LeetCode2;

public class _82_RemoveDupFromSortedList {
    public class ListNode {
        int val;
        ListNode next;
            ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if(head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        
        while(cur != null) {
//            if(cur.val == pre.val) {
//                pre.next = cur.next;
//                cur = cur.next;
//            } else {
//                pre = pre.next;
//                cur = cur.next;
//            }
                if(cur.val != pre.val) {
                    pre.next = cur;
                    pre = cur;
                }
                cur = cur.next;
        }
        
        return head;
    } 
}
