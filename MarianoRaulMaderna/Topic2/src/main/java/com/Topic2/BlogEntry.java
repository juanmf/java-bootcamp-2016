package com.Topic2;

/**
 * @author	Mariano Maderna
 * @since:	1.0
 * @version:1.0
 */
public class BlogEntry {
	
	private String autor;
	private String title;
	
	public BlogEntry(String autor, String title) {
		this.autor=autor;
		this.title=title;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String toString(){
		return "Autor: " + autor + "Title: " + title;
	}

}
