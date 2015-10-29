package InterviewQuestions;

public class FencePainter {

    public int num_colors(int n, int k) {
        if(n <= 0 || k <= 0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k * k;
        for(int i = 3; i <= n; i++) {
            dp[i] = (k-1) * (dp[i-1] + dp[i-2]);
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
