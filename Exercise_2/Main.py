class Book:
    def __init__(self, title, author, isbn, price, stock):
        self._title = title
        self._author = author
        self._isbn = isbn
        self._price = price
        self._stock = stock

    # Getters
    def get_title(self): return self._title
    def get_author(self): return self._author
    def get_isbn(self): return self._isbn
    def get_stock(self): return self._stock

    # Setter
    def set_stock(self, stock): self._stock = stock

    # Display method
    def display_details(self):
        print(f"Title: {self._title}, Author: {self._author}, ISBN: {self._isbn}, Price: ${self._price}, Stock: {self._stock}", end="")

class EBook(Book):
    def __init__(self, title, author, isbn, price, stock, file_size):
        super().__init__(title, author, isbn, price, stock)
        self._file_size = file_size

    def display_details(self):
        super().display_details()
        print(f", File Size: {self._file_size} MB")

class PrintedBook(Book):
    def __init__(self, title, author, isbn, price, stock, page_count):
        super().__init__(title, author, isbn, price, stock)
        self._page_count = page_count

    def display_details(self):
        super().display_details()
        print(f", Pages: {self._page_count}")

class Library:
    def __init__(self):
        self.books = [] 

    def add_book(self, book):
        self.books.append(book)

    def display_all_books(self):
        print("\n--- Library Catalog ---")
        for book in self.books:
            book.display_details()

    def search_by_title(self, title):
        print(f"\nSearching for title: {title}")
        found = False
        for book in self.books:
            if book.get_title().lower() == title.lower():
                book.display_details()
                found = True
        if not found:
            print("Book not found.")

    
    def search_by_author(self, author):
        print(f"\nSearching for title: {author}")
        found = False
        for book in self.books:
            if book.get_author().lower() == author.lower():
                book.display_details()
                found = True
        if not found:
            print("Book not found.")


    def borrow_book(self, isbn):
        print(f"\nAttempting to borrow ISBN: {isbn}")
        for book in self.books:
            if book.get_isbn() == isbn:
                if book.get_stock() > 0:
                    book.set_stock(book.get_stock() - 1)
                    print(f"Borrow successful! New stock: {book.get_stock()}")
                else:
                    print("Out of stock!")
                return
        print(f"Book with ISBN {isbn} not found.")

# --- MAIN ---
if __name__ == "__main__":
    lib = Library()

    # Add books
    lib.add_book(EBook("Clean Code", "Robert Martin", "1111", 30.0, 5, 2.5))
    lib.add_book(PrintedBook("The Great Gatsby", "F. Scott Fitzgerald", "2222", 15.0, 2, 180))
    lib.add_book(EBook("Python 101", "Jane Doe", "3333", 45.0, 0, 5.0))

    # Display
    lib.display_all_books()

    # Search
    lib.search_by_title("clean code")

    # Borrow
    lib.borrow_book("2222")
    lib.borrow_book("3333")

    # Display again
    lib.display_all_books()