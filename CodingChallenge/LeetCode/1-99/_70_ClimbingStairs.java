package LeetCode2;

public class _70_ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 0 || n == 1) return n;
        
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= n; i++) {
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }
}
