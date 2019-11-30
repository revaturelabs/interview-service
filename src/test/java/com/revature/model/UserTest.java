package com.revature.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class UserTest {
	User user = new User();
	
	@Test
	public void testId() {
		user.setId(1);
		assertEquals(1, user.getId());
	}
	
	@Test
	public void testUsername() {
		user.setUsername("username");
		assertEquals("username", user.getUsername());
	}
	
	@Test
	public void testPassword() {
		user.setPassword("password");
		assertEquals("password", user.getPassword());
	}
	
	@Test
	public void testHashcode() {
		assertNotNull(user.hashCode());
	}
	
	@Test
	public void testToString() {
		assertNotNull(user.toString());
	}
}
