import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
	private Node<Item> first;    // first element in the queue
	private int N;	             // number of items in the bag

	// helper linkedlist class
	private class Node<Item> {
		Item item;
		Node<Item> next;
	}

	/**
	 * Initialize an empty bag with capacity 10
	 */
	public Bag() {
		first = null;
		N = 0;
	}

	/**
	 * Return true if the bag is empty; false otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Return the number of items in the bag
	 */
	public int size() {
		return N;
	} 

	/**
	 * Adds the item to the bag
	 */
	public void add(Item item) {
		Node<Item> oldFirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldFirst;
		N++;
	}

	/**
	 * Return an iterator, override abstract method iterator() in Iterable
	 */
	public Iterator<Item> iterator() {
		return new BagIterator(first);
	}

	/**
	 * An iterator class that iterates the items in arbitrary order
	 */ 
	private class BagIterator implements Iterator<Item> {
		private Node<Item> cur;

		public BagIterator(Node<Item> first) {
			cur = first;
		}

		public boolean hasNext() {
			return cur != null;
		}

		public Item next() {
			Item item = cur.item;
			cur = cur.next;
			return item;
		}

		public void remove() {

		}
	}

	/**
	 * test client
	 * output: ? you are how ! World Hello
	 */
    public static void main(String[] args) {
        Bag<String> bag = new Bag<String>();
        bag.add("Hello");
        bag.add("World");
        bag.add("!");
        bag.add("how");
        bag.add("are");
        bag.add("you");
        bag.add("?");

        for (String s : bag)
            System.out.print(s + " ");
        System.out.println();
    }
}