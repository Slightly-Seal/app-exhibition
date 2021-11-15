
/**
* Framework is the skeleton for the application.
* This is the initial screen that the user sees when
* using the application. Can access almost all other classes.
* Scans "Catalog.txt" 
* @author Dakota Henderson
* @author James Martin
*/

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * Framework of the entire application Almost all other classes are accessed
 * through this Displays catalog information
 */
public class Framework extends JFrame implements ActionListener {
	// Declaring stuff that needs to be globally accessible
	Button loginButton = new Button();
	Button createAccButton = new Button("Create Account");
	Button adminButton = new Button("Review Submissions");
	Button userSubmitButton = new Button("Create Submission");
	Button alphaSort = new Button("Sort By Name");
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
	public boolean isSorted = false;
	
	// Placeholder buttons for apps
	Button[] buttonArr = new Button[99];
	String[] strArr = new String[99];
	
	/**
	 * This is the constructor for the Framework page, it's responsible for setting
	 * up the frame, panel, and all elements inside of them. Calls SubmissionCheck
	 * once as well to determine which applications it will show.
	 */
	Framework() {
		// List of variables/items in the gui
		LoginButton();
		JPanel accLoginPanel = new JPanel();
		JPanel bottomP = new JPanel();
		accLoginPanel.setBackground(new Color(102, 178, 255));
		bottomP.setBackground(new Color(102, 178, 255));
		adminP.setBackground(new Color(102, 178, 255));
		userP.setBackground(new Color(102, 178, 255));
		// Unused?
		// JMenuBar menubar = new JMenuBar();
		// JMenu menu = new JMenu("File");
		JLabel searchLabel = new JLabel("Search: ");

		// Adding action listeners for Login/Create Account
		loginButton.addActionListener(this);
		createAccButton.addActionListener(this);
		adminButton.addActionListener(this);
		userSubmitButton.addActionListener(this);
		alphaSort.addActionListener(this);

		// Adding Color to Buttons
		loginButton.setBackground(new Color(255, 255, 255));
		createAccButton.setBackground(new Color(255, 255, 255));
		adminButton.setBackground(new Color(255, 255, 255));
		userSubmitButton.setBackground(new Color(255, 255, 255));
		alphaSort.setBackground(new Color(255, 255, 255));
		
		// General Setup for layout
		mainFrame.setBounds(100, 25, 400, 350);
		panel.setLayout(new BorderLayout());
		accLoginPanel.setLayout(new GridLayout(1, 2, 5, 5));
		bottomP.setLayout(new GridLayout(1, 2, 5, 5));
		innerP.setBackground(Color.white);
		accLoginPanel.add(alphaSort);
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

	/**
	 * Is used to determine what the text of the login button will show. If not
	 * logged on, it will allow the user to log on. If the user is logged on, it
	 * will allow them to logoff. If the user is an Admin it will display a slightly
	 * different message when logging off.
	 */
	public void LoginButton() {
		if (isLoggedOn) {
			if (isAdmin) {
				loginButton.setLabel("Admin : Logout");
				adminP.setVisible(true);
			} else {
				loginButton.setLabel("Logout");
			}
			userP.setVisible(true);
		} else {
			loginButton.setLabel("Login");
			userP.setVisible(false);
			adminP.setVisible(false);
		}
	}

	/**
	 * Used to log off. Sets login button to allow user to login again.
	 */
	private void LogOut() {
		isLoggedOn = false;
		LoginButton();
	}

	/**
	 * Accesses LoginU's setActive methods, allowing the framework to close certain
	 * frames when opening new frames.
	 */
	// Visibility methods for switching frames via buttons
	private void loginVisible() {
		createAccount.setActive(false);
		userSubmissions.setActive(false);
		login.setActive(true);
	}

	/**
	 * Accesses CreateAccount's setActive methods, allowing the framework to close
	 * certain frames when opening new frames.
	 */
	private void createAccVisible() {
		createAccount.setActive(true);
		userSubmissions.setActive(false);
		login.setActive(false);
	}

	/**
	 * Accesses UserSubmissions' setActive methods, allowing the framework to close
	 * certain frames when opening new frames.
	 */
	private void userSubmissionsVisible() {
		createAccount.setActive(false);
		userSubmissions.setActive(true);
		login.setActive(false);
	}

	/**
	 * Accesses Admin's setActive methods, allowing the framework to close certain
	 * frames when opening new frames.
	 */
	private void adminVisible() {
		createAccount.setActive(false);
		userSubmissions.setActive(false);
		login.setActive(false);
		Admin admin = new Admin();
		admin.frames = this;
		admin.setActive(true);
	}

	/**
	 * Used to open up CatalogInfo for a specific catalog listed in the application.
	 * 
	 * @param integer
	 *            value used to verify the index of the selected application
	 */
	private void createCatalog(int index) {
		CatalogInfo newCatalog = new CatalogInfo(index);
		newCatalog.setActive(true);
		createAccount.setActive(false);
		login.setActive(false);
		userSubmissions.setActive(false);
	}

	/**
	 * Scans part of Catalog.txt to display catalogged applications. Removes all
	 * elements from the panel before adding all catalogged applications back,
	 * allowing this to be called to refresh visible applications.
	 */
	public void submissionCheck() {
		innerP.removeAll();
		innerP.setVisible(false);
		innerP.setLayout(new GridLayout(5, 3, 10, 10));
		Scanner scanner = null;
		Button itemButton = null;
		innerP.setBackground(new Color(102, 178, 255));
		try {
			scanner = new Scanner(new File("Catalog.txt"));
		} catch (FileNotFoundException e1) {
			System.out.print("Cannot Access User Submissions");
		}
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			int buttonIndex = Integer.parseInt((line.substring(4, line.indexOf(":"))));
			// System.out.print("test" + buttonIndex);
			itemButton = new Button();
			String title = line.substring(line.indexOf(":") + 1, line.indexOf("\\"));
			itemButton.setLabel(title);
			itemButton.addActionListener(this);
			itemButton.setBackground(new Color(255, 255, 255));
			innerP.add(itemButton);
			strArr[buttonIndex - 1] = title;
			buttonArr[buttonIndex - 1] = itemButton;
		}
		innerP.setVisible(true);
	}
	
