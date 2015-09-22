package Amazon;
/*
 * Word Ladder，介于1和2中间吧，只需要输出最短的一条路径就可以
 */
import java.util.*;

public class WordLadderMiddle {
	
	public List<String> findShortestLadder(String beginWord, String endWord, Set<String> wordDict){
		
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> path = new ArrayList<String>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		boolean found = false;
		Set<String> unvisited = new HashSet<String>(wordDict);
		unvisited.add(endWord);
		unvisited.remove(beginWord);
		Set<String> visited = new HashSet<String>();
		Queue<String> q = new LinkedList<String>();
		q.offer(beginWord);
		int cur = 1, count = 0;
		
		while(!q.isEmpty()) {
			String word = q.poll();
			cur--;
			
			for(String tmp : getNextLadder(word, unvisited)){
				if(visited.add(tmp)){
					count++;
					q.offer(tmp);
				}
				if(map.containsKey(tmp)) map.get(tmp).add(word);
				else {
					List<String> l = new ArrayList<String>();
        				l.add(word);
        				map.put(tmp, l);
				}
				if(tmp.equals(endWord)) found = true;
			}
			
			if(cur == 0){
				if(found) break;
				cur = count;
				count = 0;
				unvisited.removeAll(visited);
				visited.clear();
			}
		}
		
		backtrack(endWord, beginWord, path, map, res);
		
		return res.get(0);
	}
	
	private void backtrack(String word, String start, List<String> path, Map<String, List<String>> map, List<List<String>> res) {
		if(word.equals(start)){
			path.add(0, start);
			res.add(new ArrayList<String>(path));
			path.remove(0);
			return;
		}
		
		path.add(0, word);
		if(map.get(word) != null) {
			for(String s : map.get(word))
				backtrack(s, start, path, map, res);
		}
		path.remove(0);
		
	}
	
	private List<String> getNextLadder(String curLadder, Set<String> unvisited) {
	    	List<String> nextLadder = new ArrayList<String>();
	    	StringBuilder replace = new StringBuilder(curLadder);
	    	for(int i = 0; i < curLadder.length(); i++) {
	    		char old = replace.charAt(i);
	    		for(char ch = 'a'; ch <= 'z'; ch++) {
	    			replace.setCharAt(i, ch);
	    			String tmp = replace.toString();
	    			if(ch != curLadder.charAt(i) && unvisited.contains(tmp))
	    				nextLadder.add(tmp);
	    		}
	    		replace.setCharAt(i, old);
	    	}
	    	return nextLadder;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadderMiddle t = new WordLadderMiddle();
		String beginWord = "hit";
		String endWord = "cog";
		Set<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		for(String s : t.findShortestLadder(beginWord, endWord, set)) {
			System.out.println(s);
		}
	}
}
