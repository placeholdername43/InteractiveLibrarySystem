package bcu.cmp5332.librarysystem.commands;

import java.time.LocalDate;

import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Book;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.model.Patron;

public class ReturnBook implements Command {
	private int bookID;
	private int patronID;

	public ReturnBook(int patronID, int bookID) {
		this.bookID = bookID;
		this.patronID = patronID;
	}


	@Override
	public void execute(Library library, LocalDate currentDate) throws LibraryException{
		Patron patron = library.getPatronByID(patronID);
		Book book = library.getBookByID(bookID);
	
		patron.returnBook(book);
		System.out.println("Patron " + patronID + " returned " + "Book " + bookID);
	
	}
	



}
