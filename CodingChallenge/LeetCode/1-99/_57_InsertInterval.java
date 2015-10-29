package LeetCode2;

import java.util.ArrayList;
import java.util.List;

public class _57_InsertInterval {
    public class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        
        for(Interval interval : intervals) {
            if(interval.end < newInterval.start) {
                res.add(interval);
            } else if(interval.start > newInterval.end) {
                res.add(newInterval);
                newInterval = interval;
            } else {
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
            }
        }
        
        res.add(newInterval);
        return res;
    }
}
