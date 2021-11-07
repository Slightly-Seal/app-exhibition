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
import java.io.PrintWriter;

import javax.swing.*;

public class CreateAccount implements ActionListener{

	//Frame + Panel
	JFrame frame;
	JPanel panel;
	
	// Text based variables
	JTextField userEnter;
	JTextField passEnter;
	JLabel label;
	JButton createButton;
	File file;
	
	CreateAccount() {
		frame = new JFrame("Create Account Screen");
		panel = new JPanel();
		userEnter = new JTextField(20);
		passEnter = new JTextField(15);
		label = new JLabel("");
		JLabel label2 = new JLabel("Username:");
		JLabel label3 = new JLabel("      ");
		JLabel label4 = new JLabel("Password:");
		createButton = new JButton("Create New Account");
		createButton.addActionListener(this);
		createButton.setSize(100, 50);
		frame.setSize(400, 200);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		file = new File("Login.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			}
			catch (Exception IOException){
				label.setText("Unable to access data file");
			}
		}
		
		// Adding to panel, then frame 
		panel.add(label2);
		panel.add(userEnter);
		panel.add(label3);
		panel.add(label4);
		panel.add(passEnter);
		panel.add(createButton);
		panel.add(label);
		panel.setVisible(true);
		frame.add(panel);
		frame.setVisible(false);
	}
	
	public void setActive(boolean value) {
		frame.setVisible(value);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Checks if there is a string in the text fields
		if (!(userEnter.getText().length() > 0)) {
			label.setText("Insert user name for new account");
		}
		if (!(passEnter.getText().length() > 0)) {
			label.setText("Insert password for new account");
		}
		else {
			PrintWriter fout = null;
			try {
				fout = new PrintWriter(file);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			fout.print(userEnter.getText() + "\\" + passEnter.getText());
			fout.close();
			label.setText("Account Created!");
		}
	}
}
