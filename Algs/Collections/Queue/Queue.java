import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	private int N;                // size of queue
	private Node<Item> first;     // first element in the queue
	private Node<Item> last;      // last element in the queue

	// helper linkedlist class
	private class Node<Item> {
		Item item;
		Node<Item> next;
	}

	/*
	 * Initialize an empty queue
	 */
	public Queue() {
		N = 0;
		first = null;
		last = null;
	}

	/*
	 * Return true if the queue is empty; false otherwise
	 */
	public boolean isEmpty() {
		return N == 0;
	}

	/*
	 * Return the number of items in the queue
	 */
	public int size() {
		return N;
	}

	/*
	 * Add an item to the queue
	 */
	public void enqueue(Item item) {
		Node<Item> oldlast = last;
		last = new Node<Item>();
		last.item = item;
		last.next = null;
		if(isEmpty()) first = last;
		else oldlast.next = last;
		N++;
	}

	/*
	 * Remove and return the least recently item added to the stack 
	 */ 
	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		N--;
		if(isEmpty()) last = null;
		return item;
	}

	/*
	 * Return the least recently item added to the stack
	 */
	public Item peek() {
		return first.item;
	}

	/*
	 * Return an iterator, override abstract method iterator() in Iterable
	 */
	public Iterator<Item> iterator() {
        return new QueueIterator(first);
    }

    /*
	 * An iterator class that iterates the items in FIFO order
	 */ 
    private class QueueIterator implements Iterator<Item> {
    	private Node<Item> cur;

    	public QueueIterator(Node<Item> first) {
    		cur = first;
    	}

    	public boolean hasNext() { return cur != null; }
    	public void remove() {}
    	public Item next() {
    		Item item = cur.item;
    		cur = cur.next;
    		return item;
    	}
    }

    /*
	 * test client
	 * output: to be or not to be
	 */
	public static void main(String[] args) {
		Queue<String> queue = new Queue<String>();
		String[] texts = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};
		for(String text : texts) {
			if(!text.equals("-")) queue.enqueue(text);
			else System.out.print(queue.dequeue() + " ");
		}
		System.out.println();
	}
}