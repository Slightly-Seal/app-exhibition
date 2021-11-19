/*
 * Authors: Pengbo Qiu and Xingcheng Zhou
 * Date: 11/14/21
 * 
 * This class tests the Framework class with Login and Create Account.
 * 
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FrameworkTest {
	
	private Framework frame;
	
	@BeforeEach
	void setUp() throws Exception {
		frame = new Framework();
	}

	@Test
	void testLoginButton() {
		assertTrue(this.frame.loginButton.isEnabled());
		assertTrue(this.frame.loginButton.isVisible());
	}


	@Test
	void testCreateAccButton() {
		assertTrue(this.frame.createAccButton.isEnabled());
		assertTrue(this.frame.createAccButton.isVisible());
	}

	@Test
	void testUserSubmitButton() {
		assertTrue(this.frame.userSubmitButton.isEnabled());
		assertTrue(this.frame.userSubmitButton.isVisible());
	}
	
	@Test
	void testAdminButton() {
		assertTrue(this.frame.adminButton.isEnabled());
		assertTrue(this.frame.adminButton.isVisible());
	}
	
	@Test
	void testMainFrame() {
		assertTrue(this.frame.mainFrame.isEnabled());
	}
	
	@Test
	void testPanel() {
		assertTrue(this.frame.panel.isEnabled());
		assertTrue(this.frame.panel.isVisible());
	}

	@Test
	void testUserP() {
		assertTrue(this.frame.userP.isEnabled());
	}
	
	@Test
	void testInnerP() {
		assertTrue(this.frame.innerP.isEnabled());
	}
}
