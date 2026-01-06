package library;

import java.util.Scanner;

public class LibraryAPP {

    public static void main(String[] args) {

        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== LIBRARY MENU ======");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    library.addBook(new Book(id, title, author));
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    int searchId = sc.nextInt();
                    Book book = library.searchBook(searchId);
                    System.out.println(book != null ? book : "❌ Book not found");
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    library.issueBook(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    library.returnBook(sc.nextInt());
                    break;

                case 6:
                    System.out.println("👋 Exiting system...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid option");
            }
        }
    }
}
