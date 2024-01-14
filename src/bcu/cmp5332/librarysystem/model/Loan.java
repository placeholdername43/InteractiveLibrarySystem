package bcu.cmp5332.librarysystem.model;

import java.time.LocalDate;
import java.util.List;

public class Loan {
    private Patron patron;
    private Book book;
    private LocalDate startDate;
    private LocalDate dueDate;
    private boolean isComplete;
    private boolean terminated; //indicates if the loan is terminated
    private LocalDate returnDate; //stores the return date of the book
 
    
    public Loan(Patron patron, Book book, LocalDate startDate, LocalDate dueDate) {
        this.patron = patron;
        this.book = book;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.isComplete = false;
        this.terminated = false;
        this.returnDate = null;
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

	public void setDueDate() {
		this.dueDate = dueDate;
	}

	public boolean getIsComplete(){
		return isComplete;
	}
	
	public void setIsComplete() {
		this.isComplete = isComplete;
		
	}
	
	public boolean isTerminated() {
        return terminated;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }


    public void terminateLoan(LocalDate returnDate) {
        this.terminated = true;
        this.returnDate = returnDate;
        this.isComplete = true; 
    }
    
    
	

}
