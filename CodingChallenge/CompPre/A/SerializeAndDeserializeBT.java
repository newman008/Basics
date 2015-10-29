package Amazon;
/*
 * pre-order traversal
 * level-order traversal
 */

public class SerializeAndDeserializeBT {
    
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private static void serialize(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("# ");
            return;
        }
        
        sb.append(root.val + " ");
        //if(root.left == null && root.right == null) return;
        serialize(root.left, sb);
        serialize(root.right, sb);
    }
    
    static int index = 0;
    
    public static TreeNode deserialize(String str) {
        String[] strs = str.split(" ");
        return deserialize(strs);
    }
    
    public static TreeNode deserialize(String[] strs) {
        if(index >= strs.length) return null;
        if(strs[index].equals("#")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[index]));
        index++;
        root.left = deserialize(strs);
        root.right = deserialize(strs);
        
        return root;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*
         *  1
         *  | \
         *  2  3
         *  |  |\
         *  4  5 6
         *       |
         *       7
         *  => 1 2 4 # # # 3 5 # # 6 7 # # #    
         */ 
        
        String str = "1 2 4 # # # 3 5 # # 6 7 # # #";
        TreeNode res = SerializeAndDeserializeBT.deserialize(str);
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
//      root.left.left.left = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        System.out.println(SerializeAndDeserializeBT.serialize(root));
        
        
        
        
    }

}
