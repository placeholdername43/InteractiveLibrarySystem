package bcu.cmp5332.librarysystem.commands;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import bcu.cmp5332.librarysystem.data.LibraryData;
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


		if(patron.getBooks().contains(book)) {
			patron.returnBook(book);
			System.out.println("Patron " + patronID + " returned " + "Book " + bookID);
		}else {
			System.out.println("Patron " + patronID + " does not have Book " + bookID);
		}
	}




}
