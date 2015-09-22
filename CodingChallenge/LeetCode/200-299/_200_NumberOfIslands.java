package LeetCode2;

public class _200_NumberOfIslands {
	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0) return 0;
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int count = 0;
	        
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == '1' && !visited[i][j]) {
					count++;
					bfs(grid, visited, i, j);
				}
			}
		}
		return count;
	}
    
	private void bfs(char[][] grid, boolean[][] visited, int i, int j) {
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1')
			return;
		visited[i][j] = true;
		bfs(grid, visited, i-1, j);
		bfs(grid, visited, i+1, j);
		bfs(grid, visited, i, j-1);
		bfs(grid, visited, i, j+1);
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_200_NumberOfIslands t = new _200_NumberOfIslands();
		char[][] grid = new char[1][2];
		grid[0][0] = '1';
		grid[0][1] = '1';
		
		System.out.print(t.numIslands(grid));
	}
}
