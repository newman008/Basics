package LeetCode2;

import java.util.LinkedList;
import java.util.Queue;

public class _207_CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        int l = prerequisites.length;
        if(numCourses == 0 || l == 0) return true;
        
        int[] counter = new int[numCourses];
        for(int i = 0; i < l; i++) {
            counter[prerequisites[i][0]]++;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++) {
            if(counter[i] == 0) q.add(i);
        }
        
        int leant = q.size();
        while(!q.isEmpty()){
            int top = q.poll();
            for(int i = 0; i < l; i++) {
                if(prerequisites[i][1] == top) {
                    counter[prerequisites[i][0]]--;
                    if(counter[prerequisites[i][0]] == 0) {
                        leant++;
                        q.add(prerequisites[i][0]);
                    }
                }
            }
        }
        
        return leant == numCourses;
    }
}
