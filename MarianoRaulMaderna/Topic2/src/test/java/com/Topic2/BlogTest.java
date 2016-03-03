package com.Topic2;

import static org.junit.Assert.*;

import java.util.*;
import java.util.Iterator;

import org.junit.Test;

public class BlogTest {
	
	/**
	 * A new blog is created
	 * And a new entry is created
	 * Add the new entry into the blog
	 * Checks if the blog contains the entry
	 */
	@Test
	public void newPostEntryOnTheBlog(){
		Blog blog = new Blog();
		BlogEntry entry= new BlogEntry("Autor", "Titulo del Blog");
		blog.add(entry);
		assertEquals(true,blog.containsEntry(entry));
	}
	
	/**
	 * A new blog is created
	 * And a new entry is created
	 * Add the new entry into the blog
	 * Checks if the blog contains the entry
	 * Remove the entry
	 * Checks if the blog do not contains the entry.
	 */
	@Test
	public void deletExistingEntry(){
		Blog blog = new Blog();
		BlogEntry entry= new BlogEntry("Autor", "Titulo del Blog");
		blog.add(entry);
		assertEquals(true,blog.containsEntry(entry));
		blog.remove(entry);
		assertEquals(false,blog.containsEntry(entry));
	}
	
	/**
	 * A new blog is created
	 * 
	 *  New entries are created
	 *  And they are added into the blog
	 *  
	 * A new list of the lastTen is created
	 * Checks if the size of lastTen is 10
	 * 
	 * Iterates lastTen
	 * 
	 * Show the most recent entries
	 */
	@Test
	public void showTenMostRecentEntries(){
		Blog blog = new Blog();
		for(int ent=0; ent<15 ; ent++){
			BlogEntry entry= new BlogEntry("Autor " +ent, "Titulo del Blog "+ent);
			blog.add(entry);
		}
		
		ArrayDeque<BlogEntry> lastTen = blog.getLastTen();
		assertTrue(lastTen.size()<=10);
		
		Iterator<BlogEntry> iterator = lastTen.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}
		
	}
}
