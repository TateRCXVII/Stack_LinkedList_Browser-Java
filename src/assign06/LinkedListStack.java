package assign06;

import java.util.NoSuchElementException;

/**
 * A stack implemented using a LinkedList
 * @author tate reynolds
 *
 * @param <T> generic objects in the stack
 */
public class LinkedListStack<T> implements Stack<T> {
	
	private SinglyLinkedList<T> list;
	
	/**
	 * Default Constructor
	 */
	public LinkedListStack() {
		list = new SinglyLinkedList<T>();
	}

	@Override
	/**
	 *	{@inheritDoc}
	 */
	public void clear() {
		list.clear();	
	}

	@Override
	/**
	 *	{@inheritDoc}
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	/**
	 *	{@inheritDoc}
	 */
	public T peek() throws NoSuchElementException {
		if(list.getHead() == null)
			throw new NoSuchElementException();
		return list.getFirst();
	}

	@Override
	/**
	 *	{@inheritDoc}
	 */
	public T pop() throws NoSuchElementException {
		if(list.getFirst() == null)
			throw new NoSuchElementException();
		return list.deleteFirst();
	}

	@Override
	/**
	 *	{@inheritDoc}
	 */
	public void push(T element) {
		list.insertFirst(element);
		
	}

	@Override
	/**
	 *	{@inheritDoc}
	 */
	public int size() {
		return list.size();
	}

}
