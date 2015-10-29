package LeetCode2;

public class _148_SortList {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    private ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode left = head;
        
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }
    
    private ListNode merge(ListNode left, ListNode right){
        ListNode result = new ListNode(0);
        ListNode tail = result;
        
        while(left != null && right != null){
            if(left.val < right.val){
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if(left != null){
            tail.next = left;
        } else {
            tail.next = right;
        }
        
        return result.next;
    }
}
