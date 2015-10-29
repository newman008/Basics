package LeetCode2;

import java.util.ArrayList;
import java.util.List;

public class _51_NQueues {
    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<String[]>();
        //if(n < 4) return res;
        
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        backtrack(board, res, 0, n);
        return res;
    }
    
    public void backtrack(char[][] board, List<String[]> res, int i, int n) {
        if(i == n) {
            addToRes(res, board.clone());
            return;
        }
        else {
            for(int j = 0; j < n; j++) {
                if(isSafe(board, i, j)) {
                    board[i][j] = 'Q';
                    backtrack(board, res, i+1, n);
                    board[i][j] = '.';
                }
            }
        }
    }
    
    public void addToRes(List<String[]> res, char[][] board) {
        String[] temp = new String[board.length];
        
        for(int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < board.length; j++) {
                sb.append(board[i][j]);
            }
            temp[i] = sb.toString();
        }
        
        res.add(temp);
    }
    
    public boolean isSafe(char[][] board, int i, int j) {
        for(int row = 0; row <= i; row++) {
            if(board[row][j] == 'Q') return false;
        }
        
        for(int row = i, col = j; row >= 0 && col >=0; row--, col--) {
            if(board[row][col] == 'Q') return false;
        }
        
        for(int row = i, col = j; row >= 0 && col < board.length; row--, col++) {
            if(board[row][col] == 'Q') return false;
        }
        
        return true;
    }
}
