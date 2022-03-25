package assignments.assignment2;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private int stok;
    private Category category;

    @Override
    public String toString() {
        // TODO
        return "";
    }

    public Book(String title, String author, String publisher, int stok, Category category){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.stok = stok;
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setStok(int stok){
        this.stok = stok;
    }

    public int getStok(){
        return stok;
    }

    public Category getCategory(){
        return category;
    }
}
