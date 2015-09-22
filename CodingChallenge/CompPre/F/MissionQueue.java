package Facebook;

import java.util.*;

/*
 * 给定任务AABCB, 冷却时间k（相同任务之间的最短距离时间），任务顺序不能变，问完成任务的总时间。
 * 例子：AABCB, k=2, A**ABC*B, 时间为8. 
 */

public class MissionQueue {
	
	public static int totalTime(String s, int k) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int total = 0;
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(map.containsKey(ch)){
				if(i - map.get(ch) > k) total++;
				else total = total + 1 + k - (i - map.get(ch) - 1);
				map.put(ch, i);
			} else {
				map.put(ch, i);
				total++;
			}
		}
		
		return total;
	}
	
	public static int totalTime2(String s, int k) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int total = 0;
		for(int i = 0; i < s.length(); i++) {
			List<Character> l = new ArrayList<Character>();
			for(Character c : map.keySet()){
				if(i - map.get(c) > k) l.add(c);
			}
			for(Character c : l) {
				map.remove(c);
			}
			char ch = s.charAt(i);
			if(map.containsKey(ch)){
				if(i - map.get(ch) > k) total++;
				else total = total + 1 + k - (i - map.get(ch) - 1);
				map.put(ch, i);
			} else {
				map.put(ch, i);
				total++;
			}
		}
		
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MissionQueue.totalTime2("AAABCBEIRNF", 2));
	}

}
