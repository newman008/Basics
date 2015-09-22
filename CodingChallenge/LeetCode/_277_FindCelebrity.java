package LeetCode2;

import java.util.*;

public class _277_FindCelebrity {
	
	public int findCelebrity(int n) {
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < n; i++)
            q.offer(i);
        
        int num1 = q.poll();
        int num2 = q.poll();
        while(!q.isEmpty()){
            if(knows(num1, num2)){
                num1 = q.poll();
            } else {
                num2 = q.poll();
            }
        }
        
        int c = knows(num1, num2) ? num2 : num1;
        
        for(int i = 0; i < n; i++) {
            if(c == i) continue;
            if(knows(c, i) || !knows(i, c)) return -1;
        }
        
        return c;
    }
	
	public boolean knows(int a, int b) {
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
