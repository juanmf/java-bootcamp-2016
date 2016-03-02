package com.topic1;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * @author cota
 *
 */
public class Blog {

	ArrayDeque<BlogEntry> blog;

	public Blog() {
		blog = new ArrayDeque<>();
	}

	/**
	 * Method that allow post a new entry
	 * 
	 * @param newEntry
	 */
	public void post(BlogEntry newEntry) {
		if (blog.contains(newEntry)) {
			blog.remove(newEntry);
		}
		blog.addFirst(newEntry);
	}

	/**
	 * Method that allow delete an existing entry
	 * 
	 * @param newEntry
	 */
	public void delete(BlogEntry newEntry) {
		if (blog.contains(newEntry)) {
			blog.remove(newEntry);
		}
	}

	/**
	 * Method that returns a list of the ten most recent elements
	 * 
	 * @return
	 */
	public ArrayDeque<BlogEntry> showRecentEntries() {
		ArrayDeque<BlogEntry> mostRecent = new ArrayDeque<>();
		Iterator<BlogEntry> iterator = blog.iterator();

		for (int i = 0; i < 10 && iterator.hasNext(); i++) {
			mostRecent.addLast(iterator.next());
		}

		return mostRecent;
	}

	/**
	 * @return int of the size of the blog
	 */
	public int sizeOfBlog() {
		return blog.size();
	}

	/**
	 * @return true if the list is empty
	 */
	public boolean isEmpty() {
		if (blog.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public BlogEntry getFirst() {
		return blog.getFirst();
	}


}
