package InterviewQuestions;

// Given a 2D array, find the maximum sum subarray in it.

public class MaximumSubMatrixSum {
    
    public int maxSubmatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            int[] array = new int[m];
            for(int j = i; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    array[k] += matrix[k][j];
                }
                int localmax = maxSubarraySum(array);
                max = Math.max(max, localmax);
            }
        }
        
        return max;
    }
    
    private int maxSubarraySum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int local = 0;
        for(int i = 0; i < nums.length; i++) {
            local = Math.max(nums[i], local+nums[i]);
            max = Math.max(local, max);
        }
        return max;
    }
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = new int[][]{{2, -1, -3, -4, 5}, {0, 6, 3, 4, 1}, {2, -2, -1 ,4 ,-5}, {-3, 3, 1 ,0 ,3}};
        MaximumSubMatrixSum t = new MaximumSubMatrixSum();
        System.out.print(t.maxSubmatrixSum(matrix));
    }

}
