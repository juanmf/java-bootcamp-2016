package main;

import java.io.File;

public class MainApp {

	public static void main(String[] args) {

		RecentFileList asd = new RecentFileList();
		
		File file1 = new File("asd");
		File file2 = new File("qwe");
		
		asd.addFileToList(file1);
		asd.addFileToList(file2);
		//asd.addFileToList(file1);
		
		
		
		System.out.println(asd.checkDuplicates());
		
	
	}

}
