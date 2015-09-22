package InterviewQuestions;

import java.util.Iterator;

/*
 * Suppose you have a Iterator class with has_next() and get_next() methods.
 * Please design and implement a ZigzagIterator class as a wrapper of two iterators.
 */

public class ZigzagIterator {
	
	Iterator i0;
	Iterator i1;
	Iterator it;
	
	public ZigzagIterator(Iterator i0, Iterator i1) {
		this.i0 = i0;
		this.i1 = i1;
		this.it = i0.hasNext()? i0 : i1;
	}
	
	public boolean has_next() {
		return it.hasNext();
	}
	
	public int get_next() {
		int res = (int)it.next();
		if(it == i0 && i1.hasNext())
			it = i1;
		else if(it == i1 && i0.hasNext())
			it = i0;
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
