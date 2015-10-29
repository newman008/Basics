package InterviewQuestions;

class TreeNode{
    int val;
    TreeNode left, right;
    public TreeNode(int x) {
        this.val = x;
    }
}

public class reconstructTree {
    
    
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if(root == null) sb.append("# ");
        else {
            sb.append(root.val + " ");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        reconstructTree t = new reconstructTree();
        System.out.print(t.serialize(root));
    }

}
