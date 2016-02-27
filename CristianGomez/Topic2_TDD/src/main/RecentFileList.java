package main;

import java.io.File;
import java.util.ArrayDeque;

/**
 * Class that represents a Recent File List.
 * @author cristian
 * @since 1.0
 * @version 1.0
 */

public class RecentFileList {

    /**
     * Variable that represents the Recent File List.
     */
    private ArrayDeque<File> list;
    /**
     * Maximum size of the Recent File List.
     */
    private int maxSize;

    public RecentFileList(int maxSize) {
        list = new ArrayDeque<File>();
        this.maxSize = maxSize;
    }

    /**
     * Returns a boolean value according to the number of elements in the list.
     * 
     * @return true is the list is empty, false if it has at lease one element.
     */
    public boolean isEmpty() {
        if (list.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Adds a file to the Recent File List.
     * In case the file is already on the list, it is bumped to the first position.
     * In case the list is full, it removes the last element from it
     * and adds the file at the first position.
     * @param file File that will be added to the list.
     */
    public void add(File file) {
        if (list.contains(file)) {
            list.remove(file);
            list.addFirst(file);
        } else {
            if (list.size() < maxSize) {
                list.addFirst(file);
            } else {
                list.removeLast();
                list.addFirst(file);
            }
        }
    }
    /**
     * Retrieves the first element of the Recent File List without removing it from the list. 
     * @return A File object that represents the first file on the list.
     */
    public File getFirst() {
        return list.getFirst();
    }
    /**
     * Retrieves the number of files on the Recent File List.
     * @return Size of the list.
     */
    public int getNumberOfElements() {
        return list.size();
    }
    /**
     * Retrieves the last element of the Recent File List without removing it from the list.
     * @return A File object that represents the last file on the list.
     */
    public File getLast() {
        return list.getLast();
    }
}