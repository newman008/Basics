package LeetCode2;

public class _79_WordSearch {
	public boolean exist(char[][] board, String word) {
        // write your code here
        int m = board.length;
        int n = board[0].length;
        char[] w = word.toCharArray();
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(existed(board, i, j, w, visited, 0)) return true;
            }
        }
           
        return false;
    }
    
    boolean existed(char[][] board, int i, int j, char[] w, boolean[][] visited, int index) {
        if(index == w.length) return true;
        if(i < 0 || j < 0 || i == board.length || j == board[0].length || visited[i][j]) return false;
        if(board[i][j] != w[index]) return false;
        visited[i][j] = true;
        boolean exist = existed(board, i+1, j, w, visited, index+1) ||
                        existed(board, i-1, j, w, visited, index+1) ||
                        existed(board, i, j-1, w, visited, index+1) ||
                        existed(board, i, j+1, w, visited, index+1); 
        visited[i][j] = false;
        return exist;
    }
}
