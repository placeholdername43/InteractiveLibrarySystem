package bcu.cmp5332.librarysystem.commands;

import bcu.cmp5332.librarysystem.model.Book;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.main.LibraryException;
import java.time.LocalDate;

/**
 * The {@code AddBook} class implements the {@code Command} interface and utilises a command
 * for adding a new book to the library.
 * <p>
 * When ran, it makes a new {@code Book} object with the specified title, author, publication year,
 * publisher, and deletion status. The new book is then added to the provided {@code Library} instance.
 * The execution also prints a message indicating the successful addition of the book along with its assigned ID.
 * </p>
 *
 * 
 */



public class AddBook implements  Command {

    private final String title;
    private final String author;
    private final String publicationYear;
    private final String publisher;
    private final boolean isDeleted;
    
    public AddBook(String title, String author, String publicationYear, String publisher, boolean isDeleted) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.isDeleted = isDeleted;
    }
    
    @Override
    public void execute(Library library, LocalDate currentDate) throws LibraryException {
        int maxId = 0;
    	if (library.getBooks().size() > 0) {
    		int lastIndex = library.getBooks().size() - 1;
            maxId = library.getBooks().get(lastIndex).getId();
    	}
        Book book = new Book(++maxId, title, author, publicationYear, publisher, isDeleted);
        library.addBook(book);
        System.out.println("Book #" + book.getId() + " added.");
    }
}
 