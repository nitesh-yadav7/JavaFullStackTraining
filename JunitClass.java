package junitdemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JunitClass {
	@Test
	public void setup() {
		String str = "Hello";
		assertEquals("Hello", str);
	}
	
	Operations op = new Operations();
	
	@Test
	public void testMultiply() {
		assertEquals(20, op.mul(5, 4));
	}
	
	@Test
	public void testDivision() {
		assertEquals(20, op.div(200, 10));
	}
	
	@Test
	public void testAddition() {
		assertEquals(20, op.add(5, 15));
	}
	
	@Test
	public void testSubtract() {
		assertEquals(20, op.sub(24, 4));
	}
	
	@Test
	public void testName() {
		String s1 = "n_ame";
		String s2 = "name";
		assertTrue(s1.contains("_"));
	}
	
	@Test
	public void testEmail() {
		String s1 = "ntesh@gmail.com";
		assertTrue(s1.contains("@"));
	}
	
	@Test
	public void testMobile() {
		Long mob= 9137218151L;
		
		if (mob <= 9999999999L && mob >= 1111111111L) {
			assertTrue(true);
		} else {
			assertTrue(false);	
		}
	}
	
	@Test
	public void testPasswd() {
		String passwd = "mypasswd";
		String cfmpasswd = "mypasswd";
		assertTrue(passwd.equals(cfmpasswd));
	}
	
	@Test
	public void testArrayMax() {
		assertEquals(-2, op.arrayMax(new int[] {-2, -10, -6, -4}));
	}
	
}
