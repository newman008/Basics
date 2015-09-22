package LeetCode2;

/*
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 * Return the total number of ways you can paint the fence.
 */

public class _276_PaintFence {
	
	public int numWays(int n, int k) {
        if(n == 0 || k == 0) return 0;
        if(n == 1) return k;
        
        int same = k;
        int diff = k * (k-1);
        
        for(int i = 2; i < n; i++) {
            int tmp = diff;
            diff = (same + diff) * (k-1);
            same = tmp;
        }
        
        return same + diff;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
