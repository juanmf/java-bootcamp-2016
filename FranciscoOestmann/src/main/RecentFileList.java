package main;

import java.io.File;
import java.util.ArrayList;

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

	public void addFileToList(File file) {
		if(fileList.contains(file)){
			fileList.set(0, file);
		}
		else{
			fileList.add(file);
		}
	}
	
	public void removeLast(){
		while(fileList.size()>15){
			fileList.remove(fileList.size()-1);
		}
	}

	public boolean checkDuplicates() {
        for (int i = 0; i < fileList.size(); i++) {
            for (int j = 0; j < fileList.size(); j++) {
                if (fileList.get(i).equals(fileList.get(j)) && i != j) {
                    return true;
                }
            }
        }
        return false;
	}
	
	public int size() {
		return fileList.size();
	}
	
	
}