package Exercise_2;

import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private int stock;

    public Book(String t, String a, String i, double p, int s) {
        this.title = t;
        this.author = a;
        this.isbn = i;
        this.price = p;
        this.stock = s;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getISBN() { return isbn; }
    public int getStock() { return stock; }

    public void setStock(int s) { stock = s; }
    public boolean borrow() {
        if (stock > 0) {
            stock--;
            return true;
        }
        return false;
    }

    public void displayDetails() {
        System.out.print("Title: " + title + ", Author: " + author + 
                         ", ISBN: " + isbn + ", Price: $" + price + ", Stock: " + stock);
    }
};

class EBook extends Book {
    private double fileSize;

    public EBook(String t, String a, String i, double p, int s, double fs) {
        super(t, a, i, p, s);
        this.fileSize = fs;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(", File Size: " + fileSize + " MB");
    }
};

class PrintedBook extends Book {
    private int pageCount;

    public PrintedBook(String t, String a, String i, double p, int s, int pc) {
        super(t, a, i, pc, s);
        this.pageCount = pc;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(", Pages: " + pageCount);
    }
};

class Library {
    private List<Book> books; 

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayAllBooks() {
        System.out.println("\n--- Library Catalog ---");
        for (Book b : books) {
            b.displayDetails();
        }
    }

    public void searchByTitle(String title) {
        System.out.println("\nSearching for title: " + title);
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.displayDetails();
                found = true;
            }
        }
        if (!found) System.out.println("Book not found.");
    }
    
    public void searchByAuthor(String author) {
        System.out.println("\nSearching for title: " + author);
        boolean found = false;
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                b.displayDetails();
                found = true;
            }
        }
        if (!found) System.out.println("Book not found.");
    }
    public void borrowBook(String isbn) {
        System.out.println("\nAttempting to borrow ISBN: " + isbn);
        for (Book b : books) {
            if (b.getISBN().equals(isbn)) {
                if (b.getStock() > 0) {
                    b.setStock(b.getStock() - 1);
                    System.out.println("Borrow successful! New stock: " + b.getStock());
                } else {
                    System.out.println("Out of stock!");
                }
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        // Add books
        lib.addBook(new EBook("Clean Code", "Robert Martin", "1111", 30.0, 5, 2.5));
        lib.addBook(new PrintedBook("The Great Gatsby", "F. Scott Fitzgerald", "2222", 15.0, 2, 180));
        lib.addBook(new EBook("Java Basics", "John Doe", "3333", 45.0, 0, 5.0));

        // Display
        lib.displayAllBooks();

        // Search
        lib.searchByTitle("Clean Code");

        // Borrow
        lib.borrowBook("2222"); // Success
        lib.borrowBook("3333"); // Fail

        // Display again
        lib.displayAllBooks();
    }
}