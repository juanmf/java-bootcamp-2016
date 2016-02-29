import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * Created by choco on 29/02/16.
 */
public class Blog {
    ArrayDeque<BlogEntry> blog;

    public Blog() {
        blog = new ArrayDeque<BlogEntry>();
    }

    public void addNewEntry(BlogEntry blogEntry) {
        if (blog.contains(blogEntry)) {
            deleteExistingEntry(blogEntry);
        }
        blog.addLast(blogEntry);
    }

    public void deleteExistingEntry(BlogEntry blogEntry) {
        blog.remove(blogEntry);
    }

    public boolean isEmpty() {
        return blog.isEmpty();
    }

    public int size() {
        return blog.size();
    }

    public ArrayDeque<BlogEntry> topBlogEntries() {
        ArrayDeque<BlogEntry> top = new ArrayDeque<BlogEntry>();
        Iterator<BlogEntry> it = blog.iterator();
        for (int i = 0; i < 10 && it.hasNext(); i++) {
            top.addLast(it.next());
        }
        return top;
    }
}
