package Amazon;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int v) {
        this.val = v;
    }
}

public class LongestDistanceBetweenLeaf {
    
    int max = 0;
    
    public int numberOfNodes(TreeNode root){
        maxPathCount(root);
        return max;
    }
    
    private int maxPathCount(TreeNode root) {
        if(root == null) return 0;
        
        int left = maxPathCount(root.left);
        int right = maxPathCount(root.right);
        
        max = Math.max(max, left + 1 + right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
