package main;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentFileList {

	private List<File> myList = new ArrayList<File>();
	
	public RecentFileList(){
	
	}

	public void addFile(File file1) {
		if(myList.contains(file1)){
			File temp1;
			File temp2;
			
			Iterator<File> it = myList.iterator();
			temp1 = it.next();
			while(it.hasNext()){
				temp2 = it.next();
				if(temp1.equals(temp2)){
					it.remove();
				}
			}
		}
		
		myList.add(file1);
	}

	public File getFile(File file) {
		if(myList.contains(file)){
			return file;
		}
		else{
			System.out.println("Filenot found in list.");
		}
		return null;
	}

	public List<File> getList() {
		return myList;
	}
	
	public void removeLast(List<File> myList){
		if(myList.size()>15){
			myList.remove(myList.size());
		}
	}
}
