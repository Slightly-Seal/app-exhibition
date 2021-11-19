import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginPageTest {

	private LoginPage logPage;
	
	@BeforeEach
	void setUp() throws Exception {
		logPage = new LoginPage();
	}

	@Test
	void testLoginUserField() {
		assertTrue(this.logPage.getUserField().isEnabled());
		assertTrue(this.logPage.getUserField().getText().equals(""));
	}
	
	@Test
	void testLoginPassField() {
		assertTrue(this.logPage.getPassField().isEnabled());
	}
	
	@Test
	void testLoginPanel() {
		assertTrue(this.logPage.getPanel().isEnabled());
		assertTrue(this.logPage.getPanel().isVisible());
	}
	
	@Test
	void testLoginStatusLabel() {
		assertTrue(this.logPage.getStatusLabel().isEnabled());
		assertTrue(this.logPage.getStatusLabel().getText().equals(""));
	}
	
	@Test
	void testLogButton() {
		assertTrue(this.logPage.getLogButton().isEnabled());
	}

}
