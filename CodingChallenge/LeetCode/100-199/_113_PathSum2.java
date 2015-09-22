package LeetCode2;

import java.util.ArrayList;
import java.util.List;

public class _113_PathSum2 {
	public class TreeNode {
	    int val;
	 	TreeNode left;
	 	TreeNode right;
	 	TreeNode(int x) { val = x; }
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        
        dfs(res, cur, root, sum);
        
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> cur, TreeNode root, int sum) {
        if(root == null) return;
        cur.add(root.val);
        if(root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<Integer>(cur));
            cur.remove(cur.size() - 1);
            return;
        }
        else {
            dfs(res, cur, root.left, sum - root.val);
            dfs(res, cur, root.right, sum - root.val);
        }
        cur.remove(cur.size() - 1);
    }
}
