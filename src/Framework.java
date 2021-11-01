import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class Framework extends JFrame implements ActionListener {
	//Declaring stuff that needs to be globally accessible 
	Button loginButton = new Button("Login");
	Button createAccButton = new Button("Create Account");
	Button backButton = new Button("Back");
	Button backButton2 = new Button("Back");
	JFrame mainFrame = new JFrame();
	JFrame createAccFrame = new JFrame();
	JFrame loginFrame = new JFrame();
	
	public void mainMenu() {	
		// List of variables/items in the gui
		JPanel panel = new JPanel();
		JPanel accLoginPanel = new JPanel();
		JPanel innerP = new JPanel();
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JTextField searchBar = new JTextField();
		JLabel searchLabel = new JLabel("Search: ");
		
		// Placeholder buttons for apps
		Button b1 = new Button("App 1");
		Button b2 = new Button("App 2");
		Button b3 = new Button("App 3");
		Button b4 = new Button("App 4");
		
		//Adding action listeners for Login/Create Account
		loginButton.addActionListener(this);
		createAccButton.addActionListener(this);
		
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
		innerP.add(new Button("App 5"));
		innerP.add(new Button("App 6"));
		innerP.add(new Button("App 7"));
		
		// Making visible, and final adds to the frame
		innerP.setVisible(true);
		panel.setVisible(true);
		accLoginPanel.setVisible(true);
		mainFrame.add(panel);
		mainFrame.setVisible(true);
		
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Creating the Create Acc Page
	public void createAccMenu() {
		//Create elements that appear in panels
		JPanel createAccPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		
		JLabel emailLabel = new JLabel("Email: ");
		JLabel usernameLabel = new JLabel("Username: ");
		JLabel passwordLabel = new JLabel("Passsword: ");
		
		JTextField email = new JTextField();
		JTextField username = new JTextField();
		JTextField password = new JTextField();
		
		backButton.addActionListener(this);
		
		//Setting up the panels
		createAccFrame.setBounds(100, 25, 400, 350);
		createAccPanel.setLayout(new BorderLayout());
		centerPanel.setLayout(new GridLayout(3, 2, 5, 5));
		centerPanel.add(emailLabel);
		centerPanel.add(email);
		centerPanel.add(usernameLabel);
		centerPanel.add(username);
		centerPanel.add(passwordLabel);
		centerPanel.add(password);
		createAccPanel.add(centerPanel, "Center");
		createAccPanel.add(backButton, "South");
		
		// Making visible, and final adds to the frame. Starts with visibility false
		createAccPanel.setVisible(true);
		centerPanel.setVisible(true);
		createAccFrame.add(createAccPanel);
		createAccFrame.setVisible(false);
		
		createAccFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createLogin() {
	
		loginFrame.setTitle("Login");
		loginFrame.setBounds(100, 25, 400, 350);
		loginFrame.setDefaultCloseOperation(3);
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setResizable(false);
		loginFrame.setFont(new Font("TimesRoman", Font.PLAIN, 14));
		
		backButton2.addActionListener(this);
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER,8,10);
		loginFrame.setLayout(fl);
		
		JLabel labname = new JLabel("Account: ");
		labname.setFont(new Font("TimesRoman", Font.PLAIN, 14));
		loginFrame.add(labname);
		
		JTextField text_name = new JTextField();
		Dimension dim1 = new Dimension(250,30);
		text_name.setPreferredSize(dim1);
		loginFrame.add(text_name);
		
		JLabel pwd = new JLabel("Password:");
		pwd.setFont(new Font("TimesRoman", Font.PLAIN, 14));
		loginFrame.add(pwd);
		
		JPasswordField text_password = new JPasswordField();
		text_password.setPreferredSize(dim1);
		loginFrame.add(text_password);
		
		JButton button1 = new JButton();
		Dimension dim2 = new Dimension(100,30);
		button1.setText("Sign in");
		button1.setFont(new Font("TimesRoman", Font.PLAIN, 14));
		button1.setSize(dim2);
		loginFrame.add(button1);
		JPanel back = new JPanel();
		back.setLayout(new BorderLayout());
		back.add(backButton2, "South");
		loginFrame.add(back);
		
		loginFrame.setVisible(false);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Visibility methods for switching frames via buttons
	private void mainFrameVisible() {
		mainFrame.setVisible(true);
		createAccFrame.setVisible(false);
		loginFrame.setVisible(false);
	}
	
	private void loginVisible() {
		createAccFrame.setVisible(false);
		mainFrame.setVisible(false);
		loginFrame.setVisible(true);
	}
	
	private void createAccVisible() {
		createAccFrame.setVisible(true);
		mainFrame.setVisible(false);
		loginFrame.setVisible(false);
	}
	
	
	//Action listener
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == createAccButton)
			createAccVisible();
		if(e.getSource() == loginButton)
			loginVisible();
		if(e.getSource() == backButton)
			mainFrameVisible();
		if(e.getSource() == backButton2)
			mainFrameVisible();
	}

}
