package LeetCode2;

import java.util.*;

/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
 */

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

public class _253_MeetingRoom2 {
	public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        
        queue.offer(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++) {
            Interval finishInterval = queue.poll();
            
            if(intervals[i].start >= finishInterval.end) {
                finishInterval.end = intervals[i].end;
            } else {
                queue.offer(intervals[i]);
            }
            
            queue.offer(finishInterval);
        }
        
        return queue.size();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
