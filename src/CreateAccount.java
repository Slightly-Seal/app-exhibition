/**
* CreateAccount is used to display an interface that allows the user
* to create an account on the application.
* It prints to "Login.txt"
* @author Dakota Henderson
* @author James Martin
*/
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

/**
* Displays information related to creating an account
*/
public class CreateAccount implements ActionListener{

	// Instance variables.
	public static JFrame frame;
	public static JPanel panel;
	public static JTextField userEnter;
	public static JTextField passEnter;
	public static JLabel label;
	public static JButton createButton;
	public static File file;
	
	/**
	 * Constructor for CreateAccount, sets up all visual elements required for
	 * for the user to create an account.
	 * If there is no "Login.txt" file, it creates one. 
	 */
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
		panel.setBackground(new Color(102, 178, 255));
		createButton.setBackground(new Color(255, 255, 255));
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
	
	/**
	* Used to turn the frame visible/invisible.
	* @param boolean, true sets it visible, false sets it invisible.
	*/
	public void setActive(boolean value) {
		frame.setVisible(value);
	}

	/**
	* Override from ActionListener.
	* Check to see if there's text in the user and password fields.
	* If there is, then it prints the information to "Login.txt".
	* Feedback is given to user via labels. 
	* @param Action event e that's used to verify which button is being pressed.
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		processAccountCreation();
	}
	
	public void processAccountCreation() {
		// Checks if there is a string in the text fields
		if (!(userEnter.getText().length() > 0)) {
			label.setText("Enter username.");
			userEnter.setText("");
			passEnter.setText("");
			return;
		}
		if (!(passEnter.getText().length() > 0)) {
			label.setText("Enter password.");
			userEnter.setText("");
			passEnter.setText("");
			return;
		} else {
			PrintWriter fout = null;
			try {
				fout = new PrintWriter(new FileWriter(file, true));
			} catch (IOException e1) {
					e1.printStackTrace();
			}
			fout.printf("\n" +userEnter.getText() + "\\" + passEnter.getText() + "\"False");
			fout.close();
			label.setText("Account Created!");
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		CreateAccount.frame = frame;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		CreateAccount.panel = panel;
	}

	public JTextField getUserEnter() {
		return userEnter;
	}

	public void setUserEnter(JTextField userEnter) {
		CreateAccount.userEnter = userEnter;
	}

	public JTextField getPassEnter() {
		return passEnter;
	}

	public void setPassEnter(JTextField passEnter) {
		CreateAccount.passEnter = passEnter;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		CreateAccount.label = label;
	}

	public JButton getCreateButton() {
		return createButton;
	}

	public void setCreateButton(JButton createButton) {
		CreateAccount.createButton = createButton;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		CreateAccount.file = file;
	}
}
