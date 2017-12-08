package leetcode;

/** Problem:
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

/** Analysis:
Time  complexity: O(max(m, n)), m and n represents the length of l1 and l2
Space complexity: O(max(m, n))
*/

import java.util.*;

public class _002_add_two_numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
         
        ListNode fakeNode = new ListNode(0);
        ListNode pre = fakeNode;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int curValue = (l1 == null? 0 : l1.val) + (l2 == null? 0 : l2.val) + carry;
            ListNode cur = new ListNode(curValue % 10);
            pre.next = cur;
            pre = cur;

            carry = curValue / 10;
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
        }

        return fakeNode.next;
    } 

    public static void main(String[] args) {
        _002_add_two_numbers s = new _002_add_two_numbers();
        int[] arrayA = new int[]{2, 4, 3};
        int[] arrayB = new int[]{5, 6, 4};
        ListNode l1 = Utils.generateLinkedListFromArray(arrayA);
        ListNode l2 = Utils.generateLinkedListFromArray(arrayB);
        ListNode res = s.addTwoNumbers(l1, l2);
        Utils.printIntLinkedList(res);        
    } 
}
