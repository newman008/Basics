import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	private int N;                // size of stack
	private Node<Item> first;     // top of stack

	// helper linkedlist class
	private class Node<Item> {
		Item item;
		Node<Item> next;
	}

	/*
	 * Initialize an empty stack
	 */ 
	public Stack() {
		first = null;
		N = 0;
	}

	/*
	 * Return true if the stack is empty; false otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/*
	 * Return the number of items in the stack
	 */
	public int size() {
		return N;
	}

	/*
	 * Add an item to the stack
	 */
	public void push(Item item) {
		Node<Item> oldFirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldFirst;
		N++;
	}

	/*
	 * Remove and return the most recently item added to the stack 
	 */ 
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	/*
	 * Return the most recently item added to the stack
	 */
	public Item peek() {
		return first.item;
	}

	/*
	 * Return an iterator, override abstract method iterator() in Iterable
	 */
	public Iterator<Item> iterator() {
		return new StackIterator<Item>(first);
	}

	/*
	 * An iterator class that iterates the items in LIFO order
	 */ 
	private class StackIterator<Item> implements Iterator<Item> {
		private Node<Item> current;

		public StackIterator(Node<Item> first) {
			current = first;
		}

		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {}
	}

	/*
	 * test client
	 */
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		String[] texts = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};
		for(String text : texts) {
			if(!text.equals("-")) stack.push(text);
			else System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}

}