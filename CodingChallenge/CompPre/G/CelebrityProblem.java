package InterviewQuestions;

/*
You have a room with n people. A celebrity walks in. Everyone knows the celebrity, the celebrity knows no one. 
Non-celebrities may/may not know anyone in the room. Give an algorithm to find the celebrity. Discuss the complexity.
*/

import java.util.LinkedList;
import java.util.Queue;

public class CelebrityProblem {
    
    public int findCelebrity(int[] persons) {
        Queue<Integer> q = new LinkedList<Integer>();
        for(int p : persons) q.offer(p);
        while(q.size() > 1) {
            int a = q.poll();
            int b = q.poll();
            if(hasAcquiantance(a, b)){
                q.offer(b);
            } else {
                q.offer(a);
            }
        }
        
        int c = q.poll();
        for(int p : persons) {
            if(p == c) continue;
            if(hasAcquiantance(c, p) || !hasAcquiantance(p, c)) return -1;
        }
        return c;
    }
    
    private boolean hasAcquiantance(int a, int b) {
        return false;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
