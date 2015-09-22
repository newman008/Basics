package LeetCode2;

import java.util.*;



public class _210_CourseSchedule2 {
	public int[] findOrder2(int numCourses, int[][] prerequisites) {
        int l = prerequisites.length;
        // if(numCourses == 0 || l == 0) return new int[0];
        
        int[] counter = new int[numCourses];
        for(int i = 0; i < l; i++) {
            counter[prerequisites[i][0]]++;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++) {
            if(counter[i] == 0) q.add(i);
        }
        
        int[] res = new int[numCourses];
        int index = 0;
        
        int leant = q.size();
        while(!q.isEmpty()){
            int top = q.poll();
            
            res[index] = top;
            index++;
            
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
        
        return leant == numCourses ? res : new int[0];
    }
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
    		// DFS
		ArrayList[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
        		graph[i] = new ArrayList<Integer>();
        }

        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
	        	graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Stack<Integer> s = new Stack<Integer>();

        for(int i = 0; i < numCourses; i++) {
        		if(!dfs(graph, visited, i, s)) return new int[0];
        }

        int j = 0;
        int[] res = new int[numCourses];
        while(!s.isEmpty()){
	        	res[j] = s.pop();
	        	j++;
        }

        return res;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int i, Stack<Integer> s) {
	    	if(visited[i]) return false;
	    	else visited[i] = true;
	
	    	for(int j = 0; j < graph[i].size(); j++) {
	    		if(!dfs(graph, visited, (Integer) graph[i].get(j), s)) return false;
	    	} 
	
	    	s.push(i);
	
	    	visited[i] = false;
	    	return true;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    		_210_CourseSchedule2 t = new _210_CourseSchedule2();
    		int[][] prerequisites = {{1, 0}};
    		t.findOrder(2, prerequisites);
	}
}
