package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Blog;
import main.MockBlog;

public class BlogTest {
	
	Blog newPost = new Blog();
	MockBlog mb = new MockBlog("Frannz", "TDD", "It's HAAARDDDD!!!!!"); 

	@Test
	public void testIFPostGetsAddedToList() {
		newPost.addPost(mb);
		assertFalse(newPost.isEmpty());
	}
	
	@Test
	public void testIFPostGetsRemovedFromList(){
		newPost.deletePost(mb);
		assertTrue(newPost.isEmpty());
	}
	
	@Test
	public void testShowTenLastPost(){
		for(int i = 0; i<15; i++){
			newPost.addPost(new MockBlog("Frannz", "TDD", "It's HAAARDDDD!!!!!" + i));
		}
		
		assertEquals(10, newPost.printLastPosts());
		
	}

}
