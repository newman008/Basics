package LeetCode2;

/*
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Follow up:
Could you do it using only constant space complexity?
 */

public class _255_VerifyPreorderSequenceInBST {
	public boolean verifyPreorder(int[] preorder) {
        int min = Integer.MIN_VALUE;
        // Stack<Integer> stack = new Stack<Integer>();
        // use the array as stack
        
        int i = -1;
        for(int num : preorder) {
            if(num < min) return false;
            // while(!stack.isEmpty() && num > stack.peek()){
            //     min = stack.pop();
            // }
            // stack.push(num);
            while(i >= 0 && num > preorder[i]){
                min = preorder[i--];
            }
            
            preorder[++i] = num;
        }
        
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
