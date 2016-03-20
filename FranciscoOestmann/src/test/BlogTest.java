
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Blog;
import main.BlogEntry;

public class BlogTest {
	
	Blog tddForBeginners;
	BlogEntry be;

	@Before
	public void setup(){
		tddForBeginners = new Blog();
		be = new BlogEntry("Frannz", "TDD", "It's HAAARDDDD!!!!!");
	}
	
	@Test
	public void testIFPostGetsAddedToList() {
		tddForBeginners.addPost(be);
		assertFalse(tddForBeginners.isEmpty());
	}
	
	@Test
	public void testIFPostGetsRemovedFromList(){
		tddForBeginners.addPost(be);
		tddForBeginners.deletePost(be);
		assertTrue(tddForBeginners.isEmpty());
	}
	
	@Test
	public void testShowTenLastPost(){
		for(int i = 0; i<15; i++){
			tddForBeginners.addPost(new BlogEntry("Frannz", "TDD", "It's HAAARDDDD!!!!!" + i));
		}
		
		assertEquals(10, tddForBeginners.printLastPosts());
		
	}
	
	@After
	public void teardown(){
		tddForBeginners = null;
		be = null;
	}

}