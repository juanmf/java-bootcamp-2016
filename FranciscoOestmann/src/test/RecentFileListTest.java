package test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.RecentFileList;

public class RecentFileListTest {

	RecentFileList list; 
	File file;
	File file2;
	
	@Before
	public void setup(){
		list = new RecentFileList();
		file = new File("frann/home/test1");
		file2  = new File("frann/home//test2");
	}
	
	@Test
	//checks if the list it's empty
	public void testIfListIsEmpty() {
		assertTrue(list.isEmpty());
	}
	
	@Test
	//Checks if the file was added and it's not duplicated
	public void testIFFileWasAddedToListAndisNotDuplicated(){
		/*The addFileToList() checks for duplicates before adding the file
		 * if it finds that the file already exits, the method moves it to the first position
		 * and doesn't added to the list
		 */
		list.addFileToList(file);
		list.addFileToList(file2);
		list.addFileToList(file);
		assertFalse(list.checkDuplicates());
	}
	
	@Test
	//Checks if the list has less than 16 elements
	public void checkIfListSizeIsLargerThan15(){
		
		for(int i=0; i<30; i++){
			list.addFileToList(new File("frann/home/ " + i));
		}
		list.removeLast();
		assertEquals(15, list.size());
	}
	
	@After
	public void teardown(){
		
		list = null;
		file = null;
		file2 = null;
	}
}