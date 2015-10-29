package LeetCode2;

public class _99_RecoverBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;
        
        while(cur != null) {
            if(cur.left == null) {
                if(pre != null && pre.val > cur.val) {
                    if(first == null) first = pre;
                    second = cur;
                }
                pre = cur;
                cur = cur.right;
            }
            else {
                TreeNode t = cur.left;
                while(t.right != null && t.right != cur) {
                    t = t.right;
                }
                if(t.right == null) {
                    t.right = cur;
                    cur = cur.left;
                }
                else {
                    t.right = null;
                    if(pre != null && pre.val > cur.val) {
                        if(first == null) first = pre;
                        second = cur;
                    }
                    pre = cur;
                    cur = cur.right;
                }
            }
        }
        
        // swap two node values;
        if(first!= null && second != null){
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
}
