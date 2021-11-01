import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage {
	
	// Instance variables.
	private static JPanel panel;
	private static JTextField userField;
	private static JPasswordField passField;
	private static JLabel statusLabel;
	private static JButton logButton;
	
	/**
	 * Constructor for LoginPage. Initializes instance variables
	 * and adds userField, passField, statusLabel, and logButton
	 * to the panel.
	 */
	LoginPage() {
		// Initializing variables.
		userField = new JTextField(20);
		passField = new JPasswordField(15);
		statusLabel = new JLabel();
		logButton = new JButton("Login");
		panel = new JPanel();
		// Adding elements to JPanel.
		panel.add(userField);
		panel.add(passField);
		panel.add(statusLabel);
		panel.add(logButton);
	}
	
	/**
	 * Getter method for userField.
	 * @return userField.
	 */
	public JTextField getUserField() {
		return LoginPage.userField;
	}
	
	/**
	 * Getter method for passField.
	 * @return passField.
	 */
	public JPasswordField getPassField() {
		return LoginPage.passField;
	}
	
	/**
	 * Getter method for panel.
	 * @return panel.
	 */
	public JPanel getPanel() {
		return LoginPage.panel;
	}
	
	/**
	 * Getter method for statusLabel.
	 * @return statusLabel.
	 */
	public JLabel getStatusLabel() {
		return LoginPage.statusLabel;
	}
	
	/**
	 * Getter method for logButton.
	 * @return logButton.
	 */
	public JButton getLogButton() {
		return LoginPage.logButton;
	}
}
