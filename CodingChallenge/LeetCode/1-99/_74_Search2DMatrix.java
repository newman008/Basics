package LeetCode2;

public class _74_Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int start = 0;
        int end = m*n - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(matrix[mid/n][mid%n] == target) return true;
            else if (matrix[mid/n][mid%n] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return false;
    }
}
