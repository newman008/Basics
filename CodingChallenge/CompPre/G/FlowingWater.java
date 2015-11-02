package InterviewQuestions;
/*
Given a N*N matrix contains lakes, each lake is represented by an elevation. The water in each lake can flow to its neighbours which has lower or equal elevations.

Suppose the left and top side of the matrix is surrounded by Pacific, the right and bottom is Atlantic.

Please write a function and return all lakes that can flow to both Pacific and Atlantic.

For example:

Pacific: ~
Atlantic: *

~  ~   ~   ~   ~   ~  ~
~  1   2   2   3  (5) *
~  3   2   3  (4) (4) *
~  2   4  (5)  3   1  *
~ (6) (7)  1   4   5  *
~ (5)  1   1   2   4  *
*  *   *   *   *   *  *
The elements in parentheses are expected outputs:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]


*/

import java.util.ArrayList;
import java.util.List;

class Point{
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class FlowingWater {
    
    
    public List<Point> flowing_water(int[][] matrix) {
        List<Point> res = new ArrayList<Point>();
        if(matrix == null || matrix.length == 0) return res;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) dfs(matrix, pacific, i, j);
            }
        }
        
        boolean[][] atlantic = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == m-1 || j == n-1) dfs(matrix, atlantic, i, j);
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) res.add(new Point(i, j));
            }
        }
        
        return res;
    }
    
    private void dfs(int[][] matrix, boolean[][] visited, int i, int j) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] == true) return;
        
        visited[i][j] = true;
        if(i > 0 && matrix[i][j] <= matrix[i-1][j]) dfs(matrix, visited, i-1, j);
        if(i < matrix.length - 1 && matrix[i][j] <= matrix[i+1][j]) dfs(matrix, visited, i+1, j);
        if(j > 0 && matrix[i][j] <= matrix[i][j-1]) dfs(matrix, visited, i, j-1);
        if(j < matrix[0].length - 1 && matrix[i][j] <= matrix[i][j+1]) dfs(matrix, visited, i, j+1);
        //visited[i][j] = false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        FlowingWater t = new FlowingWater();
        List<Point> res = t.flowing_water(matrix);
//      res.add(new Point(0, 0));
//      res.add(new Point(0, 1));
//      res.add(new Point(0, 2));
        for(Point p : res) {
            System.out.print("[" + p.x + ", " + p.y + "] ");
        }
    }

}
