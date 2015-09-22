package lintCode;

import java.util.ArrayList;

public class ContinousSubarraySum {
	
	public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        // Write your code here
        ArrayList<Integer> linearRes = new ArrayList<Integer>();
        ArrayList<Integer> cirRes = new ArrayList<Integer>();
        
        if(A == null || A.length == 0) return linearRes;
        
        if(linearMax(A, linearRes) > cirMax(A, cirRes)){
            return linearRes;
        } else 
            return cirRes;
    }
    
    private int linearMax(int[] A, ArrayList<Integer> linearRes){
        int start = 0;
        int end = 0;
        int last = A[0];
        int max = A[0];
        linearRes.add(0);
        linearRes.add(0);
        
        for(int i = 1; i < A.length; i++) {
            if(last < 0) {
                start = i;
                last = A[i];
            } else {
                last = last + A[i];
            }    
            end = i;
            if(last > max) {
                max = last;
                linearRes.clear();
                linearRes.add(start);
                linearRes.add(end);
            }
        }
        
        return max;
        
    }
    
    private int cirMax(int[] A, ArrayList<Integer> cirRes) {
        int[] left = new int[A.length];
        int[] leftIndex = new int[A.length];
        left[0] = A[0];
        leftIndex[0] = 0;
        int sum = A[0];
        
        for(int i = 1; i < A.length; i++) {
            sum += A[i];
            if(sum > left[i-1]){
                left[i] = sum;
                leftIndex[i] = i;
            } else {
                left[i] = left[i-1];
                leftIndex[i] = leftIndex[i-1];
            }
        }
        
        int[] right = new int[A.length];
        int[] rightIndex = new int[A.length];
        int l = A.length;
        sum = A[l-1];
        right[l-1] = sum;
        rightIndex[l-1] = l-1;
        
        for(int i = l-2; i >= 0; i--) {
            sum += A[i];
            if(sum > right[i+1]){
                right[i] = sum;
                rightIndex[i] = i;
            } else {
                right[i] = right[i+1];
                rightIndex[i] = rightIndex[i+1];
            }
        }
        
        int cir_max = Integer.MIN_VALUE;
        for(int i = 0; i < l; i++) {
            if(left[i] + right[i] > cir_max) {
                cir_max = left[i] + right[i];
                cirRes.clear();
                cirRes.add(rightIndex[i]);
                cirRes.add(leftIndex[i]);
            }
        }
        
        return cir_max;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-5,10,5,-3,1,1,1,-2,3,-4};
		ContinousSubarraySum t = new ContinousSubarraySum();
		t.continuousSubarraySumII(nums);
	}

}
