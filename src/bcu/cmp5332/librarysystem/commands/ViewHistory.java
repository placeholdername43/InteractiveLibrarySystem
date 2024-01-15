package bcu.cmp5332.librarysystem.commands;

import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.model.Loan;
import bcu.cmp5332.librarysystem.model.Patron;

import java.time.LocalDate;

public class ViewHistory implements Command {

    private final int patronId;

    public ViewHistory(int patronId) {
        this.patronId = patronId;
    }

    @Override
    public void execute(Library library, LocalDate currentDate) throws LibraryException {
        Patron patron = library.getPatronByID(patronId);
        System.out.println("Loan History for " + patron.getName() + ":");

        for (Loan loan : patron.getLoanHistory()) {
            System.out.println("Book ID: " + loan.getBook().getId() +
                               ", Title: " + loan.getBook().getTitle() +
                               ", Loan Start Date: " + loan.getStartDate() +
                               ", Due Date: " + loan.getDueDate() +
                               ", Return Date: " + loan.getReturnDate() +
                               ", Loan Completed: " + loan.getIsComplete());
        }
    }
}