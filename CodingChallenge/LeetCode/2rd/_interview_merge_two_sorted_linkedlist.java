package leetcode;

/**
 * Problem:
 * Merge two sorted linkedlists to one list, remove duplicates
 *
 * Deal with ambiguity
 * 1. return an ArrayList or LinkedList?
 * 2. order, increasing or decreasing?
 * 3. Does the passed linkedlist contain duplicates? no
 *
 * Question about the code:
 * 1. Do we have to handle edge case in the beginning? can we cover them together with general cases
 * 2. Do we have to use if/else if/else in the main part?
 * 3. Can we use if/else handling tail cases
 *
 * Test Cases:
 * 1. {1, 2, 4} {3, 5} 
 * 2. {1, 2, 4, 6} {3}
 * 3. {} {}
 * 4. {} {1, 3, 5, 6}
 * 5. {1, 4, 6} {}
 * 6. {1, 3, 5} {2, 3}
 * 7. {1, 3, 5} {2, 5}
 * 8. {1, 4, 5} {1, 2, 7}
 *
 */

public class _interview_merge_two_sorted_linkedlist {
    public ListNode mergeTwoSortedLinkedLists(ListNode l1, ListNode l2) {
        //if (l1 == null) return l2;
        //if (l2 == null) return l1;

        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1; 
                cur = l1;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            } else {
                l1 = l1.next;
            }
        }
        if(l1 == null)
            cur.next = l2;
        if(l2 == null)
            cur.next = l1;

        return pre.next;
    }

    public static void main(String[] args) {
        _interview_merge_two_sorted_linkedlist s = new _interview_merge_two_sorted_linkedlist();
        ListNode l1 = Utils.generateLinkedListFromArray(new int[]{1, 2, 3, 4, 5, 6});
        ListNode l2 = Utils.generateLinkedListFromArray(new int[]{1, 2, 3, 5, 6});
        ListNode l3 = null;
        ListNode l4 = null;
        ListNode res = s.mergeTwoSortedLinkedLists(l2, l4);
        Utils.printIntLinkedList(res);
    }
}
