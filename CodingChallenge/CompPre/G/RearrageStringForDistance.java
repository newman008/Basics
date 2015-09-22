package InterviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrageStringForDistance {
	
	public String rearrage(String s, int k) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		int l = s.length();
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else 
				map.put(ch, 1);
		}
		
		final Map<Character, Integer> fmap = new HashMap<Character, Integer>(map);
		
		PriorityQueue<Character> pq = new PriorityQueue<Character>(map.size(), new Comparator<Character>(){
			@Override
			public int compare(Character c1, Character c2) {
				return fmap.get(c2) - fmap.get(c1); 
			}
		});
		
		pq.addAll(map.keySet());
		char[] res = new char[s.length()];
		Arrays.fill(res, '\0');
		for(int i = 0; i < map.size(); i++) {
			int p = i;
			while(res[p] != '\0') p++;
			char c = pq.poll();
			int cnt = map.get(c);
			for(int j = 0; j < cnt; j++) {
				if(p >= l) return "can't be arraged";
				res[p] = c;
				p = p + k;
			}
		}	
	
		return new String(res);	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RearrageStringForDistance t = new RearrageStringForDistance();
		System.out.print(t.rearrage("aacbbb", 3));
	}

}
