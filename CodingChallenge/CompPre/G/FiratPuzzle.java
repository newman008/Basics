package InterviewQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
 *  Given an expression with unnecessary parenthesis, remove the unnecessary parenthesis
 * 
 */

public class FiratPuzzle {
	
	class TreeNode {
		String val;
		TreeNode left;
		TreeNode right;
		public TreeNode(String val) {
			this.val = val;
		}
	}
	
	public String removeParenthesis(TreeNode root) {
		if(root == null) return "";
		if(!isOps(root.val)) return root.val;
		
		String left = new String();
		if(!isOps(root.left.val)){
			left = root.left.val;
		} else if(order(root.left.val) < order(root.val)){
			left = "(" + removeParenthesis(root.left) + ")";
		} else
			left = removeParenthesis(root.left);
		
		String right = new String();
		if(!isOps(root.right.val)){
			right = root.right.val;
		} else if(order(root.right.val) < order(root.val)){
			right = "(" + removeParenthesis(root.right) + ")";
		} else 
			right = removeParenthesis(root.right);
		
		return left + root.val + right;
	}
	
	private boolean isOps(String str) {
        if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("(") || str.equals(")"))
            return true;
        else
            return false;
    }
	
	private int order(String a) {  
        if (a.equals("*") || a.equals("/")) {  
            return 2;  
        } else if (a.equals("+") || a.equals("-")) {  
            return 1;  
        } else {  
            return 0;  
        }  
    } 
	
	public TreeNode buildExpressionTree(String expression) {
		if(expression == null || expression.length() == 0) return null;
		
		String[] exps = expression.split(" ");
		Stack<String> opStack = new Stack<String>();
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		
		for(String exp : exps) {
			if(exp.equals("(")) opStack.push(exp);
			else if(!isOps(exp)) {
				TreeNode node = new TreeNode(exp);
				nodeStack.push(node);
			} else if(exp.equals(")")) {
				while(!opStack.peek().equals("(")){
					TreeNode node = new TreeNode(opStack.pop());
					node.right = nodeStack.pop();
					node.left = nodeStack.pop();
					nodeStack.push(node);
				}
				opStack.pop(); // pop "("
			} else {
				while(!opStack.isEmpty() && order(exp) <= order(opStack.peek())){
					TreeNode node = new TreeNode(opStack.pop());
					node.right = nodeStack.pop();
					node.left = nodeStack.pop();
					nodeStack.push(node);
				}
				opStack.push(exp);
			}
		}
		
		while(!opStack.isEmpty()){
			TreeNode node = new TreeNode(opStack.pop());
            node.right = nodeStack.pop();
            node.left = nodeStack.pop();
            nodeStack.push(node);
        }
		
		return nodeStack.isEmpty()? null : nodeStack.pop();
	}
	
	public void levelOrder(TreeNode root) {
		if(root == null) return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			Queue<TreeNode> next = new LinkedList<TreeNode>();
			String level = new String();
			for(TreeNode node : q) {
				level = level + " " + node.val;
				if(node.left != null) next.offer(node.left);
				if(node.right != null) next.offer(node.right);
			}
			System.out.println(level);
			q = next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FiratPuzzle f = new FiratPuzzle();
//		String s = new String("( 3 + 5 ) * 6 + 7 / 5 - ( 4 + 4 )");
		String s1 = "( 3 * 5 ) + ( 6 + 7 ) * 6";
		TreeNode root = f.buildExpressionTree(s1);
//		f.levelOrder(root);
		System.out.println(f.removeParenthesis(root));
	}

}
