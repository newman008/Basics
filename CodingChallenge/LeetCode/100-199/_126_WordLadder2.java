package LeetCode2;

import java.util.*;

public class _126_WordLadder2 {
    List<List<String>> results;
    List<String> path;
    Map<String, List<String>> map;
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // initialization
        results = new ArrayList<List<String>>();
        boolean found = false;
        path = new ArrayList<String>();
        map = new HashMap<String, List<String>>();
        
        Queue<String> q = new LinkedList<String>();
        Set<String> unvisited = new HashSet<String>(dict);
        Set<String> visited = new HashSet<String>();
        
        int cur = 1, count = 0;
        q.offer(start);
        unvisited.add(end);
        unvisited.remove(start);
        
        //BFS
        while(!q.isEmpty()) {
            String word = q.poll();
            cur--;
            for(String temp : getNextLadder(word, unvisited)){
                if(visited.add(temp)) {
                    count++;
                    q.add(temp);
                }
                if(map.containsKey(temp)) {
                    map.get(temp).add(word);
                }
                else {
                    List<String> l= new LinkedList<String>();
                        l.add(word);
                        map.put(temp, l);
                }
                
                if (temp.equals(end)&&!found) found=true; 
            }
            
            if(cur == 0) {
                if(found) break;
                cur = count;
                count = 0;
                unvisited.removeAll(visited);
                visited.clear();
            }   
        }
        
        // backTrace
        backtrace(end, start);
        
        return results;
    }
    
    private void backtrace(String word, String start) {
        if (word.equals(start)){
            path.add(0,start);
            results.add(new ArrayList<String>(path));
            path.remove(0);
            return;
        }
        path.add(0, word);
        if(map.get(word) != null) {
            for(String s : map.get(word))
                backtrace(s, start);
        }
        path.remove(0);
        
    }
    
    private ArrayList<String> getNextLadder(String curLadder, Set<String> unvisited) {
        ArrayList<String> nextLadder = new ArrayList<String>();
        StringBuilder replace = new StringBuilder(curLadder);
        for(int i = 0; i < curLadder.length(); i++) {
            char old = replace.charAt(i);
            for(char ch = 'a'; ch <= 'z'; ch++) {
                replace.setCharAt(i, ch);
                String temp = replace.toString();
                if(ch != curLadder.charAt(i) && unvisited.contains(temp))
                    nextLadder.add(temp);
            }
            replace.setCharAt(i, old);
        }
        return nextLadder;          
    }
}
