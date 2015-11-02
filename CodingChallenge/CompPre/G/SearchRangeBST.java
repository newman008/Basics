package InterviewQuestions;
/*
Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. 
Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.
 
Example
If k1 = 10 and k2 = 22, then your function should return[12, 20, 22].

    20
   /  \
  8   22
 / \
4   12
*/

import java.util.ArrayList;
import java.util.List;

public class SearchRangeBST {

    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        
        if(root.val < k1) {
            res.addAll(searchRange(root.right, k1, k2));
        } else if(root.val > k2) {
            res.addAll(searchRange(root.left, k1, k2));
        } else {
            res.addAll(searchRange(root.left, k1, root.val));
            res.add(root.val);
            res.addAll(searchRange(root.right, root.val, k2));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SearchRangeBST t = new SearchRangeBST();
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        List<Integer> res = t.searchRange(root, 8, 22);
        for(int n : res) {
            System.out.print(n + " ");
        }
    }

}
