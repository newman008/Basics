package LeetCode2;

import java.util.ArrayList;
import java.util.HashMap;

public class _36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        ArrayList<HashMap<Integer, Integer>> rows = new ArrayList<HashMap<Integer, Integer>>();
        ArrayList<HashMap<Integer, Integer>> cols = new ArrayList<HashMap<Integer, Integer>>();
        ArrayList<HashMap<Integer, Integer>> groups = new ArrayList<HashMap<Integer, Integer>>();
        
        for(int i = 0; i < 9; i++) {
            HashMap<Integer, Integer> tmp = new HashMap<Integer, Integer>();
            rows.add(tmp);
            tmp = new HashMap<Integer, Integer>();
            cols.add(tmp);
            tmp = new HashMap<Integer, Integer>();
            groups.add(tmp);
        }
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;
                
                if(rows.get(i).containsKey(board[i][j] - '0')) return false;
                else
                    rows.get(i).put(board[i][j] - '0', 1);
                    
                if(cols.get(j).containsKey(board[i][j] - '0')) return false;
                else
                    cols.get(j).put(board[i][j] - '0', 1);
                    
                int index = i / 3 * 3 + j / 3;
                if(groups.get(index).containsKey(board[i][j] - '0')) return false;
                else
                    groups.get(index).put(board[i][j] - '0', 1);
            }
        }
        
        return true;
    }
}
