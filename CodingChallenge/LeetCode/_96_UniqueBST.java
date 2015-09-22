package LeetCode2;

public class _96_UniqueBST {
	public int numTrees(int n) {
        int[] num = new int[n+1];
        num[0] = 1;
        num[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                num[i] += num[j] * num[i-j-1];
            }
        }
        
        return num[n];
    }
}
