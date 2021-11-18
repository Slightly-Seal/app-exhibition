/**
* LoginU is used to display information required for the user to log in.
* It scans from "Login.txt"
* @author Dakota Henderson
* @author James Martin
*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
* Displays information related to logging into an existing account
*/
public class LoginU implements ActionListener{
	
	//Frame + Panel
	JFrame frame;
	JPanel panel;
	
	//Variables
	JTextField userEnter;
	JTextField passEnter;
	JLabel label;
	JButton logButton;
	File file;
	
	public Framework frames;
	
	/**
	 * Constructor for LoginU. Sets up all visual elements
	 * of the page, as well as two text fields for inputting the 
	 * user's login-information.
	 */
	LoginU(){
		frame = new JFrame("Login Screen");
		panel = new JPanel();
		userEnter = new JTextField(20);
		passEnter = new JTextField(15);
		label = new JLabel("");
		JLabel label2 = new JLabel("Username:");
		JLabel label3 = new JLabel("       ");
		JLabel label4 = new JLabel("Password:");
		logButton = new JButton("Login");
		logButton.setSize(100, 50);
		logButton.addActionListener(this);
		logButton.setBackground(new Color(255, 255, 255));
		frame.setSize(400, 200);
		panel.setBackground(new Color(102, 178, 255));
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Adding to panel, then frame 
		panel.add(label2);
		panel.add(userEnter);
		panel.add(label3);
		panel.add(label4);
		panel.add(passEnter);
		panel.add(logButton);
		panel.add(label);
		
		panel.setVisible(true);
		frame.add(panel);
		frame.setVisible(false);
	}
	
	/**
	* Used to turn the frame visible/invisible.
	* @param boolean, true sets it visible, false sets it invisible.
	*/
	public void setActive(boolean value) {
		frame.setVisible(value);
	}
	
	/**
	* Override from ActionListener.
	* Scans "Login.txt" to verify that the information the user inputted is 
	* from an existing account.
	* @param Action event e that's used to verify which button is being pressed.
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		String input = userEnter.getText() + "\\" + passEnter.getText();
		//System.out.println(input);
		
		Scanner scanner = null;
		
		String userTry = input.substring(0, input.indexOf("\\"));
		String passTry = input.substring(input.indexOf("\\") + 1);

		
		try {
			scanner = new Scanner(new File("Login.txt"));
		} catch (FileNotFoundException e1) {
			System.out.print("Cannot Access Username/Passwords");
		}
		while (scanner.hasNextLine()) {
		   String line = scanner.nextLine();
		   //System.out.println(line.substring(0, line.indexOf("\\")).equals(userTry));
		   //System.out.println(line.substring(line.indexOf("\\") + 1).equals(passTry));
		   
		   if (line.substring(0, line.indexOf("\\")).equals(userTry)) {
				// if pass matches login file line
				if (line.substring(line.indexOf("\\") + 1, line.indexOf("\"")).equals(passTry)) {
					label.setText("Logged in successfully! Welcome.");
					if(line.substring(line.indexOf("\"") +1).equals("True")) {
						frames.isAdmin = true;
					}
					else {
						frames.isAdmin = false;
					}
					frames.isLoggedOn = true;
					frames.LoginButton();
					frame.setVisible(false);
				}
				else {
					passEnter.setText("");
					label.setText("Given password does not match what is on file");
				}
			}
		   else {
				userEnter.setText("");
				passEnter.setText("");
				label.setText("No account with such username");
		   }
		}
		
		
	}
}
