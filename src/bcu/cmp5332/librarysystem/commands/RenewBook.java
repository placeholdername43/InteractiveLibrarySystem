package bcu.cmp5332.librarysystem.commands;

import java.time.LocalDate;

import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Book;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.model.Patron;

public class RenewBook implements Command{
	
	private final int patronID;
	private final int bookID;

	public RenewBook(int patronID, int bookID) {
		this.patronID = patronID;
		this.bookID = bookID;
	}

	@Override
	public void execute(Library library, LocalDate currentDate) throws LibraryException {
		LocalDate dueDate =  currentDate.plusDays(library.getLoanPeriod());
		Patron patron = library.getPatronByID(patronID);
		Book book = library.getBookByID(bookID);
		
		if(patron.getIsDeleted()) {
			throw new LibraryException("No patron with this ID");
		}else if (book.getIsDeleted()) {
			throw new LibraryException("No book with this ID");
		}
		
		patron.renewBook(book, dueDate);
		System.out.println("Book renewed until: " + dueDate);
	}

}
