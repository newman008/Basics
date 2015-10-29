import java.util.Iterator;

public class ResizingArrayQueue<Item> implements Iterable<Item> {
    private Item[] array;    // array of items
    private int N;           // numbser of items in the queue
    private int first;      // index of first item in the queue 
    private int last;       // index of next available slot

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
        return N == 0;
    }

    /*
     * Return the number of items in the queue
     */
    public int size() {
        return N;
    }

    /*
     * Helper method to resize the array
     */
    private void resize(int capacity) {
        Item[] tmp = (Item[]) new Object[capacity];
        for(int i = 0; i < N; i++)
            tmp[i] = array[(i + first) % array.length];
        array = tmp;
        first = 0;
        last = N;
    }

    /*
     * Add an item to the queue
     */
    public void enqueue(Item item) {
        if(N == array.length) resize(2 * array.length);

        array[last] = item;
        last++;
        if(last == array.length) last = 0;    // wrap-around
        N++;
    }

    /*
     * Remove and return the least recently item added to the stack 
     */ 
    public Item dequeue() {
        Item item = array[first];
        array[first] = null;
        first++;
        N--;
        if(first == array.length) first = 0;   // wrap-around
        if(N > 0 && N == array.length / 4) resize(array.length / 2);
        return item;
    }

    /*
     * Return the least recently item added to the stack
     */
    public Item peek() {
        return array[first];
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
    private class ResizingArrayQueueIterator implements Iterator<Item> {
        private int i=0;

        public boolean hasNext() {
            return i < N;
        }

        public void remove() {}

        public Item next() {
            Item item = array[(i + first) % array.length];
            i++;
            return item;
        }
    }

    /*
     * test client
     * output: to be or not to be
     */
    public static void main(String[] args) {
        ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();
        String[] texts = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};
        for(String text : texts) {
            if(!text.equals("-")) queue.enqueue(text);
            else System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
    }

}