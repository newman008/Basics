package LeetCode2;

public class _200_NumbersOfIslands {
	public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void bfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') return;
        grid[i][j] = '#';
        bfs(grid, i-1, j);
        bfs(grid, i+1, j);
        bfs(grid, i, j-1);
        bfs(grid, i, j+1);
    }
}
