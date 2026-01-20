#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Book {
private:
    string title;
    string author;
    string ISBN;
    double price;
    int stock;

public:
    Book(string t, string a, string i, double p, int s) 
        : title(t), author(a), ISBN(i), price(p), stock(s) {}

    virtual ~Book() {}

    string getTitle() { return title; }
    string getAuthor() { return author; }
    string getISBN() { return ISBN; }
    int getStock() { return stock; }

    void setStock(int s) { stock = s; }
    bool borrow() {
        if (stock > 0) {
            stock--;
            return true;
        }
        return false;
    }

    virtual void displayDetails() {
        cout << "Title: " << title << ", Author: " << author 
             << ", ISBN: " << ISBN << ", Price: $" << price 
             << ", Stock: " << stock;
    }
};

class EBook : public Book {
    private:
        double fileSize;
    public:
        EBook(string t, string a, string i, double p, int s, double fs)
        : Book(t, a, i, p, s), fileSize(fs) {}

    void displayDetails() override {
        Book::displayDetails();
        cout << ", File Size: " << fileSize << " MB" << endl;
    }

};

class PrintedBook : public Book {
private:
    int pageCount;

public:
    PrintedBook(string t, string a, string i, double p, int s, int pc)
        : Book(t, a, i, p, s), pageCount(pc) {}

    void displayDetails() override {
        Book::displayDetails();
        cout << ", Pages: " << pageCount << endl;
    }
};

// 2. Class Library
class Library {
private:
    vector<Book*> books;

public:
    // a. Add new books
    void addBook(Book* b) {
        books.push_back(b);
        cout << "-> Added: " + b->getTitle() << endl;
    }

    // b. Search
    void searchByTitle(string keyword) {
        bool found = false;
        for (auto b : books) {
            if (b->getTitle() == keyword) {
                b->displayDetails();
                found = true;
            }
        }
        if (!found) cout << "No book found." << endl;
    }

    void searchByAuthor(string keyword) {
        bool found = false;
        for (auto b : books) {
            if (b->getAuthor() == keyword) {
                b->displayDetails();
                found = true;
            }
        }
        if (!found) cout << "No book found." << endl;
    }

    // c. Borrow
    void borrowBook(string isbn) {
        for (auto b : books) {
            if (b->getISBN() == isbn) {
                if (b->getStock() > 0) {
                    b->setStock(b->getStock() - 1);
                    cout << "Success! You borrowed" << endl;
                } else {
                    cout << "Failed! Out of stock." << endl;
                }
                return;
            }
        }
        cout << "Book not found." << endl;
    }

    void displayAllBooks() {
        for (auto b : books) {
            b->displayDetails();
        }
    }
};

int main() {
    Library lib;

    // Add books
    lib.addBook(new EBook("Clean Code", "Robert Martin", "1111", 30.0, 5, 2.5));
    lib.addBook(new PrintedBook("The Great Gatsby", "F. Scott Fitzgerald", "2222", 15.0, 2, 180));
    lib.addBook(new EBook("C++ Primer", "Stanley Lippman", "3333", 45.0, 0, 5.0));

    // Display
    lib.displayAllBooks();

    // Search
    lib.searchByTitle("Clean Code");

    // Borrow
    lib.borrowBook("2222"); // Success
    lib.borrowBook("3333"); // Fail (Stock 0)
    
    // Display again to check stock
    lib.displayAllBooks();

    return 0;
}