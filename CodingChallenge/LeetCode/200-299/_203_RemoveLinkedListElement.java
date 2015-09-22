package LeetCode2;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class _203_RemoveLinkedListElement {
	
	public ListNode removeElements(ListNode head, int val) {
	if(head == null) return null;
	
	ListNode fakeHead = new ListNode(0);
	fakeHead.next = head;
	ListNode pre = fakeHead;
	ListNode cur = head;
	while(cur != null) {
		if(cur.val == val) {
			pre.next = cur.next;
			cur = cur.next;
			continue;
		} else {
			pre = pre.next;
			cur = cur.next;
		}
	}
	
	return fakeHead.next;
    }
}
