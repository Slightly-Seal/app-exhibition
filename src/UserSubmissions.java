/**
* UserSubmssions class sets up the panel/frame that appears when having a user
* submit a potential application idea.
* Users must fill out a title and description for the application before
* it is able to be submitted. 
* Information is recorded in Submissions.txt file. 
* 
* @author James Martin
* 
*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;

/**
* Displays information that allows logged-in user to 
* submit an application for the catalog
*/
public class UserSubmissions implements ActionListener{

	//Frame + Panel
	JFrame frame;
	JPanel panel;
	
	// Text based variables
	JTextField submissionTitle;
	JTextArea submissionDescription;
	JLabel label;
	JButton createButton;
	File file;
	
	/**
	* This is the constructor for the user submission page.
	* This is responsible for setting upthe Frame, Panel, and formatting 
	* of the page. Also creates a "Submissions.txt" if there is not one 
	* available to read.
	*/
	UserSubmissions() {
		frame = new JFrame("Submit New App");
		panel = new JPanel();
		submissionTitle = new JTextField(30);
		submissionDescription = new JTextArea(10,30);
		submissionDescription.setLineWrap(true);
		submissionDescription.setWrapStyleWord(true);
		
		label = new JLabel("");
		JLabel label2 = new JLabel("Title:");
		JLabel label3 = new JLabel("    ");
		JLabel label4 = new JLabel("Description:");
		createButton = new JButton("Submit Application");
		createButton.addActionListener(this);
		createButton.setSize(100, 50);
		frame.setSize(400, 340);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		file = new File("Submissions.txt");
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
		panel.add(submissionTitle);
		panel.add(label3);
		panel.add(label4);
		panel.add(submissionDescription);
		panel.add(createButton);
		panel.add(label);
		panel.setVisible(true);
		frame.add(panel);
		frame.setVisible(false);
	}
	
	/**
	* Used to turn the frame visible/invisible
	* @param boolean, true sets it visible, false sets it invisible
	*/
	public void setActive(boolean value) {
		frame.setVisible(value);
	}

	/**
	* Override from ActionListener
	* @param Action event e that's used to verify which button is being pressed
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		// Checks if there is a string in the text fields
		if (!(submissionTitle.getText().length() > 0)) {
			label.setText("Insert Title for Submission");
		}
		if (!(submissionDescription.getText().length() > 0)) {
			label.setText("Insert Description for Submission");
		}
		else {
			PrintWriter fout = null;
			try {
				fout = new PrintWriter(new FileWriter(file, true));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			fout.printf("\n" +submissionTitle.getText() + "\\" + submissionDescription.getText());
			fout.close();
			label.setText("Application Submitted!");
			frame.setVisible(false);
		}
	}
}
