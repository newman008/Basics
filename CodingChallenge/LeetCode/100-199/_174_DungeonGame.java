package LeetCode2;

public class _174_DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        int[][] matrix = new int[m][n];
        // matrix[m-1][n-1] = Math.max(1, 1 - dungeon[m-1][n-1]);
        
        // for(int i = m-2; i >= 0; i--) {
        //     matrix[i][n-1] = Math.max(1, matrix[i+1][n-1] - dungeon[i][n-1]); 
        // }
        // for(int j = n-2; j >=0; j--) {
        //     matrix[m-1][j] = Math.max(1, matrix[m-1][j+1] - dungeon[m-1][j]);
        // }
        
        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                if(i == m-1 && j == n-1)
                    matrix[i][j] = Math.max(1, 1 - dungeon[i][j]);
                else if(i == m-1)
                    matrix[i][j] = Math.max(1, matrix[i][j+1] - dungeon[i][j]);
                else if(j == n-1)
                    matrix[i][j] = Math.max(1, matrix[i+1][j] - dungeon[i][j]);
                else {
                    int down = Math.max(1, matrix[i+1][j] - dungeon[i][j]);
                    int right = Math.max(1, matrix[i][j+1] - dungeon[i][j]);
                    matrix[i][j] = Math.min(down, right);
                }
            }
        }
        return matrix[0][0];
    }
}
