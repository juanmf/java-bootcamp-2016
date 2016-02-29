/**
 * Created by choco on 29/02/16.
 */
public class Main {
    public static void main(String[] args){
        BlogEntry entry1=new BlogEntry("choco","dir","calle falsa 123");
        BlogEntry entry=new BlogEntry("choco","dir","calle falsa 123");

        Blog blog=new Blog();
        blog.addNewEntry(entry);

    }





}
