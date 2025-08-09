package workshop.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;

    // 생성자
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // 도서 추가
    public void addBook(Book book) {
        books.add(book);
        System.out.println("도서가 추가되었습니다: " + book.getTitle());
    }

    // 제목으로 도서 검색
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // 저자명으로 도서 검색
    public List<Book> findBooksByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                results.add(book);
            }
        }
        return results;
    }

    // ISBN으로 도서 검색
    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    // 도서 대출
    public boolean checkOutBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null) {
            return book.checkOut();
        }
        return false;
    }

    // 도서 반납
    public boolean returnBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null) {
            book.returnBook();
            return true;
        }
        return false;
    }

    // 대출 가능한 도서 목록 반환
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    // 전체 도서 목록 반환
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    // 전체 도서 수 반환
    public int getTotalBooks() {
        return books.size();
    }

    // 대출 가능한 도서 수 반환
    public int getAvailableBooksCount() {
        int count = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    // 대출 중인 도서 수 반환
    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }

    // 도서관 이름 반환
    public String getName() {
        return name;
    }
    
    // setName 제거
}