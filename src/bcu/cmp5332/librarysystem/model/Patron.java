package bcu.cmp5332.librarysystem.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bcu.cmp5332.librarysystem.main.LibraryException;

public class Patron {
    private int id;
    private String name;
    private String phone;
    private String email;
    private boolean isDeleted;
    private List<Loan> loans; // history of loans
    private List<Book> books; // Declaration of the books list

    public Patron(int id, String name, String phone, String email, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.isDeleted = isDeleted;
        this.loans = new ArrayList<>();
        this.books = new ArrayList<>(); // Initialisation of the books list
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
            throw new LibraryException("Book is already on loan");
        }
        Loan newLoan = new Loan(this, book, LocalDate.now(), dueDate);
        loans.add(newLoan);
        book.setLoan(newLoan);
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
	
	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	public int getNumberOfBooks() {
		return books.size();
	}
	
	public List<Book> getBooks(){
		return this.books;
	}
	
	public List<Loan> getLoanHistory() {
        return loans;
    }

	public void renewBook(Book book, LocalDate dueDate) {
		// TODO Auto-generated method stub
		
	}
	
}
