package main;

public class MockBlog {

	String author;
	String subject;
	String post;
	
	public MockBlog(String author, String subject, String post) {
		super();
		this.author = author;
		this.subject = subject;
		this.post = post;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb  = new StringBuilder();
		sb.append(this.getAuthor()).append(this.getSubject()).append(this.getClass()).append(this.hashCode());
		return sb.toString();
	}

}