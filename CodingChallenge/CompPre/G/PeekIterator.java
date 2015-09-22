package InterviewQuestions;

import java.util.Iterator;

public class PeekIterator<T> {
	Iterator<T> it;  
	T top;
	
	public PeekIterator(Iterator it) {
		this.it = it;
		this.top = null;
		if(it.hasNext()) top = (T)it.next();
	}
	
	public T peek() {
		return top;
	}
	
	public boolean has_next() {
		return top != null;
	}
	
	public T get_next() {
		if(top == null) return null;
		T res  = top;
		top = null; 
		if(it.hasNext()) top = (T)it.next();
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
