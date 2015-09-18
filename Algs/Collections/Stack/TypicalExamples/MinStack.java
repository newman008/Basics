/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 */

public class MinStack {
    
    private class Node {
		int val;
		int min;
		Node next;
		public Node(int x){
			val = x;
		} 
	}
    
	Node first = null;

    public void push(int x) {
        if(first == null) {
        	first = new Node(x);
        	first.min = x;
        } else {
        	Node node = new Node(x);
        	node.next = first;
        	node.min = Math.min(x, first.min);
        	first = node;
        }
    }

    public void pop() {
        first = first.next;
    }

    public int top() {
        return first.val;
    }

    public int getMin() {
        return first.min;
    }
}