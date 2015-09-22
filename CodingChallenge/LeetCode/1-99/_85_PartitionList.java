package LeetCode2;

public class _85_PartitionList {
	public class ListNode {
		int val;
 		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        
        ListNode fakehead = new ListNode(0);
        fakehead.next = head;
        ListNode cur = fakehead;
        ListNode pre = fakehead;
        
        
        while(cur.next != null) {
            if(cur.next.val < x) {
                if(pre == cur) {
                    cur = cur.next;
                    pre = pre.next;
                } else {
                    ListNode next = cur.next.next;
                    cur.next.next = pre.next;
                    pre.next = cur.next;
                    cur.next = next;
                    pre = pre.next;
                }
            }
            else {
                cur = cur.next;
            }
            
        }
        
        return fakehead.next;
    }
}
