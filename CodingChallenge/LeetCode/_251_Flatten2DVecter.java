package LeetCode2;

import java.util.*;

/*
 * Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 */

public class _251_Flatten2DVecter {
	
	private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public _251_Flatten2DVecter(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    public int next() {
        return j.next();
    }

    public boolean hasNext() {
        while((j == null || !j.hasNext()) && i.hasNext()){
            j = i.next().iterator();
        }
        return j != null && j.hasNext();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
