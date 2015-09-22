package LeetCode2;

import java.util.ArrayList;
import java.util.List;

public class _54_SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix == null) return res;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int rowStart = 0;
        int rowEnd = row - 1;
        int colStart = 0;
        int colEnd = col - 1;
        
        while(rowStart <= rowEnd && colStart <= colEnd) {
            for(int j = colStart; j <= colEnd; j++) {
                res.add(matrix[rowStart][j]);
            }
            rowStart++;
            
            for(int i = rowStart; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            if(rowStart <= rowEnd) {
                for(int j = colEnd; j >= colStart; j--) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            
            if(colStart <= colEnd) {
                for(int i = rowEnd; i >= rowStart; i--) {
                    res.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }
        
        return res;
        
    }
}
