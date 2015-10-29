package InterviewQuestions;
import java.util.*;

public class NQueue {
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<List<String>>();
        List<String> res = new ArrayList<String>();
        char[][] matrix = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = '.';
            }
        }
        backtrack(results, res, matrix, 0);
        return results;
    }
    
    private void backtrack(List<List<String>> results, List<String> res, char[][] matrix, int row) {
        if(row >= matrix.length) {
            results.add(res);
            return;
        }
        
        for(int j = 0; j < matrix.length; j++) {
            if(isValid(matrix, row, j)){
                matrix[row][j] = 'Q';
                res.add(genRow(matrix, row));
                backtrack(results, res, matrix, row+1);
                res.remove(res.size() - 1);
                matrix[row][j] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] matrix, int row, int col) {
        for(int i = 0; i < row; i++) {
            if(matrix[i][col] == 'Q') return false;
        }
        
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(matrix[i][j] == 'Q') return false;
        }
        
        for(int i = row - 1, j = col + 1; i >= 0 && j <= matrix.length - 1; i--, j++) {
            if(matrix[i][j] == 'Q') return false;
        }
        
        return true;
    }
    
    private String genRow(char[][] matrix, int row) {
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < matrix.length; j++) {
            sb.append(matrix[row][j]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        NQueue t = new NQueue();
        List<List<String>> results = t.solveNQueens(1);
    }

}
