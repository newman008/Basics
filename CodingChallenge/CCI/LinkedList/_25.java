package LinkedList;

/*
 * You have two numbers represented by a linked list, where each node contains a single digit. 
 * The digits are stored in reverse order, such that the 1 's digit is at the head of the list. 
 * Write a function that adds the two numbers and returns the sum as a linked list.
 */

public class _25 {
	
	public ListNode addLists(ListNode l1, ListNode l2) {
		
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		int carry = 0;
		ListNode fakeHead = new ListNode(0);
		ListNode pre = fakeHead;
		
		while(l1 != null || l2 != null || carry != 0){
			int v1 = l1 == null? 0 : l1.val;
			int v2 = l2 == null? 0 : l2.val;
			int cur = (v1 + v2 + carry) % 10;
			
			ListNode curNode = new ListNode(cur);
			pre.next = curNode;
			pre = curNode;
			
			carry = cur / 10;
			l1 = l1 == null? null : l1.next;
			l2 = l2 == null? null : l2.next;
		}
		
		return fakeHead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
