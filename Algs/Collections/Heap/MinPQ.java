package Heap;

import java.util.*;

public class MinPQ<Key> implements Iterable<Key> {
	
	private Key[] pq;
	private int N;
	private Comparator<Key> comparator; 

	public MinPQ(int initCapacity) {
		N = 0;
		pq = (Key[]) new Object[initCapacity + 1];
	}

	public MinPQ(int initCapacity, Comparator<Key> comparator) {
	    this.comparator = comparator;
	    pq = (Key[]) new Object[initCapacity + 1];
	    N = 0;
	}

	public MinPQ(Key[] keys) {
		N = keys.length;
		pq = (Key[]) new Object[N + 1];
		for(int i = 0; i < N; i++)
			pq[i+1] = keys[i];
		for(int k = N / 2; k >= 1; k--)
			sink(k);
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void insert(Key x) {
		if(N == pq.length - 1) resize(2 * pq.length);
		
		pq[++N] = x;
		swim(N);
	}

	public Key delMin() {
		Key min = pq[1];
		exch(1, N);
		N--;
		sink(1);
		pq[N+1] = null;
		return min;
	}

	// helper method
	private void resize(int capacity) {
		Key[] tmp = (Key[])new Object[capacity];
		for(int i = 1; i <= N; i++) {
			tmp[i] = pq[i];
		}
		pq = tmp;
	}

	private void sink(int k) {
		while(2*k <= N) {
			int j = 2*k;
			if(j < N && greater(j, j++)) j++;
			if(greater(j, k)) break;
			else exch(j, k);
			k = j;
		}
	}

	private void swim(int k) {
		while(k > 1 && greater(k/2, k)){
			exch(k/2, k);
			k = k/2;
		}
	}

	private boolean greater(int i, int j) {
		return comparator.compare(pq[i], pq[j]) > 0;
	}

	private void exch(int i, int j) {
	    Key swap = pq[i];
	    pq[i] = pq[j];
	    pq[j] = swap;
	}

	public void sort(Key[] pq) {
		for(int k = N/2; k >= 1; k--)
			sink(k);
		while(N > 1) {
			exch(1, N);
			sink(1);
			N--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<Key> iterator() {
		// TODO Auto-generated method stub
		return (Iterator<Key>) new HeapIterator();
	}

	private class HeapIterator implements Iterable<Key>{
		// create a new pq
		private MinPQ<Key> copy;

		// add all items to copy of heap
		// takes linear time since already in heap order so no keys move
		public HeapIterator() {
		    if (comparator == null) copy = new MinPQ<Key>(N);
		    else                    copy = new MinPQ<Key>(N, comparator);
		    for (int i = 1; i <= N; i++)
		        copy.insert(pq[i]);
		}

		public boolean hasNext() {
			return !copy.isEmpty();
		}

		public Key next() {
			return copy.delMin();
		}

		@Override
		public Iterator<Key> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
	}

}
