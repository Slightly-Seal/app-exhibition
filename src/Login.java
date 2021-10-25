/*
 * Author: Dakota Henderson
 * Date: 10/24/21
 * 
 * This class builds and works the login screen
 * 
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login {
	
	// Variables
	static JFrame frame;
	static JPanel panel;
	
	// Text based variables
	static JTextField userEnter;
	static JTextField passEnter;
	static JLabel label;
	static JButton logButton;
	static File file;
	
	
	public static void main(String[] args) {
		
		// Initalizing variables
		frame = new JFrame("Login Screen");
		panel = new JPanel();
		userEnter = new JTextField(20);
		passEnter = new JTextField(15);
		label = new JLabel("");
		logButton = new JButton("Login");
		
		// Basic setup and organizing
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logButton.setSize(100, 50);
		
		// Button magic
		logButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = userEnter.getText() + "/" + passEnter.getText();
				
				// Read information from login file
				file = new File("Logins.txt");
				try {
					Scanner fin = new Scanner(file);
					String userTry = input.substring(0, input.charAt(' '));
					String passTry = input.substring(input.charAt(' ') + 1);
					
					// Scan file for matching username, report unmade account if not found
					while (fin.hasNextLine()) {
						String saved = fin.nextLine();
						// If username matches login file
						if (saved.substring(saved.charAt(' ')).equals(userTry)) {
							// if pass matches login file line
							if (saved.substring(saved.charAt(' ') + 1).equals(passTry)) {
								label.setText("Logged in successfully! Welcome.");
							}
							else {
								passEnter.setText("");
								label.setText("Given password does not match what is on file");
							}
						}
					}
					fin.close();
				}
				catch (Exception FileNotFound) {
					label.setText("Login Information unattainable");
				}
				userEnter.setText("");
				passEnter.setText("");
				label.setText("No account with such username");
				
			}
		});
		
		// Adding to panel, then frame 
		panel.add(userEnter);
		panel.add(passEnter);
		panel.add(logButton);
		panel.add(label);
		
		panel.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
		
		
	} // end of main
	
}
