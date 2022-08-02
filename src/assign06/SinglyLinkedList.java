package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A class which represents a SinglyLinkedList consisting of linked nodes.
 * Traversable via iterator functions.
 * 
 * @author tate reynolds
 *
 * @param <T> - generic data type
 */
public class SinglyLinkedList<T> implements List<T> {
	private Node head;
	private int size;

	/**
	 * Default Constructor method
	 */
	public SinglyLinkedList() {
		head = null;
		size = 0;
	}
	
	/**
	 * Node class for the data stored in the linked list keeps track of the current
	 * data and the next node in the list
	 * 
	 * @author tate reynolds
	 *
	 */
	public class Node {
		T data;
		Node next;

		public Node(T d) {
			this.data = d;
			this.next = null;
		}
	}

	/**
	 * Returns head of the list
	 * @return head
	 */
	public Node getHead() {
		return this.head;
	}

	@Override
	/**
	 *	{@inheritDoc}
	 */
	public void insertFirst(T element) {
		Node newNode = new Node(element);
		newNode.next = head;
		head = newNode;
		size++;
	}

	@Override
	/**
	 *	{@inheritDoc}
	 */
	public void insert(int index, T element) throws IndexOutOfBoundsException {
		if (index > size - 1 || index < 0)
			throw new IndexOutOfBoundsException();
		
		Node temp = head, newNode = new Node(element);
		int prev = index - 1;
		for(int i = 0; i <= index; i++) {
			if(i == prev) {
				//node next to new node is the node next to iterating temp node
				newNode.next = temp.next;
				temp.next = newNode;
			}
			temp = temp.next;
		}
		size ++;
	}

	@Override
	/**
	 *	{@inheritDoc}
	 */
	public T getFirst() throws NoSuchElementException {
		if (head == null)
			throw new NoSuchElementException();
		else
			return head.data;
	}

	@Override
	/**
	 *	{@inheritDoc}
	 */
	public T get(int index) throws IndexOutOfBoundsException {
		Node temp = head;
		T data = null;
		if (index > size - 1 || index < 0)
			throw new IndexOutOfBoundsException();
		
		for(int i = 0; i <= index; i++) {
			if(i == index)
				data = temp.data;
			temp = temp.next;
		}

		return data;
	}

	@Override
	/**
	 *	{@inheritDoc}
	 */
	public T deleteFirst() throws NoSuchElementException {
		if (head.data == null)
			throw new NoSuchElementException();
		else {
			//set head to the next node
			Node temp = head;
			head = head.next;
			size --;
			return temp.data;
		}
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public T delete(int index) throws IndexOutOfBoundsException {
		if (index > size - 1 || index < 0)
			throw new IndexOutOfBoundsException();
		//NEW CODE
		//TODO: Write test for this
		if (index == 0)
			return this.deleteFirst();
		
		int count = 0;
		Node temp = head, previous = null;
		//iterate up to index
		while (count < index) {
			previous = temp;
			temp = temp.next;
			count++;
		}
		//bypass the next element (element at the next index)
		size --;
		previous.next = temp.next;
		
		return temp.data;
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public int indexOf(T element) {
		int count = 0;
		Node temp = head;
		while(temp.next != null) {
			
			//TODO: Change to .equals()
			if(temp.data == element)
				return count;
			temp = temp.next;
			count++;
		}
		return -1;
	}

	@Override
	/**
	 *	{@inheritDoc}
	 */
	public int size() {
		return this.size;
	}

	@Override
	/**
	 *	{@inheritDoc}
	 */
	public boolean isEmpty() {
		return !(size > 0);
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public void clear() {
		this.head = null;
		this.size = 0;
	}

	@Override
	/**
	 *	{@inheritDoc}
	 */
	public Object[] toArray() {
		Node current = head;
		Object[] list = new Object [this.size];
		for(int i = 0; i < list.length; i++) {
			list[i] = current.data;
			current = current.next;
		}
		return list;
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	/**
	 * Implementation of Iterator. Iterates through a
	 * LinkedList. Methods available include next(),hasNext(), and remove().
	 * @author Tate Reynolds 
	 *
	 */
	private class LinkedListIterator implements Iterator<T> {
		private Node temp;
		private Node current;
		private Node prev;
		private boolean canRemove;

		/**
		 * Default constructor
		 */
		public LinkedListIterator() {
			//pointers to keep track of iterating nodes
			temp = null;
			prev = null;
			current = head;
			canRemove = false;
		}

		/**
		 * Checks if there is a remaining element in the collection
		 * 
		 * @return true if there are nodes left, false otherwise
		 */
		public boolean hasNext() {
			return current != null;
		}

		/**
		 * Moves to and returns the next Node
		 * 
		 * @throws NoSuchElementException if there is no element to return
		 * @return the next object
		 */
		public T next() throws NoSuchElementException {
			if (!hasNext())
				throw new NoSuchElementException();
			else {
				canRemove = true;
				temp = prev;
				prev = current;
				current = current.next;
				return prev.data;
			}
		}

		/**
		 * Removes the next node from the collection Only removes if next() has been
		 * called before
		 * 
		 * @throw IllegalStateException if no next() has been called
		 */
		public void remove() throws IllegalStateException {
			if (!canRemove || temp == null) {
				throw new IllegalStateException();
			}
			temp.next = current;
			prev = temp;
			canRemove = false;
		}

	}
}
