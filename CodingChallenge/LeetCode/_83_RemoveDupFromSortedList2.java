package LeetCode2;

public class _83_RemoveDupFromSortedList2 {
	public class ListNode {
		int val;
 		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head == null || head.next == null) return head;
        
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        
        ListNode pre = fakeHead;
        int count = 1;
        while(head.next != null) {
            if(head.next.val == head.val) {
                count++;
                if(head.next.next == null) {
                    pre.next = null;
                }
            }
            else {
                if(count > 1) {
                    pre.next = head.next;
                    count = 1;
                }
                else {
                    pre = head;
                }
            }
            
            head = head.next;
        }
        
        return fakeHead.next;
    }
	
	public ListNode deleteDuplicates2(ListNode head) {
        // write your code here
        if(head == null || head.next == null) return head;
        
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        
        ListNode pre = fakeHead;
        while(head != null) {
            while(head.next != null && head.next.val == head.val) {
                head = head.next;
            }
            if(pre.next == head) {
                pre = pre.next;
            } else {
                pre.next = head.next;
            }
            
            head = head.next;
        }
        
        return fakeHead.next;
    }
}
