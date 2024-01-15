package bcu.cmp5332.librarysystem.model;

import bcu.cmp5332.librarysystem.main.LibraryException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Patron {

	private int id;
	private String name;
	private String phone;
	private final List<Book> books = new ArrayList<>();
	private String email;
	private boolean isDeleted;
	private final List<Loan> loanHistory = new ArrayList<>();

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

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setID() {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDetailsShort() {
		return "Patron #" + id + " - " + name;
	}

	public void borrowBook(Book book, LocalDate dueDate) throws LibraryException {
		if (book.isOnLoan()) {
			throw new LibraryException("Book is already loaned");
		}
		Loan loan = new Loan(this, book, LocalDate.now(), dueDate, null);
		book.setLoan(loan);
		books.add(book);
		

	}

	public void renewBook(Book book, LocalDate dueDate) throws LibraryException {
		Loan loan = book.getLoan();
		
		if (loan == null) {
			throw new LibraryException("Book not loaned");
		}
		book.setDueDate(dueDate);
		
	}

	public void returnBook(Book book) throws LibraryException {
		Loan loan = book.getLoan();
		loan.setReturnDate();
		addLoanToHistory(loan);
		this.books.remove(book);
		book.returnToLibrary();
		
	}

	public void addBook(Book book) {
		this.books.add(book);
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}
	
	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	public int getNumberOfBooks() {
		return books.size();
	}
	
	public List<Book> getBooks(){
		return Collections.unmodifiableList(books);
	}
	
	public List<Loan> getLoanHistory(){
		return Collections.unmodifiableList(loanHistory);
	}
	
	public void addLoanToHistory(Loan loan) {
		this.loanHistory.add(loan);
	}
	
	
}
