package LeetCode2;

public class _204_CountPrimes {
	public int countPrimes(int n) {
        if(n <= 2) return 0;
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i = 2; i < n; i++) {
            if(!visited[i]) {
                count++;
                for(int j = 2 * i; j < n; j = j + i) {
                    visited[j] = true;
                }
            }
        }
        return count;
    }
}
