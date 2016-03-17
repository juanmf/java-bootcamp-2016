package com.topic1;

/**
 * @author cota
 *
 */
public class BlogEntry {

	private String title;
	private String author;
	private String body;

	public BlogEntry(String title, String author, String body) {
		this.title = title;
		this.author = author;
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof BlogEntry && title.equalsIgnoreCase(((BlogEntry) obj).getTitle());
	}

	@Override
	public int hashCode() {
		return title != null ? title.hashCode() : 0;
	}

}
