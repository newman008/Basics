package LeetCode2;

import LeetCode2._116_PopulatingNextRightPointer.TreeLinkNode;

public class _117_PopulatingNextRightPointer2 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode cur = root;
        TreeLinkNode head = null;
        TreeLinkNode pre = null;
        
        while(cur != null) {
            
            while(cur != null) {
                if(cur.left != null) {
                    if(pre != null) {
                        pre.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    pre = cur.left;
                }
                
                if(cur.right != null) {
                    if(pre != null) {
                        pre.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    pre = cur.right;
                }
                
                cur = cur.next;
            }
            
            cur = head;
            head = null;
            pre = null;
        }
    }
}
