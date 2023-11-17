package bcu.cmp5332.librarysystem.commands;

import bcu.cmp5332.librarysystem.model.Book;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.main.LibraryException;

import java.time.LocalDate;
import java.util.List;

public class Borrow implements Command {
	
	
	@Override
	public void execute(Library library, LocalDate currentDate) throws LibraryException {
		
	}
}
