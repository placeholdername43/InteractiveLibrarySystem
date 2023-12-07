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

	public BorrowBook(int bookID, int patronID) {
		this.bookID = bookID;
		this.patronID = patronID;
	}

	@Override
	public void execute(Library library, LocalDate currentDate) throws LibraryException {
		LocalDate dueDate = currentDate.plusDays(library.getLoanPeriod());
		Patron patron = library.getPatronByID(patronID);
		Book book = library.getBookByID(bookID);

		patron.borrowBook(book, dueDate);

	}
}

