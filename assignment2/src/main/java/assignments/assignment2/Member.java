package assignments.assignment2;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Member {
    private String id;
    private String name;
    private String dateOfBirth;
    private String studyProgram;
    private String angkatan;
    private long fine;
    private int point;
    private BookLoan[] bookLoans;

    public Member(String id, String name, String dateOfBirth, String studyProgram, String angkatan, long fine, int point){
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.studyProgram = studyProgram;
        this.angkatan = angkatan;
        this.fine = fine;
        this.point = point;
    }

    public void pinjam(Book book, String loanDate) {
        // method untuk melakukan peminjaman oleh member
        if (bookLoans == null){
            bookLoans = new BookLoan[1];
            bookLoans[0] = new BookLoan(3000, book, loanDate, "-", fine, true);
            book.setStok(book.getStok()-1);
            System.out.println(this.name + " berhasil meminjam Buku " + book.getTitle() + "!");
        } else {
            if (bookLoans[0].isStatus() == false) {
                BookLoan[] tempArr = new BookLoan[bookLoans.length + 1];
                for (int i = 0; i < bookLoans.length; i++) {
                    tempArr[i] = bookLoans[i];
                }
                bookLoans = tempArr;
                bookLoans[bookLoans.length - 1] = new BookLoan(3000, book, loanDate, "-", fine, true);
                book.setStok(book.getStok() - 1);
                System.out.println(this.name + " berhasil meminjam Buku " + book.getTitle() + "!");
            }else {
                System.out.println("Buku " + book.getTitle() + " oleh " + book.getAuthor() + " sedang dipinjam");
            }
        }

    }

    public void kembali(Book book, String returnDate) {
        // method untuk melakukan pengembalian oleh member
        String loanDate = "";
        int indexLoanBook = 0;
        for (int j = 0; j<bookLoans.length; j++){
            if (bookLoans[j].getBook().equals(book)){
                loanDate = bookLoans[j].getLoanDate();
                indexLoanBook = j;
            }
        }
        if (bookLoans[indexLoanBook].isStatus() == true) {
            if (bookLoans != null) {
                String d1 = loanDate;
                String d2 = returnDate;

                String pattern = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);

                try {
                    Date date1 = sdf.parse(d1);
                    Date date2 = sdf.parse(d2);

                    // get the difference between two dates in minutes
                    long elapsedms = date1.getTime() - date2.getTime();
                    long diff = TimeUnit.MINUTES.convert(elapsedms, TimeUnit.MILLISECONDS);
                    if (diff > 7) {
                        this.fine += (diff - 7) * 3000;
                    }
                    bookLoans[indexLoanBook].setStatus(false);
                    book.setStok(book.getStok() + 1);
                    setPoint(getPoint()+book.getCategory().getPoint());
                    System.out.println("Buku " + book.getTitle() + " berhasil dikembalikan oleh " + this.name + " dengan denda Rp " + this.fine + "!");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }else {
            System.out.println("Buku " + bookLoans[indexLoanBook].getBook().getTitle() + " tidak sedang dipinjam");
        }
    }

    public void detail() {
        // method untuk menampilkan detail anggota
        if (bookLoans != null) {
            for (int h = 1; h < bookLoans.length+1; h++) {
                for (int i = 0; i < bookLoans.length; i++) {
                    System.out.println("—------------- " + h + " —-------------");
                    Book buku = bookLoans[i].getBook();
                    System.out.println("Judul Buku: " + buku.getTitle());
                    System.out.println("Penulis Buku: " + buku.getAuthor());
                    System.out.println("Penerbit Buku: " + buku.getPublisher());
                    System.out.println("Kategori: " + buku.getCategory().getName());
                    System.out.println("Point: " + buku.getCategory().getPoint());
                    System.out.println("Tanggal Peminjaman: " + bookLoans[i].getLoanDate());
                    System.out.println("Tanggal Pengembalian: " + bookLoans[i].getReturnDate());
                    System.out.println("Denda: Rp " + bookLoans[i].getFine());

                }
            }
        }
    }

    public void bayarDenda(long amount) {
        // method untuk melakukan pembayaran denda
        if (amount>this.fine){
            setFine(0);
            System.out.println(this.name + " berhasil membayar lunas denda");
            System.out.println("Jumlah kembalian: Rp " + (amount - this.fine));
        } else {
            setFine(getFine()-amount);
            System.out.println(this.name + " berhasil membayar denda sebesar Rp " + amount);
            System.out.println("Sisa denda saat ini: Rp " + getFine());

        }
    }

    @Override
    public String toString() {
        return "ID Anggota: " + this.id + "\nNama Anggota: "
                + this.name +"\nTotal Point: " + this.point + "\nDenda: " + this.fine;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getFine() {
        return fine;
    }

    public void setFine(long fine) {
        this.fine = fine;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public BookLoan[] getBookLoans() {
        return bookLoans;
    }
}
