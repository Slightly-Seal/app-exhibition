import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateAccountPageTest {
	
	private CreateAccountPage accPage;

	@BeforeEach
	void setUp() throws Exception {
		accPage = new CreateAccountPage();
	}

	@Test
	void testCreateAccountUserField() {
		assertTrue(this.accPage.getUserField().isEnabled());
		assertTrue(this.accPage.getUserField().getText().equals(""));
	}
	
	@Test
	void testCreateAccountPassField() {
		assertTrue(this.accPage.getPassField().isEnabled());
	}
	
	@Test
	void testCreatePanel() {
		assertTrue(this.accPage.getPanel().isEnabled());
		assertTrue(this.accPage.getPanel().isVisible());
	}
	
	@Test
	void testCreateAccountStatusLabel() {
		assertTrue(this.accPage.getStatusLabel().isEnabled());
		assertTrue(this.accPage.getStatusLabel().getText().equals(""));
	}
	
	@Test
	void testCreateAccountCreateButton() {
		assertTrue(this.accPage.getCreateButton().isEnabled());
	}

}
