package bcu.cmp5332.librarysystem.commands;

import bcu.cmp5332.librarysystem.data.LibraryData;
import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.model.Patron;

import java.io.IOException;
import java.time.LocalDate;

public class AddPatron implements Command {

	private final String name;
	private final String phone;
	private final String email;
	

	public AddPatron(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	@Override
	public void execute(Library library, LocalDate currentDate) throws LibraryException {
		int maxId = 0;
		if (library.getPatrons().size() > 0) {
			int lastIndex = library.getPatrons().size() -1;
			maxId = library.getPatrons().get(lastIndex).getId();
		}
		Patron patron = new Patron(++maxId, name, phone, email);
		library.addPatron(patron);
		
		// clean up needed here
		try {
			LibraryData.store(library);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Patron ID: " + patron.getId() + " added");
	}
}
