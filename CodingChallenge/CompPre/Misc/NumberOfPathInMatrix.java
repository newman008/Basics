package Misc;

public class NumberOfPathInMatrix {
    
    static int numberOfPaths(int [][]a,int M,int N) {
        // dp
        if(a[0][0] == 0) return 0;
        int mod = 1000000007;
        
        int[][] dp = new int[M][N];
        dp[0][0] = 1;
        for(int i = 1; i < M; i++) {
            if(a[i][0] == 0) dp[i][0] = 0;
            else dp[i][0] = dp[i-1][0];
        }
        for(int j = 1; j < N; j++) {
            if(a[0][j] == 0) dp[0][j] = 0;
            else dp[0][j] = dp[0][j-1];
        }
        
        for(int i = 1; i < M; i++) {
            for(int j = 1; j < N; j++) {
                if(a[i][j] == 1) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    dp[i][j] %= mod;
                }
                    
            }
        }
        
        return dp[M-1][N-1];
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
