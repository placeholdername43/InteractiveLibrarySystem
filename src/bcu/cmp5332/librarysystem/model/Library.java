package bcu.cmp5332.librarysystem.model;

import bcu.cmp5332.librarysystem.main.LibraryException;
import java.util.*;

public class Library {

	private final int loanPeriod = 7;
	private final Map<Integer, Patron> patrons = new TreeMap<>();
	private final Map<Integer, Book> books = new TreeMap<>();
	private final int borrowLimit = 2;
	
	public int getLoanPeriod() {
		return loanPeriod;
	}

	public List<Book> getBooks() {
		List<Book> out = new ArrayList<>(books.values());
		return Collections.unmodifiableList(out);
	}

	//Adding getPatrons
	public List<Patron> getPatrons(){
		List<Patron> patronList = new ArrayList<>(patrons.values());
		return Collections.unmodifiableList(patronList);
	}

	public Book getBookByID(int id) throws LibraryException {
		if (!books.containsKey(id)) {
			throw new LibraryException("There is no such book with that ID.");
		}
		return books.get(id);
	}

	public Patron getPatronByID(int id) throws LibraryException {
		if (!patrons.containsKey(id)) {
			throw new LibraryException("There is no patron with such ID");
		}
		return patrons.get(id);
	}

	public void addBook(Book book) {
		if (books.containsKey(book.getId())) {
			throw new IllegalArgumentException("Duplicate book ID.");
		}
		books.put(book.getId(), book);
	}

	public void addPatron(Patron patron) {
		if(patrons.containsKey(patron.getId())) {
			throw new IllegalArgumentException("Duplicate Patron ID");
		}
		patrons.put(patron.getId(), patron);
	}

	public int getBorrowLimit() {
		return borrowLimit;
	}


}
