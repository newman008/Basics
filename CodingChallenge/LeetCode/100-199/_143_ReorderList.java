package LeetCode2;

public class _143_ReorderList {
    class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        // find the middle
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        
        // reverse the second half
        ListNode pre = null;
        ListNode cur = mid;
        while(cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        
        // merge
        ListNode p1 = head;
        ListNode p2 = pre;
        
        while(p2 != null) {
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;

            p1.next = p2;
            p2.next = temp1;        

            p1 = temp1;
            p2 = temp2;
        }
    }
}
