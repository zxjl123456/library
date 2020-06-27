package bean;

public class Book {
    private String id;
    private String title;
    private int price;
    private String bookMessage;
   private  String intro;
   private Author author;

    public Book() {
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book(String id, String title, int price, String bookMessage, String intro, Author author) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.bookMessage = bookMessage;
        this.intro = intro;
        this.author = author;
    }

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Book(String id, String title, int price, String intro) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.intro = intro;
    }

    public void setBookMessage(String bookMessage) {
        this.bookMessage = bookMessage;
    }

    public String getBookMessage() {
        return bookMessage;
    }

    public Book(String string, String resultSetString, int anInt, String setString, String s) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book(String resultSetString, String string, int anInt, String title, Object object) {
        this.title = title;
    }

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public Book(String id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", bookMessage='" + bookMessage + '\'' +
                ", intro='" + intro + '\'' +
                ", author=" + author +
                '}';
    }
}

