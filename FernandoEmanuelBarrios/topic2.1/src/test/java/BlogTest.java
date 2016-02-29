import org.junit.Assert;
import org.junit.Test;

/**
 * Created by choco on 29/02/16.
 */
public class BlogTest {
    Blog blog = new Blog();


    /**
     * Post new entry
     */
    @Test
    public void postNewEntry() {
        BlogEntry entry=new BlogEntry("Homero","direccion","Av.siempreviva 742 ");
        blog.addNewEntry(entry);
        Assert.assertFalse(blog.isEmpty());

        for (int i = 1; i <= 10; i++) {
            BlogEntry entry1 = new BlogEntry("Homero", "direccion", "Av.siempreviva " + i);
            blog.addNewEntry(entry1);
        }
    }

    /**
     * Delete existing entry
     */
    @Test
    public void deleteExistingEntryTest(){
        BlogEntry entry1=new BlogEntry("Homero","direccion","Av.siempreviva 742 ");
        blog.addNewEntry(entry1);
        Assert.assertFalse(blog.isEmpty());
        blog.deleteExistingEntry(entry1);
        Assert.assertTrue(blog.isEmpty());
    }

    /**
     * Show 10 most recent entries
     */
    @Test
    public void topNewEntriesTest(){
        for (int i = 1; i <= 11; i++) {
            BlogEntry entry1 = new BlogEntry("Homero", "direccion", "Av.siempreviva " + i);
            blog.addNewEntry(entry1);
        }

        Assert.assertEquals(10,blog.topBlogEntries().size());
    }

}
