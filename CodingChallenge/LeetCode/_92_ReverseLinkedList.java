package LeetCode2;

public class _92_ReverseLinkedList {
	public class ListNode {
			int val;
		 	ListNode next;
		 	ListNode(int x) {
			val = x;
			next = null;
		 }
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakehead = new ListNode(0);
        fakehead.next = head;
        ListNode cur = head;
        ListNode pre = fakehead;
        ListNode tail = null;
        
        for(int i = 1; i < m; i++) {
            cur = cur.next;
            pre = pre.next;
        }
        
        tail = cur;
        
        for(int i = m + 1; i <= n; i++) {
            pre.next = tail.next;
            tail.next = tail.next.next;
            pre.next.next = cur;
            cur = pre.next;
        }
        
        return fakehead.next;
    }
}
