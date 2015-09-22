package LeetCode2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _56_MergeIntervals {
	public class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	}
	
	public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() < 2) return intervals;
        
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval v1, Interval v2) {
                return v1.start - v2.start;
            }
        });
        List<Interval> res = new ArrayList<Interval>();
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for(Interval interval : intervals) {
            if(interval.start > end) {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
            else {
                end = Math.max(end, interval.end);
            }
        }
        
        res.add(new Interval(start, end));
        return res;
        
    }
}
