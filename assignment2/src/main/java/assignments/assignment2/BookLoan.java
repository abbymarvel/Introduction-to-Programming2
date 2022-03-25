package assignments.assignment2;

public class BookLoan {
    private static long DENDA_PER_HARI;
    private Member member;
    private Book book;
    private String loanDate;
    private String returnDate;
    private long fine;
    private boolean status;

    public BookLoan(long DENDA_PER_HARI, Book book, String loanDate, String returnDate, long fine, boolean status){
        this.DENDA_PER_HARI = DENDA_PER_HARI;
        this.book = book;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.fine = fine;
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public long getFine() {
        return fine;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }
}
