package bcu.cmp5332.librarysystem.commands;

import java.io.IOException;
import java.time.LocalDate;

import bcu.cmp5332.librarysystem.data.LibraryData;
import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.model.Patron;

public class DeletePatron implements Command{

	private final int patronID;
	
	public DeletePatron(int patronID) {
		this.patronID = patronID;
	}
	
	
	@Override
	public void execute(Library library, LocalDate currentDate) throws LibraryException {
		// TODO Auto-generated method stub
		Patron patron = library.getPatronByID(patronID);
		patron.setIsDeleted(true);
		System.out.println(patron.getDetailsShort() + "Deleted");
		try {
			LibraryData.store(library);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
