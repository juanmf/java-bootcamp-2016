
package main;

import java.util.ArrayList;
import java.util.List;

public class Blog {
	
	List<BlogEntry> postList;
	int cont = 0;

	public Blog(){
		postList = new ArrayList<BlogEntry>();
	}

	public boolean isEmpty() {
		return postList.isEmpty();
	}

	public void addPost(BlogEntry mb) {
		cont++;
		postList.add(mb);
	}

	public void deletePost(BlogEntry mb) {
		postList.remove(mb);
		
	}

	public int printLastPosts() {
		int i = 0;
		for(; i<10; i++){
			System.out.println(postList.get(i).toString());
		}
		return i;
	}
		

}