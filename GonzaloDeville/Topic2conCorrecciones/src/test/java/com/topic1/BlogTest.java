package com.topic1;

import org.junit.Test;

import com.topic1.Blog;
import com.topic1.BlogEntry;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;

public class BlogTest {

	Blog blog = new Blog();
	BlogEntry newEntry = new BlogEntry("Test", "of", "method");

	@Test
	public void postTest() {
		blog.post(newEntry);
		assertFalse(blog.isEmpty());

		for (int i = 1; i < 12; i++) {
			BlogEntry entryTest = new BlogEntry("test"+i, "Cota", "pueba");
			blog.post(entryTest);
		}
		blog.post(newEntry);
		assertEquals(newEntry, blog.getFirst());
	}

	@Test
	public void deleteTest() {
		BlogEntry entryTest = new BlogEntry("test", "Cota", "pueba");
		
		blog.post(entryTest);
		assertFalse(blog.isEmpty());
		
		blog.delete(entryTest);
		assertTrue(blog.isEmpty());
		
	}
	
	@Test
	public void showRecentEntriesTest(){
		for (int i = 1; i < 16; i++) {
			BlogEntry entryTest = new BlogEntry("Test"+i, "of", "method");
			blog.post(entryTest);
		}
		
		assertEquals(10, blog.showRecentEntries().size());
		
	}
	
	@Test
	public void sizeOfBlogTest(){
		blog.post(newEntry);
		assertEquals(1, blog.sizeOfBlog());
	}
	
	@Test
	public void isEmptyTest(){
		blog.post(newEntry);
		assertFalse(blog.isEmpty());
		
		blog.delete(newEntry);
		assertTrue(blog.isEmpty());
	}
	
	@Test
	public void getFirstTest(){
		BlogEntry expected = new BlogEntry("Test", "of", "method");
		blog.post(expected);
		blog.post(newEntry);
		assertEquals(expected, blog.getFirst());
	}

}
