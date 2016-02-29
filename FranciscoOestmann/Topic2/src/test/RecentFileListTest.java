package test;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;

import main.RecentFileList;

public class RecentFileListTest {

	private RecentFileList newList = new RecentFileList();
	File file1 = new File("");
	File file2 = new File("//home//Test.txt");
	
	@Test
	//Checks if list is empty
	public void testEmptyList() {
		assertTrue(newList.getList().isEmpty());
	}

	@Test
	//Checks if the file was added and if the file is not duplicated
	public void testIfFileWassAddedOnOpening(){
		newList.addFile(file1);
		newList.addFile(file2);
		newList.addFile(file1);
		assertTrue(newList.getList().contains(file1));
	}
	
	@Test
	//Checks if the list has less than 16 elements
	public void checkIfListSizeIsLargerThan15(){
		File fileTest;
		for(int i=0; i<15; i++){
			fileTest = new File("//home " + i);
			newList.addFile(fileTest);
		}
		assertEquals(15, newList.getList().size());
	}
}
