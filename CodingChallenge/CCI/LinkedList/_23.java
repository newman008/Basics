package LinkedList;

/*
 * Implement an algorithm to delete a node in the middle of a singly linked list, 
 * given only access to that node.
 */

public class _23 {
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
}
