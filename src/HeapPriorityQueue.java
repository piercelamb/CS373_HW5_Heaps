// TODO: Remove each 'todo' comment once I implement each part!

// TODO: class comment header

import java.util.*;

public class HeapPriorityQueue<E> implements PriorityQueue<E> {
	private E[] elements;
	private int size;
	private PriorityQueue<E> pq;
	private Comparator<E> comparator;

	public HeapPriorityQueue() {
		elements = (E[]) new Object[10];
		size = 0;
	}
	
	public HeapPriorityQueue(int capacity, Comparator<E> comparator) {
		if (capacity < 2) {
			throw new IllegalArgumentException();
		}
		this.comparator = comparator;
		elements = (E[]) new Object[capacity];
		
	}
	
	public void add(E value) {
		if (value == null) {
			throw new NullPointerException();
		}
		
	
		// resize if needed
				if (size + 1 >= elements.length) {
					elements = Arrays.copyOf(elements, 2 * elements.length);
				}
				
				int index = size + 1;
				elements[index] = value;  // put in last slot
				
				// "bubble up" until in order again
				boolean done = false;
				while (!done && hasParent(index)) {
					int daddy = parent(index);
					int lol = 0;
					// check to see if comparator was passed, if not use natural ordering
					if (this.comparator != null){
						lol = comparator.compare(elements[daddy],(elements[index]));
					}else{
						Comparable<E> lol2 = (Comparable<E>) elements[daddy];
						lol =  lol2.compareTo(elements[index]);
					}
						if (lol > 0) {
							swap(elements, index, daddy);
							index = daddy;
						} else {
							done = true;
						}
				}
				size++;
		}
		

	public void clear() {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = null;
		}
		size = 0;	
	}

	
	public boolean contains(E value) {
		for (int i = 0; i < elements.length; i++) {
			if (elements[i].equals(value)){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	// TODO: comment header
	public boolean isEmpty() {
		if (size == 0){
			return true;
		}else{
		return false;
		}
	}
		

	// TODO: comment header
	public Iterator<E> iterator() {
		// TODO: implement this method
		return null;
	}

	// TODO: comment header
	public E peek() {
		if (isEmpty()){
			throw new NoSuchElementException();
		}
		return elements[1];
	}

	
	public E remove() {
		E result = elements[1];
		
		elements[1] = elements[size];
		elements[size] = null;
		size--;
		
		// bubble down until order is restored
		boolean done = false;
		int index = 1;
		while (!done && hasLeftChild(index)) {
			int left = leftChild(index);
			int kiddo = left;
			if (hasRightChild(index)) {
				int right = rightChild(index);
				int lol = 0;
				// check to see if comparator was passed, if not use natural ordering
				if (this.comparator != null){
					lol = comparator.compare(elements[right],(elements[left]));
				}else{
					Comparable<E> lol2 = (Comparable<E>) elements[right];
					lol =  lol2.compareTo(elements[index]);
				}
				if (lol < 0) {
					kiddo = right;
				}
			}
			int lol = 0;
			// check to see if comparator was passed, if not use natural ordering
			if (this.comparator != null){
				lol = comparator.compare(elements[index],(elements[kiddo]));
			}else{
				Comparable<E> lol2 = (Comparable<E>) elements[index];
				lol =  lol2.compareTo(elements[kiddo]);
			}
			if (lol > 0) {
				swap(elements, index, kiddo);
				index = kiddo;
			} else {
				done = true;
			}
		}
		
		
		return result;
		
	}

	// TODO: comment header
	public void remove(E value) {
	
	}
	
	// TODO: comment header
	public int size() {
		return size;
		
	}
	
	// TODO: comment header
	public String toString() {
		if (isEmpty()){
			return "[]";
		}else{
			String lol = "[";
				for(int i = 0; i < elements.length; i++){
					if (elements[i] != null){
						lol = lol + elements[i]+", ";
					}
				}
				return lol.substring(0,lol.length()-2) +"]";
		}
	}
	
	// helpers for navigating indexes up/down the tree
		private int parent(int index) {
			return index / 2;
		}
		
		// Returns the index of the left child of the given index in the heap.
		private int leftChild(int index) {
			return index * 2;
		}

		// Returns the index of the right child of the given index in the heap.
		private int rightChild(int index) {
			return index * 2 + 1;
		}

		// Returns true if the given index has a parent in the heap (true for all elements above 1).
		private boolean hasParent(int index) {
			return index > 1;
		}

		// Returns true if the given index has a left child element in the heap.
		private boolean hasLeftChild(int index) {
			return leftChild(index) <= size;
		}

		// Returns true if the given index has a right child element in the heap.
		private boolean hasRightChild(int index) {
			return rightChild(index) <= size;
		}
		
		// Swaps the elements at the two given indexes in the array.
		private void swap(E[] a, int index1, int index2) {
			E temp = a[index1];
			a[index1] = a[index2];
			a[index2] = temp;
		}
	
}
