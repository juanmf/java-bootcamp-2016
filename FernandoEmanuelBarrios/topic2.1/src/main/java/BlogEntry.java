/**
 * Created by choco on 29/02/16.
 */
public class BlogEntry {
    private String author;
    private String tittle;
    private String text;

    public BlogEntry(String author, String text, String tittle) {
        this.author = author;
        this.text = text;
        this.tittle = tittle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    @Override
    public boolean equals(Object o) {
        return o!=null && o instanceof BlogEntry && tittle.equalsIgnoreCase(((BlogEntry)o).getTittle());

    }

}
