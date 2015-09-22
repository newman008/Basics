package StackAndQueues;

import java.util.*;



/*
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. 
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold. 
 * Implement a data structure SetOfStacks that mimics this. 
 * SetOf-Stacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity. 
 * SetOfStacks.push() and SetOfStacks.pop () should behave identically to a single stack 
 * (that is, pop () should return the same values as it would if there were just a single stack).
 */

public class _33 {
	
	class Stack {
		private int capacity;
		public int size = 0;
		List<Integer> s = new LinkedList<Integer>(); 
		
		public Stack(int capacity) {
			this.capacity = capacity;
		}
		
		public boolean isFull() {
			return size == capacity;
		}
		
		public boolean push(int v) {
			if(size >= capacity) return false;
			size++;
			s.add(v);
			return true;
		}
		
		public int pop() {
			int v = s.get(size - 1);
			s.remove(size - 1);
			size--;
			return v; 
		}
	}
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	int capacity;
	public _33(int capacity){
		this.capacity = capacity;
	}
	
	public void push(int v) {
		Stack last = getLastStack();
		if(last != null && !last.isFull()){
			last.push(v);
		} else {
			Stack s = new Stack(capacity);
			s.push(v);
			stacks.add(s);
		}
	}
	
	public int pop() {
		Stack last = getLastStack();
		int v = (int) last.pop();
		if(last.size == 0) stacks.remove(stacks.size() - 1);
		return v;
	}
	
	public Stack getLastStack(){
		if(stacks.size() == 0) return null;
		return stacks.get(stacks.size() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
