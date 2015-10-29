package ArraysAndStrings;

public class _16 {
    
    public void rotate(int[][] matrix, int n) {
        for(int layer = 0; layer < n / 2; layer++) {
            int first = layer; 
            int last = n - 1 - first;
            for(int i = first; i < last; i++){
                int offset = i - first;
                // save top
                int top = matrix[first][i];
                // left to top
                matrix[first][i] = matrix[last - offset][first];
                // bottom to left
                matrix[last - offset][first] = matrix[last][last-offset];
                // right to bottom
                matrix[last][last-offset] = matrix[i][last];
                // top to right
                matrix[i][last] = top;
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
