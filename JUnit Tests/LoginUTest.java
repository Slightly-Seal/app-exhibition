import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * LoginUTest class is a JUnit tester class for
 * LoginU class.
 */
class LoginUTest {
	
	// Declaring LoginU object.
	private LoginU login;
	
	/**
	 * Before each test, a new LoginU object is 
	 * constructed.
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		login = new LoginU();
	}

	/**
	 * Test to check JFrame of LoginU is enabled.
	 */
	@Test
	void testFrame() {
		assertTrue(login.getFrame().isEnabled());
	}
	
	/**
	 * Test to check JPanel of LoginU is enabled, and visible.
	 */
	@Test
	void testCreatePanel() {
		assertTrue(login.getPanel().isEnabled());
		assertTrue(login.getPanel().isVisible());
	}
	
	/**
	 * Test to check logButton of LoginU is visible, and enabled.
	 */
	@Test
	void testLogBotton() {
		assertTrue(login.getLogButton().isVisible());
		assertTrue(login.getLogButton().isEnabled());
	}
	
	/**
	 * Test to check userEnter of LoginU is visible, enabled, and cleared
	 * on construction.
	 */
	@Test
	void testUserEnter() {
		assertTrue(login.getUserEnter().isVisible());
		assertTrue(login.getUserEnter().isEnabled());
		assertTrue(login.getUserEnter().getText().equals(""));
	}
	
	/**
	 * Test to check passEnter of LoginU is visible, enabled, and cleared
	 * on construction.
	 */
	@Test
	void testPassEnter() {
		assertTrue(LoginU.passEnter.isEnabled());
		assertTrue(LoginU.passEnter.isVisible());
		assertTrue(LoginU.passEnter.getText().equals(""));
	}
	
	/**
	 * Test to check login function works properly with an
	 * incorrect user but correct password entered.
	 */
	@Test
	void testLoginFailUsername() {
		login.getUserEnter().setText("Username");
		login.getPassEnter().setText("Password");
		login.processLogin();
		assertTrue(login.getLabel().getText().equals("Username not found."));
	}
	
	/**
	 * Test to check login function works properly with a correct
	 * user but incorrect password entered.
	 */
	@Test
	void testLoginFailPassword() {
		login.getUserEnter().setText("User");
		login.getPassEnter().setText("Pass");
		login.processLogin();
		assertTrue(login.getLabel().getText().equals("Password not found."));
	}
	
	/**
	 * Test to check login function works properly with a correct user,
	 * and correct passwored entered.
	 */
	@Test
	void testLoginFailUsernamePassword() {
		login.getUserEnter().setText("Username");
		login.getPassEnter().setText("Pass");
		login.processLogin();
		assertTrue(login.getLabel().getText().equals("Username not found."));
	}
	
}
