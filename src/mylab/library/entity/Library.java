package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;

    // ������
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // ���� �߰�
    public void addBook(Book book) {
        books.add(book);
        System.out.println("������ �߰��Ǿ����ϴ�: " + book.getTitle());
    }

    // �������� ���� �˻�
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // ���ڸ����� ���� �˻�
    public List<Book> findBooksByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                results.add(book);
            }
        }
        return results;
    }

    // ISBN���� ���� �˻�
    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    // ���� ����
    public boolean checkOutBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null) {
            return book.checkOut();
        }
        return false;
    }

    // ���� �ݳ�
    public boolean returnBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null) {
            book.returnBook();
            return true;
        }
        return false;
    }

    // ���� ������ ���� ��� ��ȯ
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    // ��ü ���� ��� ��ȯ
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    // ��ü ���� �� ��ȯ
    public int getTotalBooks() {
        return books.size();
    }

    // ���� ������ ���� �� ��ȯ
    public int getAvailableBooksCount() {
        int count = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    // ���� ���� ���� �� ��ȯ
    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }

    // ������ �̸� ��ȯ
    public String getName() {
        return name;
    }

    // ������ �̸� ����
    public void setName(String name) {
        this.name = name;
    }
}