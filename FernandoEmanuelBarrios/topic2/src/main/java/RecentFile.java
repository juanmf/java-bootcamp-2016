import java.util.ArrayDeque;
import java.io.File;

/**
 * Created by choco on 28/02/16.
 * ____
 * When a file is opened, it is added to the recent file list.
 * If an opened file already exists in the recent file list, it is bumped to the top, not duplicated in the list.
 * If the recent file list gets full (typical number of items is 15), the oldest item is
 * removed when a new item is added.
 */
public class RecentFile {
    private ArrayDeque<File> list = new ArrayDeque<File>();

    /**
     * add to recent file list
     */
    public void addRecentFile(File file) {

        if (list.contains(file)) {
            list.remove(file);
        }
        if (list.size() == 15) {
            list.removeLast();

        }
        list.addFirst(file);
    }

    /**
     * if not contains files return false
     */
    public boolean isEmpty() {

        return list.isEmpty();
    }

    /**
     * show the fist file in the list
     */
    public File getFirst() {

        if (list.isEmpty()) {
            System.out.println("Empty list, don't files to show");
            return null;

        }
        return list.getFirst();
    }

    /**
     * show the last file in the list
     */
    public File getLast() {

        if (list.isEmpty()) {
            System.out.println("Empty list, don't files tu show");
            return null;
        }
        return list.getLast();
    }

    /**
     * show all files in the list
     */
    public ArrayDeque<File> showRecentList() {


        return list;
    }

    public int size() {
        return list.size();
    }

    public void clearList() {
        list.clear();
    }


}
