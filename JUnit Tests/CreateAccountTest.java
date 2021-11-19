import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * CreateAccountTest class is a JUnit tester class
 * for CreateAccount class.
 * 
 */
class CreateAccountTest {
	
	// Declaring CreateAccount object.
	private CreateAccount account;
	
	/**
	 * Before each test, a new CreateAccount object is
	 * constructed.
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		account = new CreateAccount();
	}

	/**
	 * Test to check JFrame of CreateAccount is enabled.
	 */
	@Test
	void testFrame() {
		assertTrue(account.getFrame().isEnabled());
	}

	/**
	 * Test to check JPanel of CreateAccount is enabled,
	 * and visible.
	 */
	@Test
	void testCreatePanel() {
		assertTrue(account.getPanel().isEnabled());
		assertTrue(account.getPanel().isVisible());
	}

	/**
	 * Test to check createButton of CreateAccount is
	 * visible, and enabled.
	 */
	@Test
	void testCreateButton() {
		assertTrue(account.getCreateButton().isEnabled());
		assertTrue(account.getCreateButton().isVisible());
	}
	
	/**
	 * Test to check userEnter of CreateAccount is visible,
	 * enabled, and clear on construction.
	 */
	@Test
	void testUserEnter() {
		assertTrue(account.getUserEnter().isVisible());
		assertTrue(account.getUserEnter().isEnabled());
		assertTrue(account.getUserEnter().getText().equals(""));
	}
	
	/**
	 * Test to check passEnter of CreateAccount is visible,
	 * enabled, and clear on construction.
	 */
	@Test
	void testPassEnter() {
		assertTrue(account.getPassEnter().isEnabled());
		assertTrue(account.getPassEnter().isVisible());
		assertTrue(account.getPassEnter().getText().equals(""));
	}
	
	/**
	 * Test to check when user is not enter, but pass is entered,
	 * create account function displays correct error status.
	 */
	@Test
	void testUserNotEntered() {
		account.getUserEnter().setText("");
		account.getPassEnter().setText("Pass");
		account.processAccountCreation();
		assertTrue(account.getLabel().getText().equals("Enter username."));
	}
	
	/**
	 * Test to check when user is entered, but pass is not entered,
	 * create account function displays correct error status.
	 */
	@Test
	void testPassNotEntered() {
		account.getUserEnter().setText("User");
		account.getPassEnter().setText("");
		account.processAccountCreation();
		assertTrue(account.getLabel().getText().equals("Enter password."));
	}

}
