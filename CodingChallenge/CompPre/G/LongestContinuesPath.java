package InterviewQuestions;
/*
给一个树root的pointer，树包含多个分支，树结构要自己创造。求一条最长路径。
例如（括号对应上面node）
树：                  2
      |            |            |                |
     5            7          3                 6
（|       | ）（ | ）（ | ）        （|       |）
  6       3        2         4              5       8
                     |
                     3
返回3因为 （2-3-4） 这条线。优化要求时间O(n)
*/

import java.util.ArrayList;
import java.util.List;

public class LongestContinuesPath {
    
    class TreeNode {
        int val;
        List<TreeNode> children = new ArrayList<TreeNode>();
    }
    
    public int longestContinuousPath(TreeNode root) {
        if(root == null) return 0;
        return longestContinuousPath(root, 1);
    }
    
    public int longestContinuousPath(TreeNode node, int len) {
        int max = 0;
        for(TreeNode child : node.children) {
            if(child == null) continue;  
            int curLen = longestContinuousPath(child, child.val == node.val + 1? len + 1: 1);
            max = Math.max(max, curLen);
        }
        return Math.max(max, len);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
