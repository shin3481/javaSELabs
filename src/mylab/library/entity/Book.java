package mylab.library.entity;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int publishYear;
    private boolean isAvailable;

    // 기본 생성자
    public Book() {
        this.isAvailable = true;
    }

    // 모든 필드를 초기화하는 생성자
    public Book(String title, String author, String isbn, int publishYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.isAvailable = true;
    }

    // Getter & Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // 도서 대출 처리
    public boolean checkOut() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    // 도서 반납 처리
    public void returnBook() {
        isAvailable = true;
    }

    // 도서 정보 출력
    @Override
    public String toString() {
        return String.format(
            "책 제목: %s\t저자: %s\tISBN: %s\t출판년도: %d\t대출 가능 여부: %s",
            title, author, isbn, publishYear, isAvailable ? "가능" : "대출 중"
        );
    }
}
