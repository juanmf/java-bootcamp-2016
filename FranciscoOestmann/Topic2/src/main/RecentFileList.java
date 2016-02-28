package main;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class RecentFileList {
	
	public ArrayList<File> list = new ArrayList<File>();
	Scanner sc = new Scanner(System.in);
	
	public ArrayList<File> createList(){
		list = new ArrayList<File>();
		
		return list;
	}

	public File openFile() {
		File file = new File("path");
		list.add(file);
		return file;
	}
	
	

	

	
}
