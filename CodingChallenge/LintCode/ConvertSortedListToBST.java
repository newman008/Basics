package lintCode;

class ListNode {
    int val;
  ListNode next;
  ListNode(int val) {
      this.val = val;
      this.next = null;
  }
}

class TreeNode {
public int val;
public TreeNode left, right;
public TreeNode(int val) {
    this.val = val;
    this.left = this.right = null;
}
}

public class ConvertSortedListToBST {

    
    
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        int l = getLength(head);
        return helper(head, 0, l-1);
    }
    
    public TreeNode helper(ListNode node, int start, int end) {
        if(start > end) return null;
        
        int mid = (start + end) / 2;
        TreeNode left = helper(node, 0, mid - 1);
        TreeNode parent = new TreeNode(node.val);
        parent.left = left;
        
        node = node.next;
        
        TreeNode right = helper(node, mid + 1, end);
        parent.right = right;
        
        return parent;
    }
    
    
    private int getLength(ListNode head) {
        int l = 0;
        ListNode cur = head;
        while(cur != null) {
            l++;
            cur = cur.next;
        }
        return l;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ConvertSortedListToBST t = new ConvertSortedListToBST();
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(8);
        head.next = node1;
        node1.next = node2;
        t.sortedListToBST(head);
        
    }

}
