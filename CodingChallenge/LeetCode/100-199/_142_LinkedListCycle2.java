package LeetCode2;

public class _142_LinkedListCycle2 {
    class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
    }
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        boolean hasCycle = false;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                hasCycle = true;
                break;
            }
        }
        
        if(!hasCycle) return null;
        
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
        
    }
}
