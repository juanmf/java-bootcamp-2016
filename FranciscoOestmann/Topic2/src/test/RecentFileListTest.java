package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.RecentFileList;

public class RecentFileListTest {

	RecentFileList obj = new RecentFileList();
	
	@Test
	public void checkClassObjectNotNull(){
		assertNotNull(obj);
	}
	
	@Test
	public void checkCreatedArrayList(){
		
		//Checks if the ArrayList was instantiated
		assertNotNull(obj.createList());
		
		//Checks if the ArrayList is empty
		assert obj.createList().isEmpty();
	}
	
	@Test
	public void checkIfFileWasOpened(){
		assertNotNull(obj.openFile());
		
	}
	
}
