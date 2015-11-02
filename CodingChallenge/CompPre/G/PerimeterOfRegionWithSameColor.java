package InterviewQuestions;
/*
given grid of colors, coordinate of a point and its color, find the perimeter of the region that has the same color of that point.
*/

import java.util.LinkedList;
import java.util.Queue;

public class PerimeterOfRegionWithSameColor {
    
    private static final int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}}; 
    
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int perimeter(int[][] matrix, int x, int y) {
        int m = matrix.length;
        int n = matrix[0].length;
        int cnt = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(x, y));
        
        boolean isEdge = false;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if(visited[cur.x][cur.y]) continue;
            visited[cur.x][cur.y] = true;
            isEdge = false;
            for(int[] dir : dirs) {
                int i = cur.x + dir[0];
                int j = cur.y + dir[1];
                if(i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] != matrix[x][y]) {
                    isEdge = true;
                } else {
                    q.offer(new Point(i, j));
                }
            }
            if(isEdge) cnt++;
        }
        
        return cnt;
    }
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = { {1,1,2,2,3,4,5},  
                            {1,1,1,1,1,4,5},  
                            {1,1,1,1,1,4,5},  
                            {1,1,2,2,3,4,5}};
        PerimeterOfRegionWithSameColor t = new PerimeterOfRegionWithSameColor();
        System.out.print(t.perimeter(matrix, 2, 1));
        
    }

}