	/**
	 * This is used to sort our buttons alphabetically by 
	 * sorting an array of our app's titles and then scanning 
	 * through "Catalog.txt" to re-add the buttons.
	 * @param String[], list of app titles
	 */
	public void alphabeticalSort(String[] str) {
		int i = 0;
		String key;
		for (int j = 1; j < str.length && str[j] != null; j++) {
			key = str[j];
			i = j - 1;
			while (i >= 0) {
				if (key.compareTo(str[i]) > 0) {
					break;
				}
				str[i + 1] = str[i];
				i--;
			}
			str[i + 1] = key;
		}
		innerP.removeAll();
		innerP.setVisible(false);
		innerP.setLayout(new GridLayout(5, 3, 10, 10));
		innerP.setBackground(new Color(102, 178, 255));
		
		Scanner scanner = null;
		Button itemButton = null;
		try {
			scanner = new Scanner(new File("Catalog.txt"));
		} catch (FileNotFoundException e1) {
			System.out.print("Cannot Access User Submissions");
		}
		int buttonIndex = 0;
		for(int k = 0; k < str.length && str[k] != null; k++) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				buttonIndex = Integer.parseInt((line.substring(4, line.indexOf(":"))));
				String title = line.substring(line.indexOf(":") + 1, line.indexOf("\\"));
				if(title.equals(str[k])) {
					break;
				}
			}
			itemButton = new Button();
			itemButton.setLabel(str[k]);
			itemButton.addActionListener(this);
			itemButton.setBackground(new Color(255, 255, 255));
			innerP.add(itemButton);
			buttonArr[buttonIndex-1] = itemButton;
		}
		innerP.setVisible(true);
		
	}

	/**
	 * Override from ActionListener
	 * 
	 * @param Action event e that's used to verify which button is being pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == createAccButton)
			createAccVisible();
		if (e.getSource() == loginButton) {
			if (!isLoggedOn)
				loginVisible();
			else
				LogOut();
		}
		for (int i = 0; i < buttonArr.length; i++) {
			if (e.getSource() == buttonArr[i])
				createCatalog(i + 1);
		}
		if (e.getSource() == userSubmitButton)
			userSubmissionsVisible();
		if (e.getSource() == adminButton)
			adminVisible();
		if (e.getSource() == alphaSort) {
			if(!isSorted) {
				alphabeticalSort(strArr);
				alphaSort.setLabel("Original View");
				isSorted = true;
			}
			else {
				submissionCheck();
				alphaSort.setLabel("Sort By Name");
				isSorted = false;
			}
				
		}
			
	}

}
