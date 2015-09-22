package LeetCode2;

import java.util.Map;
import java.util.HashMap;

public class _149_MaxPointsOnALine {
	class Point {
		int x;
	 	int y;
	 	Point() { x = 0; y = 0; }
	 	Point(int a, int b) { x = a; y = b; }
		}
	
	public int maxPoints(Point[] points) {
        if(points == null) return 0;
        int len = points.length;
        if(len <= 2) return len;
        
        int max = 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
        
        
        for(int i = 0; i < len; i++) {
            map.clear();
            int dup = 0, local = 0;
            
            for(int j = i+1; j < len; j++) {
                int x0 = points[j].x - points[i].x;
                int y0 = points[j].y - points[i].y;
                if(x0 == 0 && y0 == 0) {
                    dup++;
                    continue;
                }
                int gcd = gcd(x0, y0);
                x0 = x0 / gcd;
                y0 = y0 / gcd;
                
                if(map.containsKey(x0)) {
                    if(map.get(x0).containsKey(y0))
                        map.get(x0).put(y0, map.get(x0).get(y0)+1);
                    else
                        map.get(x0).put(y0, 1);
                } else {
                    Map<Integer, Integer> m = new HashMap<Integer, Integer>();
                    m.put(y0, 1);
                    map.put(x0, m);
                }
                
                local = Math.max(local, map.get(x0).get(y0));
            }
            
            max = Math.max(max, local+dup+1);
        }
        return max;
    }
    
    private int gcd(int x, int y) {
        if(y == 0) return x;
        else return gcd(y, x%y);
    }
}
