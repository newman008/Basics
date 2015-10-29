package LeetCode2;

public class _116_PopulatingNextRightPointer {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode start = root;
        TreeLinkNode cur = null;
        
        while(start.left != null) {
            cur = start;
            while(cur != null) {
                cur.left.next = cur.right;
                if(cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            
            start = start.left;
        }
    }
}
