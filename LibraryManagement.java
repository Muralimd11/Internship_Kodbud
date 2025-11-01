import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void display() {
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("Year  : " + year);
        System.out.println("----------------------");
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> library = new ArrayList<>();
        int choice;

        System.out.println("=== Welcome to Library Management System ===");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add New Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Remove a Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter publication year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();

                    library.add(new Book(title, author, year));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    if (library.isEmpty()) {
                        System.out.println("No books available in the library.");
                    } else {
                        System.out.println("\n=== All Books in Library ===");
                        for (Book b : library) {
                            b.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    boolean found = false;

                    for (Book b : library) {
                        if (b.title.equalsIgnoreCase(searchTitle)) {
                            System.out.println("\nBook Found:");
                            b.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter title of the book to remove: ");
                    String removeTitle = scanner.nextLine();
                    boolean removed = false;

                    for (int i = 0; i < library.size(); i++) {
                        if (library.get(i).title.equalsIgnoreCase(removeTitle)) {
                            library.remove(i);
                            System.out.println("Book removed successfully!");
                            removed = true;
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1-5.");
            }

        } while (choice != 5);

        scanner.close();
    }
}