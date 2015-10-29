package LeetCode2;

public class _141_LinkedListCycle {
    class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
    }
    
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        
        return false;
    }
}
