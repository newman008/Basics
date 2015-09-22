import java.util.Iterator;

public class ResizingArrayBag<Item> implements Iterable<Item> {
	private Item[] array;        // array of items
	private int N;	             // number of items in the bag

	/**
	 * Initialize an empty bag with capacity 10
	 */
	public ResizingArrayBag() {
		array = (Item[]) new Object[10];
	}

	/**
	 * Return true if the bag is empty; false otherwise
	 */
	public boolean isEmpty() {
		return N == 0;
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
		if(N == array.length) resize(2 * array.length);
		array[N++] = item;
	}

	/**
	 * Helper method to resize the array
	 */
	private void resize(int capacity) {
		Item[] tmp = (Item[]) new Object[capacity];
		for(int i = 0; i < N; i++) {
			tmp[i] = array[i];
		}
		array = tmp;
	}

	/**
	 * Return an iterator, override abstract method iterator() in Iterable
	 */
	public Iterator<Item> iterator() {
		return new ResizingArrayBagIterator();
	}

	/**
	 * An iterator class that iterates the items in arbitrary order
	 */ 
	private class ResizingArrayBagIterator implements Iterator<Item> {
		private int i = 0;;

		public boolean hasNext() { return i < N; }
		public Item next() { return array[i++]; }
		public void remove() {}
	}

	/**
	 * test client
	 * output: Hello World ! how are you ?
	 */
    public static void main(String[] args) {
        ResizingArrayBag<String> bag = new ResizingArrayBag<String>();
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