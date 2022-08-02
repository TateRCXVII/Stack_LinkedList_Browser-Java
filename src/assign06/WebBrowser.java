package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * WebBrowser class that keeps track of history, current URL, previous URLs, and forward URLs
 * @author tate reynolds
 *
 * @param <URL> a website URL
 */
public class WebBrowser<URL> {
	private ArrayStack<URL> front;
	private ArrayStack<URL> back;
	private URL current;
	
	/**
	 * Default constructor
	 */
	public WebBrowser() {
		front = new ArrayStack<URL>();
		back = new ArrayStack<URL>();
		current = null;
	}
	
	/**
	 * Creates a WebBrowser with a pre-existing history
	 * @param history - linked list of already visited URLs
	 */
	public WebBrowser(SinglyLinkedList<URL> history) {
		SinglyLinkedList<URL> temp = new SinglyLinkedList<>();

		front = new ArrayStack<URL>();
		back = new ArrayStack<URL>();
		
		//copy history over to a temp list
		while(!history.isEmpty())
			temp.insertFirst(history.deleteFirst());
		
		//fill the back stack and refill the history
		while(!temp.isEmpty()) {
			back.push(temp.getFirst());
			history.insertFirst(temp.deleteFirst());
		}
		
		//set current URL to latest visited
		current = back.pop();
	}
	/**
	 * Returns the current URL
	 * @return the current URL
	 */
	public URL getCurrent() {
		return this.current;
	}
	
	/**
	 * Visits the parameter webpage and adds the previous webpage to the back stack
	 * @param webpage - URL to be visited
	 */
	public void visit(URL webpage) {
		if(current != null)
			back.push(current);
		this.current = webpage;
		front.clear();
	}
	
	/**
	 * Goes back to the previous URL
	 * @return - the previous visited URL 
	 * @throws NoSuchElementException - if back is empty
	 */
	public URL back() throws NoSuchElementException{
		if(back.isEmpty())
			throw new NoSuchElementException();
		
		front.push(current);
		current = back.pop();
		return current;
	}
	
	/**
	 * Goes to the next URL if back button has been called
	 * @return the next URL
	 * @throws NoSuchElementException if no back has been called (i.e. front is empty)
	 */
	public URL forward() throws NoSuchElementException{
		if(front.isEmpty() == true)
			throw new NoSuchElementException();
		
		back.push(current);
		current = front.pop();
		return current;
	}
	
	/**
	 * Returns the history of URLs visited
	 * @return history of URLs
	 */
	public SinglyLinkedList<URL> history(){
		SinglyLinkedList<URL> history = new SinglyLinkedList<>();
		ArrayStack<URL> temp = new ArrayStack<>();
		
		while(!back.isEmpty())
			temp.push(back.pop());
			
		//refill back and fill history
		while(!temp.isEmpty()) {
			back.push(temp.peek());
			history.insertFirst(temp.pop());
			
		}
		//include the current URL
		history.insertFirst(current);
		
		return history;
	}
	
}
