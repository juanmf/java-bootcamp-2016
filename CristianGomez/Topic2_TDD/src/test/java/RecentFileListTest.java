package test.java;

import java.io.File;
import org.junit.Test;
import junit.framework.TestCase;
import main.RecentFileList;

public class RecentFileListTest extends TestCase {

    /**
     * Runs the app for the first time and tests if the Recent File List is
     * empty.
     */
    @Test
    public void testAppIsRunForTheFirstTimeAndRecentFileListIsEmpty() {
        RecentFileList rfl = new RecentFileList(15);
        assertEquals(true, rfl.isEmpty());
    }

    /**
     * Runs the app, adds a file and test if the file is added at the first
     * position (most recent) of the list.
     */
    @Test
    public void testFileIsOpenedeAndAddedToTheList() {
        RecentFileList rfl = new RecentFileList(15);
        File file = new File("C:\\pagefile.sys");
        rfl.add(file);
        assertEquals(rfl.getFirst(), file);
    }

    /**
     * Runs the app, adds a file, adds a second file and then it adds the first
     * time again to check if the file is bumped to the first position.
     */
    @Test
    public void testFileIsOpenedAndIsAlreadyOnTheList() {
        RecentFileList rfl = new RecentFileList(15);
        File file = new File("C:\\pagefile.sys");
        rfl.add(file);
        File anotherFile = new File("C:\\eclipse\\eclipse.exe");
        rfl.add(anotherFile);
        assertEquals(anotherFile, rfl.getFirst());
        rfl.add(file);
        assertEquals(file, rfl.getFirst());
    }

    /**
     * Runs the app, fills the Recent File List, it tests if the files were
     * added in the right order and then adds another file to test if the list
     * removes the last file and inserts the new file in the first position.
     */
    @Test
    public void testFileIsOpenedAndRecentFileListIsFull() {
        RecentFileList rfl = new RecentFileList(15);
        File file = new File("");
        for (int i = 1; i < 16; i++) {
            file = new File("C:\\pagefile" + i + ".sys");
            rfl.add(file);
        }
        assertEquals(15, rfl.getNumberOfElements());
        assertEquals(new File("C:\\pagefile1.sys"), rfl.getLast());
        file = new File("C:\\eclipse\\eclipse.exe");
        rfl.add(file);
        assertEquals(15, rfl.getNumberOfElements());
        assertEquals(file, rfl.getFirst());
        assertNotSame(new File("C:\\pagefile15.sys"), rfl.getLast());

    }
}