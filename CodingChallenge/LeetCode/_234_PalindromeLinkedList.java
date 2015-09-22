package LeetCode2;

public class _234_PalindromeLinkedList {
	
	public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = slow.next;
        slow.next = null;
        
        head2 = reverse(head2);
        while(head != null && head2 != null) {
            if(head.val != head2.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        if(head.next == null) return head;
        ListNode fakeHead = new ListNode(0);
        while(head != null) {
            ListNode tmp = fakeHead.next;
            ListNode next = head.next;
            head.next = tmp;
            fakeHead.next = head;
            head= next;
        }
        return fakeHead.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
