package LeetCode2;

/*
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 */

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

public class _237_DeleteNodeInLinkedList {
	
	public void deleteNode(ListNode node) {
        if(node == null) return;
        
        if(node.next == null) {
            node = null;
            return;
        } else {
            ListNode next = node.next;
            node.val = next.val;
            node.next = next.next;
            return;
        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
