package bcu.cmp5332.librarysystem.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import bcu.cmp5332.librarysystem.model.Book;
import bcu.cmp5332.librarysystem.model.Patron;

public class TestCases {
	Patron patron = new Patron(0, "Test", "0741223234", "test@gmail.com", false);
	Book book = new Book(0, "title", "author", "year", "publisher", false);
	
	@Test
	public void getEmail() {
		assertEquals(patron.getEmail(), "test@gmail.com");
	}
	
	@Test 
	public void setEmail() {
		patron.setEmail("test2@gmail.com");
		assertEquals(patron.getEmail(), "test2@gmail.com");
	}

	
	@Test
	public void getPublisher() {
		assertEquals(book.getPublisher(), "publisher");
	}
	
	@Test
	public void setPublisher() {
		book.setPublisher("publishertest");
		assertEquals(book.getPublisher(), "publishertest");
	}
	
	
	
}
