package main;

/**
 * Class that represents a blog entry.
 * @author cristian
 * @since 1.0
 * @version 1.0
 */
public class BlogEntry {
    private String author;
    private String title;
    private String text;

    public BlogEntry(String author, String title, String text) {
        this.author = author;
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }
    public String toString() {
        return "Author: "+author+" Entry Title: "+title+ " Entry Text: "+text;
    }

}