package bcu.cmp5332.librarysystem.model;

import java.time.LocalDate;

public class Loan {

	private Patron patron;
	private Book book;
	private LocalDate startDate;
	private LocalDate dueDate;
	private LocalDate returnDate;
	private boolean isComplete;


	public Loan(Patron patron, Book book, LocalDate startDate, LocalDate dueDate, LocalDate returnDate) {
		this.patron = patron;
		this.book = book;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.isComplete = false;
	}

	// TODO: implementation of Getter and Setter methods

	public Patron getPatron() {
		return patron;
	}

	public void setPatron() {
		this.patron = patron;
	}

	public Book getBook() {
		return book;
	}

	public void setBook() {
		this.book = book;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate() {
		this.startDate = startDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public boolean getIsComplete(){
		return isComplete;
	}
	
	public void setIsComplete() {
		this.isComplete = isComplete;
		
	}
	
	public LocalDate getReturnDate() {
		return this.returnDate;
	}
	
	public void setReturnDate() {
		this.returnDate = LocalDate.now();
	}

}
