package InterviewQuestions;

import java.util.Stack;
import java.util.PriorityQueue;

public class MergeStones{
    public int minCost(int[] A){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int num : A){
		   //System.out.println(num);
		   pq.add(num);
		}

		//System.out.println(pq.size());
		int sum = 0;
		for(int i = 0; i < A.length - 1; i++){
		   //System.out.println(pq.peek());
		   int local = pq.poll() + pq.poll();
		   sum += local;
		   pq.add(local);
		}
		return pq.peek();
    }

    // dp[i][j] = 0(i == j)
    // dp[i][j] = min{dp[i, k], dp[k+1, j]} + sum[i, j] (i != j)

    public int minCostLinear(int[] A) {
		int n = A.length;
		int[][] dp = new int[n][n];
		int[] sum = new int[n];
		
		for(int i = 0; i < n; i++) {
			if(i == 0) sum[i] = A[i];
			else sum[i] = sum[i-1] + A[i];
		}    

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == j) dp[i][j] = 0;
				else dp[i][j] = Integer.MAX_VALUE;
			}
		}

		for(int w = 2; w <= n; w++) {
			for(int i = 0; i <= n-w; i++) {
				int j = i + w - 1;
				int sumij = sum[j] - (i>0?sum[i-1]:0); 
				for(int k = i; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + sumij);
				}
			}
		}

		return dp[0][n-1];
    }
    
    //dp[i][j] means cost from A[i] and later j nums, total num is j + 1;
    //getSum(i, j) means sum of nums[i] + ... + nums[i+j];
    
    public int minCostCircle(int[] A) {
    		int n = A.length;
		int[][] dp = new int[n][n];
		int[] sum = new int[n];
		for(int i = 0; i < n; i++) {
			if(i == 0) sum[i] = A[i];
			else sum[i] = sum[i-1] + A[i];
		} 
		
		for(int i = 0; i < n; i++) {
			dp[i][0] = 0;
		}
		
		for(int j = 1; j < n; j++) {
			for(int i = 0; i < n; i++) {
//				int j = i + w - 1;
				dp[i][j] = Integer.MAX_VALUE;
				int sumij = getSum(sum, i, j);
				//System.out.print(sumij + " ");
				for(int k = 0; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[(i+k+1) % n][j-k-1] + sumij);
				}
			}
		}
		
		int min = dp[0][n-1];
		for(int i = 1; i < n; i++) {
			min = Math.min(min, dp[i][n-1]);
		}
		
		return min;
    }
    
    private int getSum(int[] sum, int i, int j) {
    		if(i + j < sum.length) return sum[i+j] - (i>0? sum[i-1] : 0);
    		else return getSum(sum, i, sum.length-i-1) + getSum(sum, 0, (i+j) % sum.length);
    }

    public static void main(String[] args){
        int[] nums = new int[]{7,6,5,7,100};
		MergeStones t = new MergeStones();
//		System.out.println(t.minCost(nums));
//		System.out.println(t.minCostLinear(nums));
		System.out.println(t.minCostCircle(nums));
	}
}
