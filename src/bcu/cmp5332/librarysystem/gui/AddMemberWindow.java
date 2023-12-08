package bcu.cmp5332.librarysystem.gui;

import bcu.cmp5332.librarysystem.commands.AddPatron;
import bcu.cmp5332.librarysystem.commands.Command;
import bcu.cmp5332.librarysystem.main.LibraryException;
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


public class AddMemberWindow extends JFrame implements ActionListener{

	private MainWindow mw;
	private JTextField nameText = new JTextField();
	private JTextField phoneText = new JTextField();
	private JTextField emailText = new JTextField();

	private JButton addBtn = new JButton("Add");
	private JButton cancelBtn = new JButton("Cancel");

	public AddMemberWindow(MainWindow mw) {
		this.mw = mw;
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



		setTitle("Add a new Patron");

		setSize(300,200);
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(5,2));
		topPanel.add(new JLabel("Name"));
		topPanel.add(nameText);
		topPanel.add(new JLabel("Email : "));
		topPanel.add(emailText);
		topPanel.add(new JLabel("Phone : "));
		topPanel.add(phoneText);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1,3));
		bottomPanel.add(addBtn);
		bottomPanel.add(cancelBtn);

		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		this.getContentPane().add(topPanel, BorderLayout.CENTER);
		this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		setLocationRelativeTo(mw);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == addBtn) {
			addPatron();
		} else if (ae.getSource() == cancelBtn) {
			this.setVisible(false);
		}
	}

	private void addPatron() {
		try {	
			String name = nameText.getText();
			String email = emailText.getText();
			String phone = phoneText.getText();

			// create and execute the addPatron command
			Command addPatron = new AddPatron(name, email, phone);
			addPatron.execute(mw.getLibrary(), LocalDate.now());
			// refresth the view with the list of patrons
			mw.displayPatrons();
			// hide (close) the AddBookWindow
			this.setVisible(false);
		} catch (LibraryException ex) {
			JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.ERROR_MESSAGE);
		}


	}
}
