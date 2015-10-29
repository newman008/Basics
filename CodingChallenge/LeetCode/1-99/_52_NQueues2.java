package LeetCode2;

public class _52_NQueues2 {
    int res = 0;
    
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
        }
        backtrack(res, board, 0, n);
        return res;
    }
    
    private void backtrack(int res, char[][] board, int row, int n) {
        if(row == n) {
            this.res++;
            return;
        }
        for(int j = 0; j < n; j++) {
            if(isSafe(board, row, j)) {
                board[row][j] = 'Q';
                backtrack(res, board, row+1, n);
                board[row][j] = '.';
            }
        }
    }
    
    private boolean isSafe(char[][] board, int i, int j) {
        for(int row = 0; row < i; row++) {
            if(board[row][j] == 'Q') return false;
        }
        for(int row=i, col=j; row >= 0 && col >= 0; row--, col--) {
            if(board[row][col] == 'Q') return false;
        }
        for(int row = i, col = j; row >=0 && col < board.length; row--, col++) {
            if(board[row][col] == 'Q') return false;
        }
        
        return true;
    }
}
