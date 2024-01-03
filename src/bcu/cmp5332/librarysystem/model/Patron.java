package bcu.cmp5332.librarysystem.model;

import bcu.cmp5332.librarysystem.main.LibraryException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patron {

	private int id;
	private String name;
	private String phone;
	private final List<Book> books = new ArrayList<>();
	private String email;
	private boolean isDeleted;

	// TODO: implement constructor here
	public Patron(int id, String name, String phone, String email, boolean isDeleted) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.isDeleted = isDeleted;
	}

	public int getId() {
		return id;
	} 

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public void setName() {
		this.name = name;
	}

	public void setPhone() {
		this.phone = phone;
	}

	public void setID() {
		this.id = id;
	}

	public void setEmail() {
		this.email = email;
	}
	
	public String getDetailsShort() {
		return "Patron #" + id + " - " + name;
	}

	public void borrowBook(Book book, LocalDate dueDate) throws LibraryException {
		if (book.isOnLoan()) {
			throw new LibraryException("Book is already loaned");
		}
		Loan loan = new Loan(this, book, LocalDate.now(), dueDate);
		book.setLoan(loan);
		books.add(book);

	}

	public void renewBook(Book book, LocalDate dueDate) throws LibraryException {
		// TODO: implementation here
	}

	public void returnBook(Book book) throws LibraryException {
		this.books.remove(book);
		book.returnToLibrary();
	}

	public void addBook(Book book) {
		this.books.add(book);
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}
	
	public void setIsDeleted() {
		this.isDeleted = isDeleted;
	}
	
	public int getNumberOfBooks() {
		return books.size();
	}
	
	public List<Book> getBooks(){
		return this.books;
	}
	
	
	
}
