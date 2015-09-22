package LeetCode2;

import LeetCode2._24_SwapNodesInPairs.ListNode;

public class _25_ReverseNodesInKGroup {
	
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        
        ListNode cur = head;
        int count = 1;
        while(cur.next != null) {
            count++;
            cur = cur.next;
        }
        
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode nxt = null;
        
        while(count >= k) {
            cur = pre.next;
            nxt = cur.next;
            for(int i = 1; i < k; i++) {
                cur.next = nxt.next;
                nxt.next = pre.next;
                pre.next = nxt;
                nxt = cur.next;
            }
            pre = cur;
            count -= k;
        }
        
        return preHead.next;
    }
}
