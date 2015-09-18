import java.util.Iterator;

public class ResizingArrayQueue<Item> implements Iterable<Item> {
	private Item[] array;    // array of items
	private int N;           // numbser of items in the queue
	private Item first;      // index of first item in the queue 
	private Item last;       // index of next available slot

	/*
	 * Initialize an empty queue with capacity 10
	 */
	public ResizingArrayQueue() {
		array = (Item[]) new Object[10];
		N = 0;
		first = 0;
		last = 0;
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