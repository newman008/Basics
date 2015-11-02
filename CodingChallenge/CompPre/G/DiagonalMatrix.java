package InterviewQuestions;
/*
Given a 2D matrix, print all elements of the given matrix in diagonal order. For example, consider the following 5 X 4 input matrix.
    1     2     3     4
    5     6     7     8
    9    10    11    12
   13    14    15    16
   17    18    19    20
Diagonal printing of the above matrix is
    1
    5     2
    9     6     3
   13    10     7     4
   17    14    11     8
   18    15    12
   19    16
   20
*/

public class DiagonalMatrix {
    
    public void print(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m + n - 1; i++) {
            int row = Math.min(i, m-1);
            int col = Math.max(0, i - m + 1);
            while(row >= 0 && col < n) {
                System.out.print(matrix[row][col] + " ");
                row--;
                col++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DiagonalMatrix t = new DiagonalMatrix();
        int[][] matrix = new int[5][4];
        int num = 1;
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 4; j++) {
                matrix[i][j] = num;
                num++;
            }
        }
        t.print(matrix);
    }

}
