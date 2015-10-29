package Amazon;

public class BTPreNextNode {
    
    public TreeNode nextNode(TreeNode root, TreeNode node) {
        if(node.right != null) {
            return smallest(node.right);
        }
        TreeNode next = null;
        TreeNode runner = root;
        while(runner != null) {
            if(runner.val > node.val) {
                next = runner;
                runner = runner.left;
            } else if(runner.val < node.val) {
                runner = runner.right;
            }
            else break;
        }
        return next;
    }
    
    private TreeNode smallest(TreeNode node) {
        TreeNode runner = node;
        while(runner.left != null) {
            runner = runner.left;
        }
        return runner;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
