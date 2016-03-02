package main;

import java.util.ArrayList;
import java.util.List;

public class Blog {
	
	List<MockBlog> postList;
	int cont = 0;

	public Blog(){
		postList = new ArrayList<MockBlog>();
	}

	public boolean isEmpty() {
		return postList.isEmpty();
	}

	public void addPost(MockBlog mb) {
		cont++;
		postList.add(mb);
	}

	public void deletePost(MockBlog mb) {
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
