package InterviewQuestions;

import java.util.Arrays;
import java.util.Random;

public class DiscreteRandomVar {

	public static int discreteRandom(double[] nums) {
		int n = nums.length;
		double[] C = new double[n+1];
		for(int i = 1; i <= n; i++) {
			C[i] = C[i-1] + nums[i-1];
		}
		double r = new Random().nextDouble();
		int lo = 0;
		int hi = n-1;
		while(lo <= hi) {
			int mid = (lo + hi) / 2;
			if(r >= C[mid] && r < C[mid+1]) return mid;
			else if(r < C[mid]) hi = mid - 1;
			else lo = mid + 1;
		}
		
		return lo;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] B = {0.2, 0.3, 0.5};  
	    int[] D = {0, 0, 0};  
	    for(int i=1; i<1000; i++) {  
	        D[discreteRandom(B)]++;  
	    }  
	    System.out.println(Arrays.toString(D)); 

	}

}
