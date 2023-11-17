package bcu.cmp5332.librarysystem.commands;

import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.model.Patron;

import java.time.LocalDate;

public class AddPatron implements Command {

	private final String name;
	private final String phone;

	public AddPatron(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	@Override
	public void execute(Library library, LocalDate currentDate) throws LibraryException {
		int maxid = 0;
		if (library.getPatrons().size() > 0) {
			int lastIndex = library.getPatrons().size() -1;
			maxid = library.getBooks().get(lastIndex).getId();
		}
		Patron patron = new Patron(maxid, name, phone);
		library.addPatron(patron);
		System.out.println("Patron added");
	}
}
