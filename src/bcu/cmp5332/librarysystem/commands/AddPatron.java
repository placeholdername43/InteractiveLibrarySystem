package bcu.cmp5332.librarysystem.commands;

import bcu.cmp5332.librarysystem.data.LibraryData;
import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.model.Patron;

import java.io.IOException;
import java.time.LocalDate;

/**
 * The {@code AddPatron} class implements the {@code Command} interface and represents a command
 * for adding a new patron to the library.
 * <p>
 * When exectyued, it creates a new {@code Patron} object with the speciofed name, phone number, email,
 * and deletion status. The new patron is then added to the provided {@code Library} instance.
 * The execution also prints a message showing the successful addition of the patron along with its assigned ID.
 * </p>
 *

 */


public class AddPatron implements Command {

	private final String name;
	private final String phone;
	private final String email;
	private final boolean isDeleted;
	

	public AddPatron(String name, String phone, String email, boolean isDeleted) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.isDeleted = isDeleted;
	}

	@Override
	public void execute(Library library, LocalDate currentDate) throws LibraryException {
		int maxId = 0;
		if (library.getPatrons().size() > 0) {
			int lastIndex = library.getPatrons().size() -1;
			maxId = library.getPatrons().get(lastIndex).getId();
		}
		Patron patron = new Patron(++maxId, name, phone, email, isDeleted);
		library.addPatron(patron);
		
		System.out.println("Patron ID: " + patron.getId() + " added");
	}
}
