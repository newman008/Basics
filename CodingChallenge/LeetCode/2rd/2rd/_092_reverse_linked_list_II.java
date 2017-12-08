package leetcode;

/** Problem:
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.
*/

/** Analysis:
 *  Time  complexity: O(N)
 *  Space complexity: O(1)
*/

import java.util.*;

public class _092_reverse_linked_list_II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;

        for(int i = 1; i < m; i++) {
            pre = pre.next;
        }

        ListNode tail = pre.next;
        ListNode cur = pre.next.next;

        for(int i = 0; i < n - m; i++) {
            tail.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = tail.next;
        }

        return fakeHead.next;
    }

    public static void main(String[] args) {
        _092_reverse_linked_list_II s = new _092_reverse_linked_list_II();
        ListNode testNode = Utils.generateLinkedListFromArray(new int[]{1, 2, 3, 4, 5});
        s.reverseBetween(testNode, 2, 4);
        Utils.printIntLinkedList(testNode);
    } 
}
