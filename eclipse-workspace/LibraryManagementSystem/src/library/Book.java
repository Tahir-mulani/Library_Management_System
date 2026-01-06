package library;

import java.io.Serializable;

public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String author;
    private boolean issued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public int getId() {
        return id;
    }

     
    public boolean isIssued() {
        return issued;
    }

 
    public void issueBook() {
        this.issued = true;
    }

    
    public void returnBook() {
        this.issued = false;
    }

    @Override
    public String toString() {
        return id + " | " + title + " | " + author + " | " +
                (issued ? "Issued" : "Available");
    }
}
