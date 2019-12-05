package com.revature.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.Test;

public class CommentTest {
	Comment testComment = new Comment();
	
	@Test
	public void testExistance() {
		Comment comment = new Comment(0, Timestamp.valueOf(LocalDateTime.now()), "Something", "Other");
		assertNotNull(comment);
	}
	
	@Test
	public void testEmpty() {
		assertNotNull(testComment);
	}
	
	@Test
	public void testId() {
		testComment.setId(1);
		assertEquals(1, testComment.getId());
	}
	
	@Test
	public void testDate() {
		Timestamp theTimeIsNow=Timestamp.valueOf(LocalDateTime.now());
		testComment.setDate(theTimeIsNow);
		assertEquals(theTimeIsNow, testComment.getDate());
	}
	
	@Test
	public void testDescription() {
		testComment.setText("Something");
		assertEquals("Something", testComment.getText());
	}
	
	@Test
	public void testName() {
		testComment.setName("Other");
		assertEquals("Other", testComment.getName());
	}
	
	@Test
	public void testHashCode() {
		assertNotNull(testComment.hashCode());
	}
	
	@Test
	public void testToString() {
		assertNotNull(testComment.toString());
	}
}
