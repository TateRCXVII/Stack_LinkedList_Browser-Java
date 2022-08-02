package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class WebBrowserTest {

	@Test
	void constructorTest() {
		SinglyLinkedList<URL> history = new SinglyLinkedList<URL>();
		URL link0;
		URL link1; 
		URL link2; 
		URL link3;
		URL link4;
		URL link5;
		try {
			link0 = new URL("https://a");
			link1= new URL("https://b"); 
			link2 = new URL("https://c"); 
			link3 = new URL("https://d"); 
			link4 = new URL("https://e"); 
			link5 = new URL("https://f"); 
			
			history.insertFirst(link0);
			history.insertFirst(link1);
			history.insertFirst(link2);
			history.insertFirst(link3);
			history.insertFirst(link4);
			history.insertFirst(link5);

		} catch (MalformedURLException e) {
			System.out.println("Incorrect URL:" + e.getMessage());
			e.printStackTrace();
			fail("Error Thrown");
		} 

		Object[] urlArr = history.toArray();
		
		WebBrowser<URL> browser = new WebBrowser<>(history);
		
		assertArrayEquals(urlArr, browser.history().toArray());
	}
	
	@Test
	void visitTest() {
		WebBrowser<URL> browser = new WebBrowser<>();
		try {
			browser.visit(new URL("https://a"));
		} catch (MalformedURLException e) {
			System.out.println("Incorrect URL:" + e.getMessage());
			e.printStackTrace();
			fail("Error Thrown");
		}
		
		assertEquals("https://a", browser.getCurrent().toString());
	}
	
	@Test
	void visitHistoryTest(){
		WebBrowser<URL> browser = new WebBrowser<>();
		SinglyLinkedList<URL> expectedHist = new SinglyLinkedList<>();
		for(int i = 0; i < 100; i++) {
			try {
				browser.visit(new URL("https://" + i));
				expectedHist.insertFirst(new URL("https://" + i));
			} catch (MalformedURLException e) {
				System.out.println("Incorrect URL:" + e.getMessage());
				e.printStackTrace();
				fail("Error Thrown");
			}

		}
		
		assertEquals("https://99", browser.getCurrent().toString());
		assertArrayEquals(expectedHist.toArray(), browser.history().toArray());
	}
	
	
	@Test
	void backAfterHistoryTest(){
		WebBrowser<URL> browser = new WebBrowser<>();
		for(int i = 0; i < 100; i++) {
			try {
				browser.visit(new URL("https://" + i));
			} catch (MalformedURLException e) {
				System.out.println("Incorrect URL:" + e.getMessage());
				e.printStackTrace();
				fail("Error Thrown");
			}
		}
		browser.history();
		
		assertEquals("https://98", browser.back().toString());
		assertEquals("https://98", browser.getCurrent().toString());
	}
	
	
	@Test
	void backThrowsTest() {
		WebBrowser<URL> browser = new WebBrowser<>();
		assertThrows(NoSuchElementException.class, () -> browser.back());
	}
	
	@Test
	void backTest() {
		WebBrowser<URL> browser = new WebBrowser<>();
		for(int i = 0; i < 100; i++) {
			try {
				browser.visit(new URL("https://" + i));

			} catch (MalformedURLException e) {
				System.out.println("Incorrect URL:" + e.getMessage());
				e.printStackTrace();
				fail("Error Thrown");
			}
		}
		assertEquals("https://98", browser.back().toString());
		assertEquals("https://98", browser.getCurrent().toString());
		browser.back();
		browser.back();
		browser.back();
		browser.back();
		assertEquals("https://93", browser.back().toString());
		assertEquals("https://93", browser.getCurrent().toString());
	}
	
	@Test
	void forwardThrowsTest() {
		WebBrowser<URL> browser = new WebBrowser<>();
		assertThrows(NoSuchElementException.class, () -> browser.forward());
	}
	
	@Test
	void forwardTest() {
		WebBrowser<URL> browser = new WebBrowser<>();
		for(int i = 0; i < 100; i++) {
			try {
				browser.visit(new URL("https://" + i));

			} catch (MalformedURLException e) {
				System.out.println("Incorrect URL:" + e.getMessage());
				e.printStackTrace();
				fail("Error Thrown");
			}
		}
		for(int j = 0; j < 10; j++) {
			browser.back();
		}
		assertEquals("https://90", browser.forward().toString());
		assertEquals("https://90", browser.getCurrent().toString());
	}
	
	@Test
	void forwardTilEndTest() {
		WebBrowser<URL> browser = new WebBrowser<>();
		for(int i = 0; i < 100; i++) {
			try {
				browser.visit(new URL("https://" + i));

			} catch (MalformedURLException e) {
				System.out.println("Incorrect URL:" + e.getMessage());
				e.printStackTrace();
				fail("Error Thrown");
			}
		}
		
		for(int j = 0; j < 10; j++) {
			browser.back();
		}
		
		for(int j = 0; j < 10; j++) {
			browser.forward();
		}
		assertThrows(NoSuchElementException.class, () -> browser.forward());
	}
	
	@Test
	void forwardAfterHistoryTest(){
		WebBrowser<URL> browser = new WebBrowser<>();
		for(int i = 0; i < 100; i++) {
			try {
				browser.visit(new URL("https://" + i));
			} catch (MalformedURLException e) {
				System.out.println("Incorrect URL:" + e.getMessage());
				e.printStackTrace();
				fail("Error Thrown");
			}
		}
		browser.history();
		browser.back();
		
		assertEquals("https://99", browser.forward().toString());
		assertEquals("https://99", browser.getCurrent().toString());
	}

}
