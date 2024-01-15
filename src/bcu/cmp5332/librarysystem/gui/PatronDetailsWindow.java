package bcu.cmp5332.librarysystem.gui;

import bcu.cmp5332.librarysystem.commands.Command;
import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Patron;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class PatronDetailsWindow extends JFrame implements ActionListener{
	// shows details of a patron borrowing a book
	private MainWindow mw;
	private Patron patron;
	private JButton cancelBtn = new JButton("Close");

	public PatronDetailsWindow(MainWindow mw, Patron patron) {
		this.mw = mw;
		this.patron = patron;
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
		setSize(300,150);

		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1,3));

		topPanel.add(new JLabel("Name : " + patron.getName()));
		topPanel.add(new JLabel("Phone : " + patron.getPhone()));
		topPanel.add(new JLabel("Email : " + patron.getEmail()));
		
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
