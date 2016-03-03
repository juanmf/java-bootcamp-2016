package test.java;

import static org.junit.Assert.*;
import java.util.ArrayDeque;
import java.util.Iterator;
import org.junit.Test;
import main.Blog;
import main.BlogEntry;

public class BlogTest {

    /**
     * Tests if the blog can add an entry.
     */
    @Test
    public void postANewEntryOnTheBlog() {
        Blog b = new Blog();
        BlogEntry entry = new BlogEntry("anonymous", "entry title", "entry text");
        b.add(entry);
        assertEquals(true, b.containsEntry(entry));
    }
    /**
     * Tests if the blog can remove an entry.
     */
    @Test
    public void deleteAnEntry () {
        Blog b = new Blog();
        BlogEntry entry = new BlogEntry("anonymous", "entry title", "entry text");
        b.add(entry);
        assertEquals(true, b.containsEntry(entry));
        b.remove(entry);
        assertEquals(false, b.containsEntry(entry));
    }
    /**
     * Tests if the blog can retrieve the 10 newest entries.
     */
    @Test
    public void showTenMostRecentEntries() {
        Blog b = new Blog();
        for (int i = 1; i < 13; i++) {
            BlogEntry entry = new BlogEntry("anonymous", "entry title "+i, "entry text "+i);
            b.add(entry);
        }
        ArrayDeque<BlogEntry> lastTen = b.getLastTen();
        assertTrue(lastTen.size() <= 10);
        assertEquals("entry title 12", lastTen.getFirst().getTitle());
        assertEquals("entry title 3", lastTen.getLast().getTitle());
        Iterator<BlogEntry> iterator = lastTen.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

}