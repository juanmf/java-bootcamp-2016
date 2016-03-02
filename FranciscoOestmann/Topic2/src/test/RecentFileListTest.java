package test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import main.RecentFileList;

public class RecentFileListTest {

	RecentFileList list = new RecentFileList();
	File file = new File("frann/home/test1");
	File file2 = new File("frann/home//test2");
	
	@Test
	//checks if the list it's empty
	public void testIfListIsEmpty() {
		assertTrue(list.isEmpty());
	}
	
	@Test
	//Checks if the file was added and it's not duplicated
	public void testIFFileWasAddedToListAndisNotDuplicated(){
		list.addFileToList(file);
		list.addFileToList(file2);
		list.addFileToList(file);
		assertTrue(list.contains(file));
	}
	
	@Test
	//Checks if the list has less than 16 elements
	public void checkIfListSizeIsLargerThan15(){
		
		for(int i=0; i<15; i++){
			list.addFileToList(new File("frann/home/ " + i));
		}
		
		assertEquals(15, list.size());
	}
}