package assign06;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {


	//Iterator Tests
	@Test
	void iteratorNextEmptyTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		Iterator<Integer> itr = list.iterator();
		
		assertThrows(NoSuchElementException.class, () -> itr.next());

	}
	
	@Test
	void iteratorNextTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(3);
		list.insertFirst(13);
		list.insertFirst(12);
		list.insertFirst(4);
		Iterator<Integer> itr = list.iterator();

		
		assertTrue(itr.hasNext());
		assertEquals(4, itr.next());
		
	}
	
	@Test
	void iteratorNextEndOfListTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(3);
		list.insertFirst(13);
		list.insertFirst(12);
		list.insertFirst(4);
		Iterator<Integer> itr = list.iterator();

		itr.next();
		itr.next();
		itr.next();
		itr.next();
		itr.next();
		
		assertFalse(itr.hasNext());
		assertThrows(NoSuchElementException.class, () -> itr.next());
	}
	
	@Test
	void iteratorHasNextTrueTest() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("sw");
		list.insertFirst("as");
		list.insertFirst("tf");
		list.insertFirst("yu");
		list.insertFirst("wh");
		Iterator<String> itr = list.iterator();
		
		itr.next();
		assertTrue(itr.hasNext());
	}
	
	@Test
	void iteratorHasNextFalseTest() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		Iterator<String> itr = list.iterator();
		
		assertFalse(itr.hasNext());
	}
	
	@Test
	void iteratorRemoveTest() {
		
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(3);
		list.insertFirst(13);
		list.insertFirst(12);
		list.insertFirst(4);
		Iterator<Integer> itr = list.iterator();
		itr.next();
		itr.next();
		itr.remove();
		assertEquals(13, list.get(1));
	}
	
	@Test
	void iteratorRemoveTwiceTest() {
		
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(3);
		list.insertFirst(13);
		list.insertFirst(12);
		list.insertFirst(4);
		Iterator<Integer> itr = list.iterator();
		itr.next();
		itr.next();
		itr.remove();
		assertThrows(IllegalStateException.class, () -> itr.remove());
	}
	
	@Test
	void iteratorRemoveNoNextTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(3);
		list.insertFirst(13);
		list.insertFirst(12);
		list.insertFirst(4);
		Iterator<Integer> itr = list.iterator();
		
		assertThrows(IllegalStateException.class, () -> itr.remove());
	}
	
	
	//SinglyLinkedList Methods Tests
	@Test
	void insertFirstTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		
		assertEquals(1, list.size());
		assertEquals(1, list.getFirst());
	}
	@Test
	void insertFirstStringTest() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hollow");
		
		assertEquals(1, list.size());
		assertEquals("Hollow", list.getFirst());
	}

	@Test
	void insertTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(3);
		list.insertFirst(13);
		list.insertFirst(12);
		list.insertFirst(4);
		
		list.insert(2, 500);
		
		assertEquals(500, list.get(2));
		assertEquals(13, list.get(3));
		assertEquals(12, list.get(1));
	}
	
	@Test
	void getFirstTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(3);
		list.insertFirst(13);
		list.insertFirst(12);
		list.insertFirst(4);
		
		assertEquals(4, list.getFirst());
	}
	
	@Test
	void getFirstNullTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		
		assertThrows(NoSuchElementException.class, () -> list.getFirst());
	}
	
	@Test
	void getTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(3);
		list.insertFirst(13);
		list.insertFirst(12);
		list.insertFirst(4);
		
		assertEquals(3, list.get(3));
	}
	
	@Test
	void getIOOBTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(3);
		list.insertFirst(13);
		list.insertFirst(12);
		list.insertFirst(4);
		
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(10));
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(-10));
	}
	
	@Test
	void deleteFirstTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(3);
		list.insertFirst(13);
		list.insertFirst(12);
		list.insertFirst(4);
		
		assertEquals(4, list.deleteFirst());
		assertEquals(12, list.getFirst());
		assertEquals(4, list.size());
	}
	
	@Test
	void deleteTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(3);
		list.insertFirst(13);
		list.insertFirst(12);
		list.insertFirst(4);
		
		assertEquals(13, list.delete(2));
		assertEquals(3, list.get(2));
		assertEquals(4, list.size());
	}
	
	@Test
	void indexOfTest() {	
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(3);
		list.insertFirst(13);
		list.insertFirst(12);
		list.insertFirst(4);
		
		assertEquals(2, list.indexOf(13));
	}
	
	@Test
	void indexOfStringTest() {	
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("beep");
		list.insertFirst("boop");
		list.insertFirst("bop");
		list.insertFirst("bam");
		list.insertFirst("kaboom");
		
		assertEquals(3, list.indexOf("boop"));
	}
	
	@Test
	void indexOfNoElementTest() {	
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(3);
		list.insertFirst(13);
		list.insertFirst(12);
		list.insertFirst(4);
		
		assertEquals(-1, list.indexOf(20));
	}
	
	@Test
	void sizeTest() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("beep");
		list.insertFirst("boop");
		list.insertFirst("bop");
		list.insertFirst("bam");
		list.insertFirst("kaboom");
		
		assertEquals(5, list.size());
	}
	
	@Test
	void largeSizeTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		for(int i = 0; i < 1000; i++)
			list.insertFirst(i);
		
		assertEquals(1000, list.size());
	}
	
	@Test
	void sizeEmptyTest() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		
		assertEquals(0, list.size());
	}
	
	@Test
	void isEmptyFalseTest() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("beep");
		list.insertFirst("boop");
		list.insertFirst("bop");
		list.insertFirst("bam");
		list.insertFirst("kaboom");
		
		assertFalse(list.isEmpty());
	}
	
	@Test
	void isEmptyTrueTest() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		
		assertTrue(list.isEmpty());
	}
	
	@Test
	void clearTest() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("beep");
		list.insertFirst("boop");
		list.insertFirst("bop");
		list.insertFirst("bam");
		list.insertFirst("kaboom");
		list.clear();
		
		assertEquals(0, list.size());
		assertThrows(NoSuchElementException.class, ()->list.getFirst());
	}
	
	@Test
	void toArrayTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(3);
		list.insertFirst(13);
		list.insertFirst(12);
		list.insertFirst(4);
		
		Integer[] listArr = {4, 12, 13, 3, 1};
		assertArrayEquals(listArr, list.toArray());
	}
	
	@Test
	void toArrayEmptyTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		
		Integer[] listArr = {};
		assertArrayEquals(listArr, list.toArray());
	}
	
	@Test
	void endOfListRemove() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		
		assertEquals(1, list.delete(0));
		
	}
}
