package bcu.cmp5332.librarysystem.commands;


import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.model.Patron;

import java.util.*;
import java.time.LocalDate;

public class ListPatrons implements Command {

	@Override
	public void execute(Library library, LocalDate currentDate) throws LibraryException {
		List<Patron> patrons = library.getPatrons();
		for (Patron patron: patrons) {
			System.out.println(patron.getDetailsShort());
		}
		System.out.println(patrons.size() + " Patron(s)");
	}
	

}
