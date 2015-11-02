package InterviewQuestions;
/*
一个 n x n 矩阵，每个房间可能是封闭的房间，可能是警察，可能是开的房间， 封闭的房间不能过，返回一个n x n矩阵，每一个元素是最近的警察到这个房间的最短距离。 
初始矩阵中-1代表封闭房间，INT_MAX代表普通房间，0代表有警察的房间。
*/

public class ShortDistanceByPolice {
    
    public void findPolice(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    visited = new boolean[m][n];
                    dfs(matrix, i-1, j, 1, visited);
                    dfs(matrix, i+1, j, 1, visited);
                    dfs(matrix, i, j-1, 1, visited);
                    dfs(matrix, i, j+1, 1, visited);
                }
            }
        }
    }
    
    private void dfs(int[][] matrix, int i, int j, int step, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] == -1 || matrix[i][j] == 0 || visited[i][j]) return;
        if(step < matrix[i][j]) matrix[i][j] = step;
        visited[i][j] = true;
        dfs(matrix, i-1, j, step+1, visited);
        dfs(matrix, i+1, j, step+1, visited);
        dfs(matrix, i, j-1, step+1, visited);
        dfs(matrix, i, j+1, step+1, visited);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = {{0, -1, -1}, {Integer.MAX_VALUE, Integer.MAX_VALUE, 0}, {-1, Integer.MAX_VALUE, -1}};
        ShortDistanceByPolice t = new ShortDistanceByPolice();
        t.findPolice(matrix);
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        
    }

}
