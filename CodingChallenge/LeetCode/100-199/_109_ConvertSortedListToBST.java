package LeetCode2;

import LeetCode2._108_ConvertSortedArrayToBST.TreeNode;

public class _109_ConvertSortedListToBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    private ListNode node;
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode cur = head;
        node = head;
        int size = 0;
        while(cur!= null) {
            cur = cur.next;
            size++;
        }
        return helper(0, size-1);
    }
    
    public TreeNode helper(int start, int end) {
        if(start > end) return null;
        
        int mid = (start + end) / 2;
        TreeNode left = helper(start, mid - 1);
        TreeNode root = new TreeNode(node.val);
        root.left = left;
        
        node = node.next;
        
        TreeNode right = helper(mid+1, end);
        root.right = right;
        
        return root;
    }
}
