package LeetCode2;

public class _81_SearchRotatedSortedArray2 {
    public boolean search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0) return false;
        
        int lo = 0;
        int hi = A.length - 1;
        
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(A[mid] == target) return true;
            
            if(A[mid] < A[lo]) {
                if(target > A[mid] && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else if(A[mid] > A[lo]) {
                if(target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                lo++;
            }
        }
        
        return false;
    }
}
