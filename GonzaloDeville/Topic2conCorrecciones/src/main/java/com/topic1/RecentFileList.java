package com.topic1;

import java.io.File;
import java.util.ArrayDeque;

/**
 * @author cota
 *
 */

public class RecentFileList {

	private ArrayDeque<File> fileList;

	public RecentFileList() {
		fileList = new ArrayDeque<File>();
	}

	/**
	 * @param file
	 */
	public void addFile(File file) {

		if (fileList.contains(file)) {
			fileList.remove(file);
		}
		if (fileList.size() == 15) {
			fileList.removeLast();
		}
		fileList.addFirst(file);

	}

	/**
	 * @return Null in case of empty list or the list of recent files
	 */
	public ArrayDeque<File> getRecentFiles() {
		if (fileList.isEmpty()) {
			System.out.println("Empty list - No files to show");
			return null;
		} else {
			return fileList;
		}
	}

	public File getFirstElement() {
		if (fileList.isEmpty()) {
			System.out.println("Empty list - No files to show");
			return null;
		} else {
			return fileList.getFirst();
		}
	}

	public String getLastElement() {
		if (fileList.isEmpty()) {
			return "Empty list - No files to show";
		} else {
			return fileList.getLast().getAbsolutePath();
		}
	}

	public boolean isEmpty() {
		return fileList.isEmpty();
	}

	public void clearList() {
		fileList.clear();
	}

	public int sizeOfList() {
		return fileList.size();
	}

}
