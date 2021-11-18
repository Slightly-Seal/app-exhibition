import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserSubmissionPage {
	
	// Instance variables.
	private static JPanel panel;
	private static JTextField submissionTitle;
	private static JTextField submissionDesc;
	private static JLabel statusLabel;
	private static JButton submitButton;
	
	/**
	 * Constructor for LoginPage. Initializes instance variables
	 * and adds userField, passField, statusLabel, and logButton
	 * to the panel.
	 */
	UserSubmissionPage() {
		// Initializing variables.
		submissionTitle = new JTextField(20);
		submissionDesc = new JTextField(200);
		statusLabel = new JLabel();
		submitButton = new JButton("Submit");
		panel = new JPanel();
		// Adding elements to JPanel.
		submissionTitle.setVisible(false);
		submissionDesc.setVisible(false);
		statusLabel.setVisible(false);
		submitButton.setVisible(false);
		panel.setVisible(false);
	}
	
	/**
	 * Getter method for submissionTitle.
	 * @return submissionTitle.
	 */
	public JTextField getUserField() {
		return UserSubmissionPage.submissionTitle;
	}
	
	/**
	 * Getter method for submissionDesc.
	 * @return submissionDesc.
	 */
	public JTextField getPassField() {
		return UserSubmissionPage.submissionDesc;
	}
	
	/**
	 * Getter method for panel.
	 * @return panel.
	 */
	public JPanel getPanel() {
		return UserSubmissionPage.panel;
	}
	
	/**
	 * Getter method for statusLabel.
	 * @return statusLabel.
	 */
	public JLabel getStatusLabel() {
		return UserSubmissionPage.statusLabel;
	}
	
	/**
	 * Getter method for logButton.
	 * @return logButton.
	 */
	public JButton getSubButton() {
		return UserSubmissionPage.submitButton;
	}
}
