package bcu.cmp5332.librarysystem.gui;

import bcu.cmp5332.librarysystem.model.Book;
import bcu.cmp5332.librarysystem.model.Library;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class BookBorrowedWindow extends JFrame implements ActionListener{

	private MainWindow mw;
	private List<Book> patronBooks;
	private List<Book> booksList;
	private JButton cancelBtn = new JButton("Close");

	public BookBorrowedWindow(MainWindow mw, List<Book> patronBooks) {
		this.mw = mw;
		this.patronBooks = patronBooks;
		initialize();
	}

	/*
	 * Initialize the contents of the frame
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception ex) {
			// TODO?
		}



		setTitle("View patron Details");
		setSize(500,150);

		JPanel topPanel = new JPanel();
		JTable table = new JTable();
		String[] columns;
		Object[][] data;
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1,3));
		booksList = new ArrayList<>(patronBooks);

		columns = new String[]{"Title", "Author", "Publisher", "Pub. Year", "Status"};
        data = new Object[booksList.size()][6];
        for (int i = 0; i < booksList.size(); i++) {
            Book book = booksList.get(i);
            data[i][0] = book.getTitle();
            data[i][1] = book.getAuthor();
            data[i][2] = book.getPublisher();
            data[i][3] = book.getPublicationYear();
            data[i][4] = book.getStatus();
        }

        table = new JTable(data, columns);
        topPanel.add(new JScrollPane(table));
        	
		bottomPanel.add(cancelBtn);
		
		cancelBtn.addActionListener(this);
		this.getContentPane().add(topPanel, BorderLayout.CENTER);
		this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		setLocationRelativeTo(mw);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == cancelBtn) {
			this.setVisible(false);

		}

	}
}
