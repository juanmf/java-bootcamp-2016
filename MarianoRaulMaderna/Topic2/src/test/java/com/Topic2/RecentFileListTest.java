package com.Topic2;

import static org.junit.Assert.*;
import org.junit.Test;
import com.Topic2.RecentFileList;

public class RecentFileListTest{
    
	/**
	 *RecentFileList is created
	 *Check if the list is empty
	 * */
	
	//When the program is run for the first time, the list is empty
	@Test
    public void isRunForTheFirstTimeAndTheListIsEmpty() {
        RecentFileList reFiLi = new RecentFileList(15);
        assertEquals(true, reFiLi.isEmpty());
    }
    
	/**
	 * RecentFileList is created
	 * and when a file is opened it is
	 * added to the list.
	 * Check if the first file is the same that the opened.
	 */
	
	/*When a file is opened, it is added to the recent file list*/
    @Test
    public void aFileIsOpenedAndAddedToTheFileList(){
    	RecentFileList reFiLi = new RecentFileList(15);
    	File file = new File("C:\\file.txt");
    	reFiLi.addThis(file);
    	assertEquals(reFiLi.getFirstFile(), file);
    }
    
    /**
     * RecentFileList is created
     * And a file is opened
     * 
     * Add file to the list
     * Other file is opened
     * 
     * Add the other file to the list to the top
     * Checks if otherFile is equals to the firstFile
     * 
     * Add file to the list Again
     * (if it exist, is bumped to the top of the list)
     * Checks if the file is equals to the first file
     */
    /*If an opened file already exists in the recent file list, 
     *it is bumped to the top, not duplicated in the list.*/
    @Test
    public void ifAnFileOpenedExistBumpToTheTop(){
    	RecentFileList reFiLi = new RecentFileList(15);
    	File file = new File("C:\\file.txt");
    	
    	reFiLi.addThis(file);
    	File otherFile= new File("C:\\otherFile.txt");
    	
    	reFiLi.addThis(otherFile);
    	assertEquals(otherFile, reFiLi.getFirstFile());
    	
    	reFiLi.addThis(file);
    	assertEquals(file, reFiLi.getFirstFile());
    }
    
    /**
     * 
     */
    /*If the recent file list gets full (typical number of items is 15),
     *the oldest item is removed when a new item is added. */
    @Test
    public void ifFileListGetsFullTheOldestItemIsremovedAndANewOneIsAdded() {
    	RecentFileList reFiLi = new RecentFileList(15);
    	File file = new File("");
        for (int i = 1; i < 16; i++) {
            file = new File("C:\\file" + i + ".txt");
            reFiLi.addThis(file);
        }
        
        assertEquals(15, reFiLi.getNumOfElem());
        assertEquals("C:\\file1.txt", reFiLi.getLastFile().getFileName());
        file = new File("C:\\otherFile.txt");
        reFiLi.addThis(file);
       
        assertEquals(15, reFiLi.getNumOfElem());
        assertEquals(file, reFiLi.getFirstFile());
        assertNotSame("C:\\file15.txt", reFiLi.getLastFile().getFileName());

    }
}
