package LeetCode2;


public class _24_SwapNodesInPairs {
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}
	
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre;
        
        while(cur.next != null && cur.next.next != null) {
            cur.next = swap(cur.next, cur.next.next);
            cur = cur.next.next;
        }
        
        return pre.next;
    }
    
    private ListNode swap(ListNode p, ListNode q) {
        p.next = q.next;
        q.next = p;
        return q;
    }
}
