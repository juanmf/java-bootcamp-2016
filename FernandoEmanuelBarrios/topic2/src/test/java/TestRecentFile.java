import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;

import org.junit.Assert;

/**
 * Created by choco on 29/02/16.
 */
public class TestRecentFile {
    RecentFile list = new RecentFile();
    File file = new File("/home/choco/file1");
    File file1 = new File("");

    /**
     * When the program is run for the first time, the list is empty.
     */
    @Test
    public void IsEmptyTest() {
        Assert.assertTrue(list.isEmpty());
    }

    /**
     * When a file is opened, it is added to the recent file list.
     */
    @Test
    public void addRecentFileTest() {

        list.addRecentFile(file);
        Assert.assertNotNull(list.getFirst());

    }

    /**
     * If an opened file already exists in the recent file list, it is bumped to the top, not duplicated in the list.
     */
    @Test
    public void doesNotAcceptDuplicateTest() {
        list.addRecentFile(file1);
        list.addRecentFile(file);
        list.addRecentFile(file1);
        Assert.assertEquals(file1, list.getFirst());

    }

    @Test
    public void showRecentListTest() {
        list.clearList();
        File file;
        for (int i = 1; i < 16; i++) {
            file = new File("/home/" + i + ".txt");
            list.addRecentFile(file);
        }
        File archTest = new File("/home/16.txt");
        list.addRecentFile(archTest);


        Assert.assertEquals(archTest, list.getFirst());
        Assert.assertEquals(15, list.size());


    }
}
