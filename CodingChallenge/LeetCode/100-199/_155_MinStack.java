package LeetCode2;

public class _155_MinStack {
	private class Node{
        int num;
        int min;
        Node next;
    }
	
	private Node first = null;
    
    public void push(int x) {
        if(first == null) {
            first = new Node();
            first.num = x;
            first.min = x;
            first.next = null;
        } else {
            Node oldfirst = first;
            first = new Node();
            first.num = x;
            first.min = Math.min(x, oldfirst.min);
            first.next = oldfirst;
        }
    }

    public void pop() {
        first = first.next;
    }

    public int top() {
        return first == null? 0 : first.num;
    }

    public int getMin() {
        return first == null? 0 : first.min;
    }
}
