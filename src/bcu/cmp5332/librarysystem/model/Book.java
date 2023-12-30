package bcu.cmp5332.librarysystem.model;

import bcu.cmp5332.librarysystem.main.LibraryException;
import java.time.LocalDate;

public class Book {

	private int id;
	private String title;
	private String author;
	private String publicationYear;
	private String publisher;
	private Loan loan;

	public Book(int id, String title, String author, String publicationYear, String publisher) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.publisher = publisher;
	}

	public int getId() {
		return id;
	} 

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getDetailsShort() {
		return "Book #" + id + " - " + title;
	}

	public String getDetailsLong() {
		String details;

		if (isOnLoan()) {
			details = "Book #" + id
					+ "Title: " + title
					+ "Publication Year: " + getPublicationYear();
			// TODO : Add who book is loaned to

		}else {
			details = "Book #" + id
					+ "Title: " + title
					+ "Publication Year: " + getPublicationYear();
		}

		return details;
	}

	public boolean isOnLoan() {
		return (loan != null);
	}

	public String getStatus() {
		if (isOnLoan()) {
			return "On Loan";
		}else {
			return "Available";
		}
	}

	public LocalDate getDueDate() {
		loan.getDueDate();
		return null;
	}

	public void setDueDate(LocalDate dueDate) throws LibraryException {
		loan.setDueDate();
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public void returnToLibrary() {
		loan = null;
	}

	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher() {
		this.publisher = publisher;
	}
}
