package LeetCode2;

import java.util.LinkedList;
import java.util.Queue;

public class _130_SurroundedRegions {
	public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        
        int m = board.length;
        int n = board[0].length;
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {
                q.offer(i*n + 0);
                board[i][0] = '#';
            }
            if(board[i][n-1] == 'O') {
                q.offer(i*n + n-1);
                board[i][n-1] = '#';
            }
        }
        
        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O') {
                q.offer(j);
                board[0][j] = '#';
            }
            if(board[m-1][j] == 'O') {
                q.offer((m-1)*n + j);
                board[m-1][j] = '#';
            }
        }
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            int x = cur / n;
            int y = cur % n;
            if(x-1 > 0 && board[x-1][y] == 'O') {
                q.offer((x-1)*n + y);
                board[x-1][y] = '#';
            }
            if(x+1 < m-1 && board[x+1][y] == 'O') {
                q.offer((x+1)*n + y);
                board[x+1][y] = '#';
            }
            if(y-1 > 0 && board[x][y-1] == 'O') {
                q.offer(x*n + y - 1);
                board[x][y-1]= '#';
            }
            if(y+1 < n-1 && board[x][y+1] == 'O') {
                q.offer(x*n + y + 1);
                board[x][y+1]='#';
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
}
