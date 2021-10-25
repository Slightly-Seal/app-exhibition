/* 
 * Author: Dakota Henderson
 * Date: 10/24/21
 * 
 * Builds and runs the Create Account page
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateAccount {

	// Variables
		static JFrame frame;
		static JPanel panel;
		
		// Text based variables
		static JTextField userEnter;
		static JTextField passEnter;
		static JLabel label;
		static JButton createButton;
		static File file;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// Initalizing variables
				frame = new JFrame("Create Account Screen");
				panel = new JPanel();
				userEnter = new JTextField(20);
				passEnter = new JTextField(15);
				label = new JLabel("");
				createButton = new JButton("Create New Account");
				
				// Basic setup and organizing
				frame.setSize(400, 200);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				createButton.setSize(100, 50);
		
		
		file = new File("Login.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			}
			catch (Exception IOException){
				label.setText("Unable to access data file");
			}
		}
		
		PrintWriter fout = new PrintWriter(file);
		
		// Button magic
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Checks if there is a string in the text fields
				if (!(userEnter.getText().length() > 0)) {
					label.setText("Insert user name for new account");
				}
				if (!(passEnter.getText().length() > 0)) {
					label.setText("Insert password for new account");
				}
				else {
					fout.print(userEnter.getText() + "/" + passEnter.getText());
					label.setText("Account Created!");
				}
			}
		});
		
		
		// Adding to panel, then frame 
		panel.add(userEnter);
		panel.add(passEnter);
		panel.add(createButton);
		panel.add(label);

		panel.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
		
		fout.close();
	}

}
