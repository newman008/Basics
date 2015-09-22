package LeetCode2;

public class _73_SetMatrixZeros {
	public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) firstColHasZero = true;
        }
        
        for(int j = 0; j < n; j++) {
            if(matrix[0][j] == 0) firstRowHasZero = true;
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(firstRowHasZero)
			for(int j = 0; j < n; j++)
				matrix[0][j] = 0;
		
		if(firstColHasZero)
			for(int i = 0; i < m; i++)
				matrix[i][0] = 0;
    }
}
