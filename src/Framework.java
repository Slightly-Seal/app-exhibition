import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import javax.swing.*;

public class Framework extends JFrame implements ActionListener {
	//Declaring stuff that needs to be globally accessible 
	Button loginButton = new Button();
	Button createAccButton = new Button("Create Account");
	Button adminButton = new Button("Review Submissions");
	Button userSubmitButton = new Button("Create Submission");
	JFrame mainFrame = new JFrame("Main Page");
	JPanel panel = new JPanel();
	JPanel userP = new JPanel();
	JPanel adminP = new JPanel();
	JPanel innerP = new JPanel();
	public CreateAccount createAccount;
	public LoginU login;
	public UserSubmissions userSubmissions;
	
	public boolean isAdmin = false;
	public boolean isLoggedOn = false;
	
	// Placeholder buttons for apps
	Button[] buttonArr = new Button[99];
	
	Framework() {	
		// List of variables/items in the gui
		LoginButton();
		JPanel accLoginPanel = new JPanel();
		JPanel bottomP = new JPanel();
		//Unused?
		//JMenuBar menubar = new JMenuBar();
		//JMenu menu = new JMenu("File");
		JTextField searchBar = new JTextField();
		JLabel searchLabel = new JLabel("Search: ");
				
		//Adding action listeners for Login/Create Account
		loginButton.addActionListener(this);
		createAccButton.addActionListener(this);
		adminButton.addActionListener(this);
		userSubmitButton.addActionListener(this);
		
		// General Setup for layout
		mainFrame.setBounds(100, 25, 400, 350);
		searchBar.setBounds(50,100, 200,30);
		panel.setLayout(new BorderLayout());
		accLoginPanel.setLayout(new GridLayout(1, 2, 5, 5));
		bottomP.setLayout(new GridLayout(1, 2, 5, 5));
		innerP.setBackground(Color.white);
		searchBar.add(searchLabel);
		accLoginPanel.add(searchBar);
		accLoginPanel.add(loginButton);
		accLoginPanel.add(createAccButton);
		userP.add(userSubmitButton);
		adminP.add(adminButton);
		bottomP.add(userP);
		bottomP.add(adminP);
		panel.add(innerP, "Center");
		panel.add(accLoginPanel, "North");
		panel.add(bottomP, "South");
		
		
		// Adding "Apps" to the panel
		submissionCheck();
		
		// Making visible, and final adds to the frame
		innerP.setVisible(true);
		adminP.setVisible(false);
		userP.setVisible(false);
		bottomP.setVisible(true);
		panel.setVisible(true);
		accLoginPanel.setVisible(true);
		mainFrame.add(panel);
		mainFrame.setVisible(true);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public void LoginButton() {
		if(isLoggedOn) {
			if(isAdmin) {
				loginButton.setLabel("Admin : Logout");
				adminP.setVisible(true);
			}
			else {
				loginButton.setLabel("Logout");
			}
			userP.setVisible(true);
		}
		else {
			loginButton.setLabel("Login");
			userP.setVisible(false);
			adminP.setVisible(false);
		}
	}
	
	private void LogOut() {
		isLoggedOn = false;
		LoginButton();
	}


	//Visibility methods for switching frames via buttons
	private void loginVisible() {
		createAccount.setActive(false);
		userSubmissions.setActive(false);
		login.setActive(true);
	}
	
	private void createAccVisible() {
		createAccount.setActive(true);
		userSubmissions.setActive(false);
		login.setActive(false);
	}
	
	private void userSubmissionsVisible() {
		createAccount.setActive(false);
		userSubmissions.setActive(true);
		login.setActive(false);
	}
	
	private void adminVisible() {
		createAccount.setActive(false);
		userSubmissions.setActive(false);
		login.setActive(false);
		Admin admin = new Admin();
		admin.frames = this;
		admin.setActive(true);
	}
	
	private void createCatalog(int index) {
		CatalogInfo newCatalog = new CatalogInfo(index);
		newCatalog.setActive(true);
		createAccount.setActive(false);
		login.setActive(false);
		userSubmissions.setActive(false);
	}
	
	public void submissionCheck() {
		innerP.removeAll();
		innerP.setVisible(false);
		innerP.setLayout(new GridLayout(5, 3, 10, 10));
		Scanner scanner = null;
		Button itemButton = null;
		
		try {
			scanner = new Scanner(new File("Catalog.txt"));
		} catch (FileNotFoundException e1) {
			System.out.print("Cannot Access User Submissions");
		}
		while (scanner.hasNextLine()) {
		   String line = scanner.nextLine();
		   int buttonIndex = Integer.parseInt((line.substring(4, line.indexOf(":"))));
		   //System.out.print("test" + buttonIndex);
		   itemButton = new Button();
		   String title = line.substring(line.indexOf(":") + 1, line.indexOf("\\"));
		   itemButton.setLabel(title);
		   itemButton.addActionListener(this);
		   innerP.add(itemButton); 
		   buttonArr[buttonIndex-1] = itemButton;
		}
		innerP.setVisible(true);
	}
	
	//Action listener
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == createAccButton)
			createAccVisible();
		if(e.getSource() == loginButton) {
			if(!isLoggedOn)
				loginVisible();
			else
				LogOut();
		}
		for(int i = 0; i < buttonArr.length; i++) {
			if(e.getSource() == buttonArr[i])
				createCatalog(i+1);
		}
		if(e.getSource() == userSubmitButton)
			userSubmissionsVisible();
		if(e.getSource() == adminButton)
			adminVisible();
	}

}
