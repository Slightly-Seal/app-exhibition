/*
 * Authors: Dakota Henderson and James Martin
 * Date: 10/24/21
 * 
 * This class builds and works the login screen
 * 
 */
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
		frame.setSize(400, 200);
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
	
	public void setActive(boolean value) {
		frame.setVisible(value);
	}
	
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
