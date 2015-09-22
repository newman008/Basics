package LinkedList;

/*
 * Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
 */

public class _26 {
	
	public ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null) return null;
		boolean hasCycle = false;
		
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				hasCycle = true;
				break;
			}
		}
		
		if(!hasCycle) return null;
		
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
