package LinkedList;

/*
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */

public class _22 {
    public ListNode kthLastElement(ListNode node, int k) {
        if(k <= 0) return null;
        
        ListNode p = node;
        ListNode q = node;
        
        for(int i = 0; i < k - 1; i++) {
            if(q == null) return null;
            q = q.next;
        }
        
        if(q == null) return null;
        
        while(q.next != null) {
            p = p.next;
            q = q.next;
        }
        
        return p;
    }
}
