/*
 * Authors: Pengbo Qiu and Xingcheng Zhou
 * Date: 11/14/21
 * 
 * This class tests the LoginU class with frame, panel and scanner.
 * 
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class LoginUTest {
	
	private LoginU login1;
	
	@BeforeEach
	void setUp() throws Exception {
		login1 = new LoginU();
	}

	@Test
	void testFrame() {
		assertTrue(this.login1.frame.isEnabled());
	}
	
	@Test
	void testCreatePanel() {
		assertTrue(this.login1.panel.isEnabled());
		assertTrue(this.login1.panel.isVisible());
	}
	
	@Test
	void testLogBotton() {
		assertTrue(this.login1.logButton.isVisible());
		assertTrue(this.login1.logButton.isEnabled());
	}
	
	@Test
	void testUserEnter() {
		assertTrue(this.login1.userEnter.isVisible());
		assertTrue(this.login1.userEnter.isEnabled());
		assertTrue(this.login1.userEnter.getText().equals(""));
	}
	
	@Test
	void testPassEnter() {
		assertTrue(this.login1.passEnter.isEnabled());
		assertTrue(this.login1.passEnter.isVisible());
		assertTrue(this.login1.passEnter.getText().equals(""));
	}

}
