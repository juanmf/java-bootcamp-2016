package main;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentFileList {

	List<File> fileList;
	
	public RecentFileList(){
		
		fileList = new ArrayList<File>();
	}
	
	public boolean isEmpty(){
		return fileList.isEmpty();
	}

	public boolean contains(File file) {
		return fileList.contains(file);
	}

	public List<File> addFileToList(File file) {
		if(fileList.contains(file)){
			fileList.set(0, file);
		}
		else{
			fileList.add(file);
		}
		return fileList;
	}
	
	public void removeLast(){
		while(fileList.size()>15){
			fileList.remove(fileList.size()-1);
		}
	}

	public boolean checkDuplicates() {
		for(Iterator<File> it = fileList.iterator(); it.hasNext();){
			if(it.equals(it.next())){
				return true;
			}
		}
			
		return false;
	}
	
	public int size() {
		return fileList.size();
	}

	
}