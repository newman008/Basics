package InterviewQuestions;

public class LongestPalindromeSubsequence {

	public int longestPan(String s) {
		return longest(s, 0, s.length() - 1);
	}
	
	private int longest(String s, int l, int r) {
		if(l > r) return 0;
		if(l == r) return 1;
		if(s.charAt(l) == s.charAt(r)) return 2 + longest(s, l+1, r-1);
		else return Math.max(longest(s, l, r-1), longest(s, l+1, r));
	}
	
	public int lps(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for(int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}
		for(int w = 2; w <= n; w++) {
			for(int i = 0; i <= n - w; i++) {
				int j = i + w - 1;
				if(s.charAt(i) == s.charAt(j) && w == 2) dp[i][j] = 2;
				else if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1] + 2;
				else dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
			}
		}
		return dp[0][n-1];
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromeSubsequence t = new LongestPalindromeSubsequence();
		System.out.print(t.lps("BBABCBCAB"));
	}

}
