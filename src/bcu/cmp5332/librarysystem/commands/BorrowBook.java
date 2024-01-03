package bcu.cmp5332.librarysystem.commands;

import bcu.cmp5332.librarysystem.model.Book;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.model.Patron;
import bcu.cmp5332.librarysystem.main.LibraryException;

import java.time.LocalDate;
import java.util.List;

public class BorrowBook implements Command {
	private int bookID;
	private int patronID;

	public BorrowBook(int patronID, int bookID) {
		this.bookID = bookID;
		this.patronID = patronID;
	}

	@Override
	public void execute(Library library, LocalDate currentDate) throws LibraryException {
		LocalDate dueDate = currentDate.plusDays(library.getLoanPeriod());
		Patron patron = library.getPatronByID(patronID);
		Book book = library.getBookByID(bookID);

		
		if(patron.getNumberOfBooks() > library.getBorrowLimit()) {
			System.out.println("Patron has too many books, please return before borrowing more");
			
		}else {
			patron.borrowBook(book, dueDate);
			System.out.println(patron.getNumberOfBooks());
			System.out.println(library.getBorrowLimit());
		}
		

	}
}

