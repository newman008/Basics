package ArraysAndStrings;

/*
 * Write an algorithm such that if an element in an MxN matrix is 0, 
 * its entire row and column are set to 0.
 * 1 2 0 4
 * 2 4 5 4 
 * 3 0 9 8
 * 4 9 0 2
 * 
 * 0 0 0 0
 * 2 0 0 4
 * 0 0 0 0 
 * 0 0 0 0 
 */

public class _17 {
	
	public void setZero(int[][] matrix) {
		if(matrix == null || matrix.length == 0) return;
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		boolean firstRowHasZero = false;
		boolean firstColumnHasZero = false;
		
		for(int i = 0; i < m; i++) {
			if(matrix[i][0] == 0) firstColumnHasZero = true;
			if(matrix[0][i] == 0) firstRowHasZero = true;
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
				if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
			}
		}
		
		if(firstColumnHasZero) {
			for(int i = 0; i < m; i++) matrix[i][0] = 0;
		}
		
		if(firstRowHasZero) {
			for(int j = 0; j < n; j++) matrix[0][j] = 0;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
