package LeetCode2;

public class _147_InsertionSortList {
	public class ListNode {
		int val;
		ListNode next;
	 	ListNode(int x) { val = x; }
	}
	
	public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode newHead = new ListNode(0);
        ListNode pre = newHead;
        ListNode cur = head;
        
        while(cur != null) {
            ListNode next = cur.next;
            pre = newHead;
            
            while(pre.next != null && pre.next.val <= cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            
            cur = next;
        }
        
        return newHead.next;
    }
}
