package LeetCode2;

/*
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 */

public class _270_ClosestBSTValue {
	public int closestValue(TreeNode root, double target) {
        double distance = Math.abs(root.val - target);
        int res = root.val;

        while(root != null) {
        	if(root.val >= target) {
        		if(Math.abs(root.val - target) < distance) {
        			distance = Math.abs(root.val - target);
        			res = root.val;
        		}
        		root = root.left;
        	} else {
        		if(Math.abs(root.val - target) < distance) {
        			distance = Math.abs(root.val - target);
        			res = root.val;
        		}
        		root = root.right;
        	}
        }

        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
