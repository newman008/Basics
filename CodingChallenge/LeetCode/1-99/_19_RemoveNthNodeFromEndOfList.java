package LeetCode2;

public class _19_RemoveNthNodeFromEndOfList {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode cur = head;
        ListNode pre = head;
        
        while(n != 0) {
            cur = cur.next;
            n--;
        }
        
        if(cur == null) return head.next;
        
        while(cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        
        pre.next = pre.next.next;
        return head;
    }
}
