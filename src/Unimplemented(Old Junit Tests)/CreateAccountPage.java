import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreateAccountPage {

	// Instance variables.
	private static JPanel panel;
	private static JTextField userField;
	private static JPasswordField passField;
	private static JLabel statusLabel;
	private static JButton createButton;
		
	/**
	 * Constructor for CreateAccountPage. Initializes instance
	 * variables and adds userField, passField, statusLabel, and 
	 * createButton to the panel.
	 */
	CreateAccountPage() {
		// Initializing instance variables.
		panel = new JPanel();
		userField = new JTextField(20);
		passField = new JPasswordField(15);
		statusLabel = new JLabel("");
		createButton = new JButton("Create New Account");
		createButton.setSize(100, 50);
		// Adding elements to the JPanel.
		panel.add(userField);
		panel.add(passField);
		panel.add(createButton);
		panel.add(statusLabel);
	}
	
	/**
	 * Getter method for userField.
	 * @return userField.
	 */
	public JTextField getUserField() {
		return CreateAccountPage.userField;
	}
	
	/**
	 * Getter method for passField.
	 * @return passField.
	 */
	public JPasswordField getPassField() {
		return CreateAccountPage.passField;
	}
	
	/**
	 * Getter method for panel.
	 * @return panel.
	 */
	public JPanel getPanel() {
		return CreateAccountPage.panel;
	}
	
	/**
	 * Getter method for statusLabel.
	 * @return statusLabel.
	 */
	public JLabel getStatusLabel() {
		return CreateAccountPage.statusLabel;
	}
	
	/**
	 * Getter method for createButton.
	 * @return createButton.
	 */
	public JButton getCreateButton() {
		return CreateAccountPage.createButton;
	}

}
