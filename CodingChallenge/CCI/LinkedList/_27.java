package LinkedList;

import java.util.*;

/*
 * Implement a function to check if a linked list is a palindrome,
 */

public class _27 {
    
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack<Integer>();
        
        while(fast.next != null && fast.next.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast.next != null){
            stack.push(slow.val);   
        } 
        slow = slow.next;
        
        while(slow != null) {
            if(stack.pop() != slow.val) return false;
            slow = slow.next;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int[] array = {1, 2, 3, 3, 4, 2, 1, 0};
        for(int i : array) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        System.out.println(_27.isPalindrome(head));

    }

}
