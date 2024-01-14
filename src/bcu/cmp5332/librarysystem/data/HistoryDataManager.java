package bcu.cmp5332.librarysystem.data;

import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Book;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.model.Loan;
import bcu.cmp5332.librarysystem.model.Patron;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class HistoryDataManager implements DataManager {

	public final String RESOURCE = "./resources/data/history.txt";


	@Override
	public void loadData(Library library) throws IOException, LibraryException {
		try (Scanner sc = new Scanner(new File(RESOURCE))) {
			
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] properties = line.split(SEPARATOR, -1);

				int patronID = Integer.parseInt(properties[0]);
				int bookID = Integer.parseInt(properties[1]);
				LocalDate startDate = LocalDate.parse(properties[2]);
				LocalDate dueDate = LocalDate.parse(properties[3]);
				boolean isComplete = Boolean.parseBoolean(properties[5]);

				Patron patron = library.getPatronByID(patronID);
				Book book = library.getBookByID(bookID);

				Loan loan = new Loan(patron, book, startDate, dueDate);
				//loan.terminateLoan(returnDate);  // Assuming all loans in history are completed
				patron.getLoanHistory().add(loan); // Adding to the patron's loan history
			}
		} catch (NumberFormatException ex) {
			throw new LibraryException("Error parsing loan history on line: " + ex.getMessage());
		}
		
	}

	 @Override
	    public void storeData(Library library) throws IOException {
	        try (PrintWriter out = new PrintWriter(new FileWriter(RESOURCE))) {
	            for (Patron patron : library.getPatrons()) {
					for (Loan loan : patron.getLoanHistory()) {
						out.print(loan.getPatron().getId() + SEPARATOR);
						out.print(loan.getBook().getId() + SEPARATOR);
						out.print(loan.getStartDate() + SEPARATOR);
						out.print(loan.getDueDate() + SEPARATOR);
						out.println();
					}
	            }
	        }
	    }
	}