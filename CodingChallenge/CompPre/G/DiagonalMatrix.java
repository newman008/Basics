package InterviewQuestions;

public class DiagonalMatrix {
	
	public void print(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i = 0; i < m + n - 1; i++) {
			int row = Math.min(i, m-1);
			int col = Math.max(0, i - m + 1);
			while(row >= 0 && col < n) {
				System.out.print(matrix[row][col] + " ");
				row--;
				col++;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiagonalMatrix t = new DiagonalMatrix();
		int[][] matrix = new int[5][4];
		int num = 1;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 4; j++) {
				matrix[i][j] = num;
				num++;
			}
		}
		t.print(matrix);
	}

}
