package com.topic1;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

/**
 * @author cota
 *
 */
public class RecentFileListTest {
	private RecentFileList fileList = new RecentFileList();
	File arch = new File("");
	File arch1 = new File("/home/cota/file1");

	/**
	 * When the program is run for the first time, the list is empty.
	 */
	@Test
	public void getTheRecentFilesForFirstTimeTest() {

		assertTrue(fileList.isEmpty());
	}

	/**
	 * When a file is opened, it is added to the recent file list.
	 */
	@Test
	public void whenFileIsOpenedItsAddedToTheRecentFileListTest() {
		fileList.addFile(arch);
		assertNotNull(fileList.getFirstElement());
	}

	/**
	 * If an opened file already exists in the recent file list, it is bumped to
	 * the top, not duplicated in the list.
	 */
	@Test
	public void notAcceptedDuplicatedFilesInTheListTest() {
		// File arch2 = new File("/home/cota/file2");
		fileList.addFile(arch1);
		fileList.addFile(arch);
		fileList.addFile(arch1);
		assertEquals(arch1, fileList.getFirstElement());
	}

	/**
	 * If the recent file list gets full (typical number of items is 15), the
	 * oldest item is removed when a new item is added.
	 */
	@Test
	public void whenTheListIsFullTheOldestIsRemovedTest() {
		
		File file;
		for (int i = 1; i < 16; i++) {
			file = new File("/home/" + i + ".txt");
			fileList.addFile(file);
		}
		File archTest = new File("/home/16.txt");
		fileList.addFile(archTest);
		
		
		assertEquals(archTest, fileList.getFirstElement());
		assertEquals(15, fileList.sizeOfList());
	}
	
	@Test
	public void isEmptyTest(){
		assertTrue(fileList.isEmpty());
	}
	
	@Test
	public void clearListTest(){
		fileList.addFile(arch);
		assertFalse(fileList.isEmpty());
		fileList.clearList();
		assertTrue(fileList.isEmpty());
	}
	
	@Test
	public void sizeOfListTest(){
		fileList.addFile(arch);
		assertEquals(1, fileList.sizeOfList());
	}
}
