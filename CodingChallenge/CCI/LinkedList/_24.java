package LinkedList;

/*
 * Write code to partition a linked list around a value x, 
 * such that all nodes less than x come before all nodes greater than or equal to x.
 */

public class _24 {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        
        ListNode fakehead = new ListNode(0);
        fakehead.next = head;
        ListNode cur = fakehead;
        ListNode pre = fakehead;
        
        
        while(cur.next != null) {
            if(cur.next.val < x) {
                if(pre == cur) {
                    cur = cur.next;
                    pre = pre.next;
                } else {
                    ListNode next = cur.next.next;
                    cur.next.next = pre.next;
                    pre.next = cur.next;
                    cur.next = next;
                    pre = pre.next;
                }
            }
            else {
                cur = cur.next;
            }
            
        }
        
        return fakehead.next;
    }
    
    public ListNode partition2(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        
        while(head != null) {
            if(head.val < x) {
                cur1.next = head;
                cur1 = head;
            } else {
                cur2.next = head;
                cur2 = head;
            }
            head = head.next;
        }
        
        cur2.next = null;
        cur1.next = l2.next;
        return l1.next;
        
    }
}
