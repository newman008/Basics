package LeetCode2;

import java.util.Arrays;


public class _23_MergeKSortedLists {
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        if(lists.length == 2) return mergeTwoLists(lists[0], lists[1]);
        return mergeTwoLists(mergeKLists(Arrays.copyOfRange(lists, 0, lists.length/2)), mergeKLists(Arrays.copyOfRange(lists, lists.length/2, lists.length)));
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        
        if(l1 == null) cur.next = l2;
        if(l2 == null) cur.next = l1;
        
        return pre.next;
    }
}
