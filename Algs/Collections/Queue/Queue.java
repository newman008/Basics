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

	}

	/*
	 * Return the number of items in the queue
	 */
	public int size() {

	}

	/*
	 * Helper method to resize the array
	 */
	private void resize(int capacity) {

	}

	/*
	 * Add an item to the queue
	 */
	public void enqueue(Item item) {

	}

	/*
	 * Remove and return the least recently item added to the stack 
	 */ 
	public Item dequeue() {

	}

	/*
	 * Return the least recently item added to the stack
	 */
	public Item peek() {

	}

	/*
	 * Return an iterator, override abstract method iterator() in Iterable
	 */
	public Iterator<Item> iterator() {
        return new ResizingArrayQueueIterator();
    }

    /*
	 * An iterator class that iterates the items in FIFO order
	 */ 
    private class ResizingArrayQueueIterator<Item> implements Iterator<Item> {

    }
}