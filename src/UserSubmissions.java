/* 
 * Authors: Dakota Henderson and James Martin
 * Date: 10/24/21
 * 
 * Builds and runs the Create Account page
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;

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
	
	public void setActive(boolean value) {
		frame.setVisible(value);
	}

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
