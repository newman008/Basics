package LeetCode2;

public class _37_SudokuSolver {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }
    
    public boolean backtrack(char[][] board, int x, int y) {
        if(x == 8 && y == 9) return true;
        if(y == 9) return backtrack(board, x+1, 0);
        if(board[x][y] != '.') 
            return backtrack(board, x, y+1);
        else {
            for(char c = '1'; c <= '9'; c++) {
                if(isValid(board, x, y, c)) {
                    board[x][y] = c;
                    if(backtrack(board, x, y+1)) 
                        return true;
                    else
                        board[x][y] = '.';
                }
            }
            return false;
        }
    }
    
    private boolean isValid(char[][] board, int i, int j, char c) {
        for(int row = 0; row < 9; row++) {
            if(board[row][j] == c) return false;
        }
        for(int col = 0; col < 9; col++) {
            if(board[i][col] == c) return false;
        }
        for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
            for(int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
                if(board[row][col] == c) return false;
            }
        }
        
        return true;
    }
}
