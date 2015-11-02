package InterviewQuestions;
/*
Given K discrete events with different probabilities P[k], produce a random value k consistent with its probability.
discrete random variable distribution, generate random number.
比如 给你 [0.2, 0.3, 0.5] 输出0 with probability 0.2, 1 with prob 0.3, 2 with prob 0.5
Follow up : how to speed up
*/

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
