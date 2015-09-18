import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
	private Item[] array;  // array of items
	private int N;         // numbers of items in the stack

	/*
	 * Initialize an empty stack with capacity 10
	 */
	public ResizingArrayStack() {
		array = (Item[]) new Object[10];
	}

	/*
	 * Return true if the stack is empty; false otherwise
	 */
	public boolean isEmpty() {
		return N == 0;
	}

	/*
	 * Return the number of items in the stakc
	 */
	public int size() {
		return N;
	}

	/*
	 * Add an item to the stack
	 */
	public void push(Item item) {
		if(N == array.length) resize(2 * array.length);
		array[N++] = item;
	}

	/*
	 * Remove and return the most recently item added to the stack 
	 */ 
	public Item pop() {
		Item item = array[N-1];
		array[N-1] = null;
		N--;
		// shrink the size of stack if necessary
		if(N > 0 && N == array.length / 4) resize(array.length / 2);
		return item;
	}

	/*
	 * Return the most recently item added to the stack
	 */
	public Item peek() {
		return array[N-1];
	}

	/*
	 * Helper method to resize the array
	 */
	private void resize(int capacity) {
		Item[] tmp = (Item[]) new Object[capacity];
		for(int i = 0; i < N; i++) {
			tmp[i] = array[i];
		}
		array = tmp;
	}

	/*
	 * Return an iterator, override abstract method iterator() in Iterable
	 */
	public Iterator<Item> iterator() {
		return new ResizingArrayStackIterator();
	}

	/*
	 * An iterator class that iterates the items in LIFO order
	 */ 
	private class ResizingArrayStackIterator implements Iterator<Item> {
		private int i;

		public ResizingArrayStackIterator() {
			i = N - 1;
		}

		public boolean hasNext() {
			return i >= 0;
		}

		public Item next() {
			return array[i--];
		}

		public void remove() {

		}
	}

	/*
	 * test client
	 */
	public static void main(String[] args) {
		ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
		String[] texts = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};
		for(String text : texts) {
			if(!text.equals("-")) stack.push(text);
			else System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}

}