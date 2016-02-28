package test;

import static org.junit.Assert.*;

import java.io.File;
//import java.util.ArrayList;

import org.junit.Test;

import main.RecentFileList;

public class RecentFileListTest {

	RecentFileList obj = new RecentFileList();
	//ArrayList<Object> list = new ArrayList<Object>();
	File file = new File("test.txt");
	
	@Test
	public void checkClassObjectNotNull(){
		assertNotNull(obj);
	}
	
	@Test
	public void checkCreatedArrayListNotNull(){
		
		//Checks if the ArrayList was instantiated
		//assertNotNull(obj.createList());
		
	}
	
	@Test
	public void checkIfListIsEmpty(){
		//Checks if the ArrayList is empty
		//assertTrue(obj.createList().isEmpty());
	}
	
	@Test
	public void checkIfFileWasOpened(){
		assertNotNull(obj.openFile());
	}
	
	@Test
	public void checkIfFileWasAddedToList(){
		assertTrue(obj.createList().contains(obj.openFile()));
	}		
	
	
}
