package com.Topic2;

import java.util.ArrayDeque;

/**
 * @author	Mariano Maderna
 * @since:	1.0
 * @version:1.0
 */

public class RecentFileList {
	
	private ArrayDeque<File> list;
	
	private int size;	 
	
	public RecentFileList(int size) {
		list=new ArrayDeque<File>();
		this.size=size;
	}

	public boolean isEmpty() {
		if(list.size()==0){
			return true;
		}
		return false;
	}
	
	public void addThis(File file) {
		if(list.contains(file)){
			list.remove(file);
			list.addFirst(file);
		}else{
			if(list.size()<size){
				list.addFirst(file);
			}else{
				list.removeLast();
				list.addFirst(file);
			}
		}
	}

	public File getFirstFile() {
		return list.getFirst();
	}
	
	public File getLastFile(){
		return list.getLast();
	}
	
	public int getNumOfElem(){
		return list.size();
	}
}
