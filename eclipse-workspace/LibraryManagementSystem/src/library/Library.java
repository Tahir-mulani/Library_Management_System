package library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private static final String FILE_NAME = "library_data.dat";

    public Library() {
        books = loadBooks();
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooks();
        System.out.println("✅ Book added successfully");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("❌ No books available");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book searchBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void issueBook(int id) {
        Book book = searchBook(id);
        if (book == null) {
            System.out.println("❌ Book not found");
        } else if (book.isIssued()) {
            System.out.println("❌ Book already issued");
        } else {
            book.issueBook();
            saveBooks();
            System.out.println("✅ Book issued");
        }
    }

    public void returnBook(int id) {
        Book book = searchBook(id);
        if (book == null) {
            System.out.println("❌ Book not found");
        } else if (!book.isIssued()) {
            System.out.println("❌ Book was not issued");
        } else {
            book.returnBook();
            saveBooks();
            System.out.println("✅ Book returned");
        }
    }

    @SuppressWarnings("unchecked")
    private List<Book> loadBooks() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Book>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void saveBooks() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
