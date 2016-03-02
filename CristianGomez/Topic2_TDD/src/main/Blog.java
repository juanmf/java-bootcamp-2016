package main;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * Class that represents a blog.
 * @author Cristian Gomez
 * @since 1.0
 * @version 1.0
 */
public class Blog {
    /**
     * Variable that represents all the entries in the blog.
     */
    private ArrayDeque<BlogEntry> entries;
    
    public Blog() {
        entries = new ArrayDeque<BlogEntry>();
    }

    /**
     * Adds an entry to the blog, entries can be duplicated.
     * @param entry The entry to add to the blog.
     */
    public void add(BlogEntry entry) {
        entries.addFirst(entry);
    }
/**
 * Looks up if a given entry is already on the blog.
 * @param entry The entry to find.
 * @return true if the entry is found, false if not.
 */
    public boolean containsEntry(BlogEntry entry) {
        return entries.contains(entry);
    }
/**
 * Removes an entry from the Blog.
 * @param entry The entry to be removed.
 */
    public void remove(BlogEntry entry) {
        entries.remove(entry);
        
    }
/**
 * Retrieves a list with the 10 latest entries.
 * @return A ArrayDeque object of BlogEntry.
 */
    public ArrayDeque<BlogEntry> getLastTen() {
        ArrayDeque<BlogEntry> lastTen = new ArrayDeque<BlogEntry>();
        Iterator<BlogEntry> iterator = entries.iterator();
        int i=0;
        while(i<10) {
            lastTen.addLast(iterator.next());
            i++;
        }
        return lastTen;
    }

}