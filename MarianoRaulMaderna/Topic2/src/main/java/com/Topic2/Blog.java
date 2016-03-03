package com.Topic2;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * @author	Mariano Maderna
 * @since:	1.0
 * @version:1.0
 */

public class Blog {
	
	private ArrayDeque<BlogEntry> bEntry;
	
	public Blog(){
		bEntry = new ArrayDeque<BlogEntry>();
	}
	
	public void add(BlogEntry entry) {
		bEntry.addFirst(entry);
	}

	public boolean containsEntry(BlogEntry entry) {
		return bEntry.contains(entry);
	}

	public void remove(BlogEntry entry) {
		bEntry.remove(entry);
		
	}

	public ArrayDeque<BlogEntry> getLastTen() {
		ArrayDeque<BlogEntry> lastTen = new ArrayDeque<BlogEntry>();
		Iterator<BlogEntry> iterator= bEntry.iterator();
		int i=0;
		while(i<10){
			lastTen.addLast(iterator.next());
			i++;
		}
		return lastTen;
	}

}
