package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListStackTest {

	@Test
	void clearTest() {
		LinkedListStack<String> list = new LinkedListStack<>();
		list.push("hi");
		list.push("ho");
		list.push("he");
		list.push("ha");
		
		list.clear();
		
		assertEquals(0, list.size());
		assertThrows(NoSuchElementException.class, () -> list.peek());
		assertTrue(list.isEmpty());
	}
	
	@Test
	void isEmptyTrueTest() {
		LinkedListStack<String> list = new LinkedListStack<>();
		
		assertTrue(list.isEmpty());
	}
	
	@Test
	void isEmptyFalseTest() {
		LinkedListStack<String> list = new LinkedListStack<>();
		list.push("hi");
		list.push("ho");
		list.push("he");
		list.push("ha");
		
		assertFalse(list.isEmpty());
	}
	
	@Test
	void isEmptyPopAllTest() {
		LinkedListStack<String> list = new LinkedListStack<>();
		list.push("hi");
		list.push("ho");
		list.push("he");
		list.push("ha");
		
		list.pop();
		list.pop();
		list.pop();
		list.pop();
		
		assertTrue(list.isEmpty());
	}
	
	@Test
	void peekTest() {
		LinkedListStack<String> list = new LinkedListStack<>();
		list.push("hi");
		list.push("ho");
		list.push("he");
		list.push("ha");
		
		assertEquals("ha", list.peek());
	}
	
	@Test
	void peekAfterPopTest() {
		LinkedListStack<String> list = new LinkedListStack<>();
		list.push("hi");
		list.push("ho");
		list.push("he");
		list.push("ha");
		list.pop();
		
		assertEquals("he", list.peek());
	}
	
	@Test
	void peekIntTest() {
		LinkedListStack<Integer> list = new LinkedListStack<>();
		list.push(4);
		list.push(5);
		list.push(9);
		list.push(2);
		
		assertEquals(2, list.peek());
	}
	
	@Test
	void peekThrowsTest() {
		LinkedListStack<String> list = new LinkedListStack<>();
		assertThrows(NoSuchElementException.class, () -> list.peek());
	}
	
	@Test
	void popTest() {
		LinkedListStack<String> list = new LinkedListStack<>();
		list.push("hi");
		list.push("ho");
		list.push("he");
		list.push("ha");
		
		assertEquals("ha", list.pop());
		assertEquals(3, list.size());
		assertEquals("he", list.peek());
	}
	
	@Test
	void popThrowsTest() {
		LinkedListStack<String> list = new LinkedListStack<>();
		assertThrows(NoSuchElementException.class, () -> list.pop());
	}
	
	@Test
	void pushTest() {
		LinkedListStack<String> list = new LinkedListStack<>();
		list.push("hi");
		list.push("ho");
		list.push("he");
		list.push("ha");
		
		String[] exp = {"ha", "he", "ho", "hi"};
		
		assertEquals(4, list.size());
		for(int i = 0; i < exp.length; i++) {
			assertEquals(exp[i], list.pop());
		}
	}
	
	@Test
	void sizeTest() {
		LinkedListStack<String> list = new LinkedListStack<>();
		list.push("hi");
		list.push("ho");
		list.push("he");
		list.push("ha");
		list.push("hi");
		list.push("ho");
		list.push("he");
		list.push("ha");
		list.push("hi");
		list.push("ho");
		list.push("he");
		list.push("ha");
		list.push("hi");
		list.push("ho");
		list.push("he");
		list.push("ha");
		list.push("hi");
		list.push("ho");
		list.push("he");
		list.push("ha");
		list.push("hi");
		list.push("ho");
		list.push("he");
		list.push("ha");
		
		assertEquals(24, list.size());
	}
	
	@Test
	void sizeEmptyTest() {
		LinkedListStack<String> list = new LinkedListStack<>();
		
		assertEquals(0, list.size());
	}

}
