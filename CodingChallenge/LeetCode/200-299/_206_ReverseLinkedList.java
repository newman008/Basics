package LeetCode2;

public class _206_ReverseLinkedList {
	
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}
	public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }
    
    private ListNode reverse(ListNode newHead, ListNode head) {
        if(head == null) return newHead;
        ListNode cur = head.next;
        head.next = newHead;
        return reverse(head, cur);
    }
    
    // iterate 
    public ListNode reverseList2(ListNode head) {
        ListNode newHead = null;
        while(head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }
}
