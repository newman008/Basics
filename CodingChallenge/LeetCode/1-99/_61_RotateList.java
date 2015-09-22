package LeetCode2;

public class _61_RotateList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        
        int len = 1;
        ListNode tail = head;
        while(tail.next != null) {
            len++;
            tail = tail.next;
        }
        k = k % len;
        tail.next = head;
        
        for(int i = 0; i < len - k - 1; i++){
            head = head.next;
        }
        
        tail = head;
        head = head.next;
        tail.next = null;
        
        return head;
    }
}
