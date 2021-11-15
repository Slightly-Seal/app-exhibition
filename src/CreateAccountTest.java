/*
 * Authors: Pengbo Qiu and Xingcheng Zhou
 * Date: 11/14/21
 * 
 * This class tests the CreateAccount class with frame, panel and PrintWriter.
 * 
 */
import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintWriter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateAccountTest {
	private CreateAccount account;
	
	@BeforeEach
	void setUp() throws Exception {
		account = new CreateAccount();
	}

	@Test
	void testFrame() {
		assertTrue(this.account.frame.isEnabled());
	}

	@Test
	void testCreatePanel() {
		assertTrue(this.account.panel.isEnabled());
		assertTrue(this.account.panel.isVisible());
	}

	@Test
	void testCreateButton() {
		assertTrue(this.account.createButton.isEnabled());
		assertTrue(this.account.createButton.isVisible());
	}
	
	@Test
	void testUserEnter() {
		assertTrue(this.account.userEnter.isVisible());
		assertTrue(this.account.userEnter.isEnabled());
		assertTrue(this.account.userEnter.getText().equals(""));
	}
	
	@Test
	void testPassEnter() {
		assertTrue(this.account.passEnter.isEnabled());
		assertTrue(this.account.passEnter.isVisible());
		assertTrue(this.account.passEnter.getText().equals(""));
	}
	

}
