import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class Framework extends JFrame implements ActionListener {
	//Declaring stuff that needs to be globally accessible 
	Button loginButton = new Button("Login");
	Button createAccButton = new Button("Create Account");
	JFrame mainFrame = new JFrame();
	JPanel panel = new JPanel();
	CreateAccount createAccount = new CreateAccount();
	Login login = new Login();
	
	// Placeholder buttons for apps
	Button b1 = new Button("App 1");
	Button b2 = new Button("App 2");
	Button b3 = new Button("App 3");
	Button b4 = new Button("App 4");
	Button b5 = new Button("App 5");
	Button b6 = new Button("App 6");
	Button b7 = new Button("App 7");
	
	Framework() {	
		// List of variables/items in the gui
		
		JPanel accLoginPanel = new JPanel();
		JPanel innerP = new JPanel();
		//Unused?
		//JMenuBar menubar = new JMenuBar();
		//JMenu menu = new JMenu("File");
		JTextField searchBar = new JTextField();
		JLabel searchLabel = new JLabel("Search: ");
				
		//Adding action listeners for Login/Create Account
		loginButton.addActionListener(this);
		createAccButton.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		
		// General Setup for layout
		mainFrame.setBounds(100, 25, 400, 350);
		searchBar.setBounds(50,100, 200,30);
		innerP.setLayout(new GridLayout(5, 3, 10, 10));
		panel.setLayout(new BorderLayout());
		accLoginPanel.setLayout(new GridLayout(1, 2, 5, 5));
		innerP.setBackground(Color.white);
		searchBar.add(searchLabel);
		accLoginPanel.add(searchBar);
		accLoginPanel.add(loginButton);
		accLoginPanel.add(createAccButton);
		panel.add(innerP, "Center");
		panel.add(accLoginPanel, "North");
		
		
		// Adding "Apps" to the panel
		innerP.add(b1);
		innerP.add(b2);
		innerP.add(b3);
		innerP.add(b4);
		innerP.add(b5);
		innerP.add(b6);
		innerP.add(b7);
		
		// Making visible, and final adds to the frame
		innerP.setVisible(true);
		panel.setVisible(true);
		accLoginPanel.setVisible(true);
		mainFrame.add(panel);
		mainFrame.setVisible(true);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	//Visibility methods for switching frames via buttons
	private void mainFrameVisible() {
		createAccount.setActive(false);
		login.setActive(false);
	}
	
	private void loginVisible() {
		createAccount.setActive(false);
		login.setActive(true);
	}
	
	private void createAccVisible() {
		createAccount.setActive(true);
		login.setActive(false);
	}
	
	private void createCatalog(int index) {
		CatalogInfo newCatalog = new CatalogInfo(index);
		newCatalog.setActive(true);
		createAccount.setActive(false);
		login.setActive(false);
	}
	
	
	//Action listener
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == createAccButton)
			createAccVisible();
		if(e.getSource() == loginButton)
			loginVisible();
		if(e.getSource() == b1)
			createCatalog(1);
		if(e.getSource() == b2)
			createCatalog(2);
		if(e.getSource() == b3)
			createCatalog(3);
		if(e.getSource() == b4)
			createCatalog(4);
		if(e.getSource() == b5)
			createCatalog(5);
		if(e.getSource() == b6)
			createCatalog(6);
		if(e.getSource() == b7)
			createCatalog(7);
	}

}
