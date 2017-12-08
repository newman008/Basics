package leetcode;

/** Problem:
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

/** Analysis:
 *  Time  complexity: O()
 *  Space complexity: O()
*/

import java.util.*;

public class _024_swap_nodes_in_paris {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        ListNode cur = head;

        while(cur != null && cur.next != null) {
            pre.next = cur.next;
            ListNode next = cur.next.next;
            cur.next.next = cur;
            cur.next = next;
            cur = next;
        }

        return fakeHead.next;

    }

    public static void main(String[] args) {
    
    } 
}


