package leetcode;

/** Problem:
Reverse a singly linked list.
*/

/** Analysis:
 *  Time  complexity: O(N)
 *  Space complexity: O(1)
*/

import java.util.*;

public class _206_reverse_linked_list {
    // iterative
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fakeHead = new ListNode(0);
        while(head != null) {
            ListNode tmp = fakeHead.next;
            ListNode next = head.next;
            head.next = tmp;
            fakeHead.next = head;
            head = next;
        }
        return fakeHead.next;
    }
    
    // recursive
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        _206_reverse_linked_list s = new _206_reverse_linked_list();
        ListNode head = s.reverseList(Utils.generateLinkedListFromArray(new int[]{1, 2, 3, 4, 5}));
        Utils.printIntLinkedList(head);
    } 
}


