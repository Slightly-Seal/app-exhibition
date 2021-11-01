import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserSubmissionPageTest {

	private UserSubmissionPage userSubmissionPage;
	
	@BeforeEach
	void setUp() throws Exception {
		userSubmissionPage = new UserSubmissionPage();
	}

	@Test
	void testLoginUserField() {
		assertTrue(this.userSubmissionPage.getUserField().isEnabled());
		assertTrue(this.userSubmissionPage.getUserField().getText().equals(""));
	}
	
	@Test
	void testLoginPassField() {
		assertTrue(this.userSubmissionPage.getPassField().isEnabled());
	}
	
	@Test
	void testLoginPanel() {
		assertTrue(this.userSubmissionPage.getPanel().isEnabled());
		assertTrue(this.userSubmissionPage.getPanel().isVisible());
	}
	
	@Test
	void testLoginStatusLabel() {
		assertTrue(this.userSubmissionPage.getStatusLabel().isEnabled());
		assertTrue(this.userSubmissionPage.getStatusLabel().getText().equals(""));
	}
	
	@Test
	void testLogButton() {
		assertTrue(this.userSubmissionPage.getSubButton().isEnabled());
		assertTrue(this.userSubmissionPage.getSubButton().getText().equals("Submit"));
	}

}
