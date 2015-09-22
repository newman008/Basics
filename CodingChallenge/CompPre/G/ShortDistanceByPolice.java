package InterviewQuestions;

public class ShortDistanceByPolice {
	
	public void findPolice(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] visited = new boolean[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(matrix[i][j] == 0) {
					visited = new boolean[m][n];
					dfs(matrix, i-1, j, 1, visited);
					dfs(matrix, i+1, j, 1, visited);
					dfs(matrix, i, j-1, 1, visited);
					dfs(matrix, i, j+1, 1, visited);
				}
			}
		}
	}
	
	private void dfs(int[][] matrix, int i, int j, int step, boolean[][] visited) {
		if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] == -1 || matrix[i][j] == 0 || visited[i][j]) return;
		if(step < matrix[i][j]) matrix[i][j] = step;
		visited[i][j] = true;
		dfs(matrix, i-1, j, step+1, visited);
		dfs(matrix, i+1, j, step+1, visited);
		dfs(matrix, i, j-1, step+1, visited);
		dfs(matrix, i, j+1, step+1, visited);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{0, -1, -1}, {Integer.MAX_VALUE, Integer.MAX_VALUE, 0}, {-1, Integer.MAX_VALUE, -1}};
		ShortDistanceByPolice t = new ShortDistanceByPolice();
		t.findPolice(matrix);
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		
	}

}
