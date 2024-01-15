package bcu.cmp5332.librarysystem.commands;

import java.io.IOException;
import java.time.LocalDate;

import bcu.cmp5332.librarysystem.data.LibraryData;
import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Book;
import bcu.cmp5332.librarysystem.model.Library;

public class DeleteBook implements Command{
	
	private final int bookID;
	
	public DeleteBook(int bookID) {
		this.bookID = bookID;
	}

	@Override
	public void execute(Library library, LocalDate currentDate) throws LibraryException {
		Book book = library.getBookByID(bookID);
		
		
		if(book.isOnLoan()) {
			System.out.println("CANNOT DELETE LOANED BOOK");
		}else {
			book.setIsDeleted(true);
			System.out.println(book.getDetailsShort() + " Deleted");
		}
	}
}
