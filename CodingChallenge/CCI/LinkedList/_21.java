package LinkedList;

import java.util.*;

/*
 * Write code to remove duplicates from an unsorted linked list.
 * How would you solve this problem if a temporary buffer is not allowed?
 */

class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) {
		 val = x;
	     next = null;
	 }
}

public class _21 {
	public void removeDuplicate2(ListNode node) {
		if(node == null || node.next == null) return;
		
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(node.val);
		
		while(node.next != null) {
			if(set.contains(node.next.val)){
				node.next = node.next.next;
			} else {
				set.add(node.next.val);
				node = node.next;
			}
		}
	}
	
	public void removeDuplicated(ListNode node) {
		if(node == null || node.next == null) return;
		
		ListNode cur = node;
		while(cur != null) {
			ListNode runner = cur;
			while(runner.next != null) {
				if(runner.next.val == cur.val){
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			
			cur = cur.next;
		}
	}
}
